package com.kademika.day12.f6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * Created by Админ on 29.07.2014.
 */
public class Skating {

    public static void main(String[] args){
        final StudentSkateing sе = new StudentSkateing();
        final Random ran = new Random();
        ExecutorService es = Executors.newFixedThreadPool(30);
        final List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            final Skater sk = new Skater("Igor" + i);
            Future future = es.submit(new Runnable() {
                @Override
                public void run() {
                    Skate skate = null;
                    while (skate == null) {
                        skate = sе.getSomeSkate(sk);
                    }
                    System.out.println(sk.getName()+" are skating");
                    try {
                        Thread.currentThread().sleep(ran.nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sе.returnSomeSkate(sk, skate);

                }
            });
            futureList.add(future);
        }
        int i=0;
        for(Future f: futureList){
            try {
                System.out.println(i++ +" "+ f.get());
            }catch (Exception e){

            }
        }
       es.shutdown();
        System.out.println(es.isTerminated());
        System.out.println("We have finishing yehoooohohohohohoh");
        try {
            Thread.sleep(2000);
            System.out.println(es.isTerminated());
        }catch (Exception e){

        }
    }
}
