package com.kademika.day11.f7;

import java.util.Arrays;

/**
 * Created by Админ on 15.07.2014.
 */
public class Characters {
    public static String printCodePointerInfo(int codePoint){
        char[] chr = Character.toChars(codePoint);
        return new String(chr);
//        System.out.println("Code Point:" + codePoint+" Char Array "+ Arrays.toString(chr)+" Res string "+str +" " +
//                " String len "+ str.length()+" Code count "+ str.codePointCount(0,str.length()));
    }

    public static void main(String[] args) {
        System.out.println((char)135);
        System.out.println();
        System.out.println((char)'\45');
        printCodePointerInfo(145);
        printCodePointerInfo(1450);
        printCodePointerInfo(14500);
        printCodePointerInfo(145000);

    }
}
