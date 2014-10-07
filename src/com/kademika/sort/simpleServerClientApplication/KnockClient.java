package com.kademika.sort.simpleServerClientApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Админ on 22.09.2014.
 */
public class KnockClient {
    public static void main(String[] args) {
        try (
                Socket kkSocket = new Socket("localhost", 4444);
                PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(kkSocket.getInputStream()));
                BufferedReader stdIn =
                        new BufferedReader(
                                new InputStreamReader(System.in))

        ){
String fromServer,fromUser ;
//            while(true){
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;

                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
//            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
