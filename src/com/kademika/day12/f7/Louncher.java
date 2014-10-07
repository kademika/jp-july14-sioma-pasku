package com.kademika.day12.f7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Админ on 01.08.2014.
 */
public class Louncher {
    public static void main(String[] args) {
        final IdGenerator fd = new IdGenerator(new AtomicInteger(1));
        for(int i=0;i<10;i++){
          new Thread(new Runnable() {
                 @Override
                 public void run() {
                     System.out.println(fd.getI());
                 }
             }).start();
        }
    }
}
