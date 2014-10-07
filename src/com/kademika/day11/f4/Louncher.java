package com.kademika.day11.f4;

import java.io.*;
import java.nio.file.Files;

/**
 * Created by Админ on 04.07.2014.
 */
public class Louncher {
    public static void main(String[] args)throws IOException {
        byte[] f = {-5, 3, 4};
        ByteArrayInputStream hg = new ByteArrayInputStream(f);
        printStreamData(hg);
    }

    /*private static void printStreamData(ByteArrayInputStream byt) {
        ByteArrayOutputStream fd = new ByteArrayOutputStream();
        int i;
        while ((i = byt.read()) != -1) {
            fd.write(byt.read());
            System.out.println(fd + "k");
        }
    }*/

    private static void printStreamData(InputStream byt) throws IOException {
        ByteArrayOutputStream fd = new ByteArrayOutputStream();
        String i;
        BufferedReader bf = new BufferedReader(new FileReader(new File("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\f5\\text.txt")));
        while ((i = bf.readLine()) != null) {
            System.out.println(i + "k");
        }
    }
}
