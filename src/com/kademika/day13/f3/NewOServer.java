package com.kademika.day13.f3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Админ on 01.09.2014.
 */
public class NewOServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("localhost", 8080));
        ExecutorService pool = Executors.newFixedThreadPool(1000);
        while(true){
            final SocketChannel socketChannel = ssc.accept();
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    Utils.process(socketChannel);
                }
            });
        }
    }
}
