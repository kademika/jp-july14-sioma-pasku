package com.kademika.day13.f1;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Админ on 25.08.2014.
 */
public class TestServer {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 3000; i++) {
            try {
                new Socket("localhost", 8080);
                System.out.println(i);
            } catch (IOException e) {
                System.out.println("Connect failing...");
            }
        }
        Thread.sleep(1000000);
    }

}