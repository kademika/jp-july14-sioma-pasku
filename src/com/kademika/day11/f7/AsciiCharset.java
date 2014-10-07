package com.kademika.day11.f7;

import java.io.PrintStream;

/**
 * Created by Админ on 08.07.2014.
 */
public class AsciiCharset {
    public static void main(String[] args) {
        for(int i=32; i<= 256; i++ ){
            System.out.write(i);
            if(i%8==7){
                System.out.println();
            }else {
                System.out.write('\t');
            }
            }
        }

    }

