package com.kademika.day13.f1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Created by Админ on 23.08.2014.
 */
public class SimpleServer {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
//        ExecutorService es = Executors.newFixedThreadPool(6);
//        Future future;
        int i=0;
        final ServerSocket serverSocket = new ServerSocket(8080);
//        ExecutorService service = Executors.newCachedThreadPool();
        ExecutorService service =  new ThreadPoolExecutor(0, 1000,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
//                new ThreadPoolExecutor.DiscardPolicy()//connections working no more 1000, another  part of connection are throwing away
                new ThreadPoolExecutor.CallerRunsPolicy()//connection with 1000 and waiting before they will finished
        );

        try {

            while (true) {
                final Socket socket = serverSocket.accept();

                service.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Connct from Socket " + socket.toString());
                        Utils.process(socket);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
