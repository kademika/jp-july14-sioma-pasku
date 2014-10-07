package com.kademika.day13.а5;

import com.kademika.day11.f6.BufferReader;
import com.kademika.day13.f1.Utils;
import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by Админ on 01.09.2014.
 */
public class NonblockingSelectServer {
    private static Map<SocketChannel, Queue<ByteBuffer>> pendinData = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("localhost", 8080));
        ssc.configureBlocking(false);
        Selector select = Selector.open();
        ssc.register(select, SelectionKey.OP_ACCEPT);
        while (true) {
            select.select();
            for (Iterator<SelectionKey> keyIterator = select.selectedKeys().iterator(); keyIterator.hasNext(); ) {
                SelectionKey key = keyIterator.next();
                keyIterator.remove();
                if (key.isAcceptable()) {
                accept(key);
                } else if (key.isWritable()) {
                    write(key);
                } else if (key.isReadable()) {
                    read(key);
                }
            }
        }
    }

    public static void write(SelectionKey key) throws IOException {
        SocketChannel sc = (SocketChannel) key.channel();
        Queue<ByteBuffer> queue = pendinData.get(sc);
        ByteBuffer buffer;
        while ((buffer = queue.peek()) != null) {
            sc.write(buffer);
            if (!buffer.hasRemaining()) {
                queue.poll();
            }else{
                return;
            }
        }
        sc.register(key.selector(), SelectionKey.OP_READ);
    }

    public static void read(SelectionKey key) throws IOException {
        SocketChannel sc = (SocketChannel) key.channel();
        ByteBuffer buffer= ByteBuffer.allocateDirect(1024);
        int read = sc.read(buffer);
        if(read == -1){
            pendinData.remove(sc);
        }
        buffer.flip();
        for(int i =0; i < buffer.limit(); i++){
            buffer.put(i,(byte) Utils.transroprify(buffer.get(i)));
        }
        pendinData.get(sc).add(buffer);
        sc.register(key.selector(), SelectionKey.OP_WRITE);
    }

    public static void accept(SelectionKey key) throws IOException {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssc.accept();
        sc.configureBlocking(false);
        sc.register(key.selector(), SelectionKey.OP_READ);
        pendinData.put(sc, new ConcurrentLinkedDeque<ByteBuffer>());
    }
}
