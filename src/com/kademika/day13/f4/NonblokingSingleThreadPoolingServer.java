package com.kademika.day13.f4;

import com.kademika.day13.f3.Utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Админ on 01.09.2014.
 */
public class NonblokingSingleThreadPoolingServer {
    private static Collection<SocketChannel> sockets = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("localhost", 8080));
        ssc.configureBlocking(false);
        while (true) {
            SocketChannel sc = ssc.accept();// non-blocking, usually he is null
            if (sc != null) {
                System.out.println("Connection from " + sc);
                sc.configureBlocking(false);
                sockets.add(sc);
            }
            for (Iterator<SocketChannel> it = sockets.iterator(); it.hasNext();) {
                SocketChannel socket = it.next();
                try {
                    ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
                    int read = socket.read(buffer);
                    if (read == -1) {
                        it.remove();
                    } else if (read != 0) {
                        buffer.flip();
                        for (int i = 0; i < buffer.limit(); i++) {
                            buffer.put(i, (byte)transroprify(buffer.get(i)));
                        }
                        socket.write(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    it.remove();
                }

            }
        }
    }

    public static int transroprify(int data) {
        if (Character.isLetter((data))) {
            return data ^ ' ';
        }
        return data;
    }
}
