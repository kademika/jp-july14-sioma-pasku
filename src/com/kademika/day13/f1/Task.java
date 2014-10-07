package com.kademika.day13.f1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;

/**
 * Created by Админ on 25.08.2014.
 */
public class Task implements Callable {
    @Override
    public Object call() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream())
            {
                int data;
                while ((data = in.read()) != -1) {
                    data = Utils.transroprify(data);
                    out.write(data);
                }
            }

        }
    }
}
