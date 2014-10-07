package com.kademika.day13.f6;

import java.io.*;

/**
 * Created by Админ on 01.09.2014.
 */
public class DataIO {
    public static void main(String[] args) {

    }
    public static void readFromFile(String file) throws IOException {
        try(DataInputStream di = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))){
            System.out.println(di.readInt());
            System.out.println(di.readFloat());
            System.out.println(di.readChar());
        }
    }
    public static void writeToFile(String file) throws IOException {
        try(DataOutputStream di = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            di.writeChar('h');
            di.writeFloat(3234f);
            di.writeInt(12);
        }
    }
}
