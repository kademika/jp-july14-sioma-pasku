package com.kademika.day11.f7;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Created by Админ on 15.07.2014.
 */
public class UnCoding {
    public static void main(String[] args) throws Exception {
       /* char cg = 'а';
        String srus = new String(new char[]{'а', 'б', 'в', 'г', 'д', 'А', 'Б', 'В', 'Г', 'Д',});
        String sen = new String(new char[]{'A', 'B', 'C', 'D', 'E', 'a', 'b', 'c', 'd', 'e',' '});
        System.out.println(cg);
        System.out.println(srus);
        System.out.println("CodePoint " + (int) cg);
        int g;
        for (int i = 0; i < srus.length(); i++){
    g=i+1;
            System.out.println(srus.substring(i,g));
    System.out.println("cp1251 "+Arrays.toString(srus.substring(i, g).getBytes("cp1251")));
    System.out.println("UTF-8 "+Arrays.toString(srus.substring(i, g).getBytes(StandardCharsets.UTF_8)));
            System.out.println(sen.substring(i,g));
            System.out.println("cp1251 "+Arrays.toString(sen.substring(i, g).getBytes("cp1251")));
            System.out.println("cp1251 "+Arrays.toString(sen.substring(i, g).getBytes(StandardCharsets.ISO_8859_1)));
    System.out.println("UTF-8 "+Arrays.toString(sen.substring(i, g).getBytes(StandardCharsets.UTF_8)));

}*/
        System.out.println("j".getBytes("cp1251"));
    }
}
