package com.kademika.day13.f2;

import com.kademika.day13.f1.Utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Админ on 31.08.2014.
 */
public class SimpleExecutorsService {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
//        ExecutorService es = Executors.newFixedThreadPool(6);
//        Future future;
        int i=0;
        final ServerSocket serverSocket = new ServerSocket(8080);
        ExecutorService service = Executors.newFixedThreadPool(1000);//open connection and working with first 1000
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
