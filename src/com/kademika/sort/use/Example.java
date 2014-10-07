package com.kademika.sort.use;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Админ on 24.09.2014.
 */
public class Example {
    public static void main(String[] args) {
        try {
            new Socket("localhost", 8080);
            while(true){}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
