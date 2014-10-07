package com.kademika.sort.use;

import com.google.common.primitives.Chars;
import com.kademika.day13.f1.Utils;
import com.kademika.sort.action.Action;
import com.kademika.sort.domains.TovarCar;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Created by Админ on 09.09.2014.
 */
public class ServerOfSort {
    private static Map<SocketChannel, Queue<ByteBuffer>> pendinData = new HashMap<>();
    private static Sort sort;

    public static void main(String[] args) throws IOException {
        sort = new Sort();
        final ServerSocket serverSocket = new ServerSocket(4444);
        ExecutorService service = new ThreadPoolExecutor(0, 2,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                new ThreadPoolExecutor.CallerRunsPolicy()//connection with 1000 and waiting before they will finished
        );
        try {
            while (true) {
                final Socket socket = serverSocket.accept();

                service.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Connct from Socket " + socket.toString());
                        processWithSort(socket);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void processWithList( ObjectOutputStream out) {
        try {
            out.writeObject(sort.getListOfPokupatel());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processWithSort(Socket socket) {
        try (
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream obj = new ObjectOutputStream(socket.getOutputStream())
        ) {
            String inputLine= (String)in.readObject();
                System.out.println(inputLine+"///////////");
            if(inputLine != null && !inputLine.equals("")){
                if(inputLine.equals("get the sell-tovar")){
                    loadSellTovar(obj);
                }else if(inputLine.equals("get the buyers")){
                    processWithList(obj);
                }
                else{
                    loadAllTovar(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static  void loadAllTovar(ObjectOutputStream obj) throws IOException {
        try {
//            for(TovarCar car : Action.getCar()){
                obj.writeObject(Action.getCar());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  void loadSellTovar(OutputStream out){

    }

    public static void processWithFile(Socket socket) {
        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {
            int data;
            byte[] data1;
            int i = 0;
            while ((data = in.read()) != -1) {
                if (data == "g".getBytes()[0]) {
                    for (Pokupatel p : sort.readFromFile()) {
                        data1 = new byte[p.getNameOfBuyer().length() +2];
                        i = 0;
                        while (i < p.getNameOfBuyer().length()) {
                            data1[i] = p.getNameOfBuyer().getBytes()[i++];
                        }
                        data1[i] = (byte) 13;
                        data1[i] = (byte) 10;
                        out.write(data1);
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
