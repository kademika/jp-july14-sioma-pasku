package com.kademika.day13.f1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Админ on 25.08.2014.
 */
public class Utils {
    public static int transroprify(int data) {
        if (Character.isLetter((data))) {
            return data ^ ' ';
        }
        return data;
    }
    public static void process(Socket socket){
        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {
            int data;
            while ((data = in.read()) != -1) {
                data = transroprify(data);
                out.write(data);
            }

        }catch(Exception e){
            e.printStackTrace();}
    }
}
