package com.kademika.sort.simpleServerClientApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Админ on 22.09.2014.
 */
public class KnockKnockServer {
    public static void main(String[] args) throws IOException {

//        if (args.length != 1) {
//            System.err.println("Usage: java KnockKnockServer <port number>");
//            System.exit(1);
//        }

//        ExecutorService service = new ThreadPoolExecutor(0, 1,
//                60L, TimeUnit.SECONDS,
//                new SynchronousQueue<Runnable>(),
//                new ThreadPoolExecutor.CallerRunsPolicy()//connection with 1000 and waiting before they will finished
//        );
        try (
                ServerSocket serverSocket = new ServerSocket(4444);
                 Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {
            while (clientSocket !=null) {
//                final Socket socket = serverSocket.accept();

//                service.submit(new Runnable() {
//                    @Override
//                    public void run() {
                        System.out.println("Connct from Socket " + clientSocket.toString()+" with "+Thread.currentThread().getName());
                        String inputLine, outputLine;

                        // Initiate conversation with client
                        KnockKnockProtocol kkp = new KnockKnockProtocol();
                        outputLine = kkp.processInput(null);
                        out.println(outputLine);

                        try {
                            while ((inputLine = in.readLine()) != null) {
                                outputLine = kkp.processInput(inputLine);
                                out.println(outputLine);
                                if (outputLine.equals("Bye."))
                                    break;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
//                });
//            }


        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + 4444 + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
