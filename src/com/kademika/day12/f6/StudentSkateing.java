package com.kademika.day12.f6;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Админ on 29.07.2014.
 */
public class StudentSkateing implements Skatelink {
    private Queue<Skate> skates;
    private Lock lock;
    private AtomicInteger i;

    public StudentSkateing() {
        i=new AtomicInteger(100);
        skates = new LinkedBlockingQueue<>();
        for (int i = 0; i < 15; i++) {
            skates.add(new Skate());
        }
        lock = new ReentrantLock();
    }

    @Override
    public Skate gotSkate(Skater s) {
        lock.lock();
        if (skates.size() == 0) {
            synchronized (skates) {
                try {
                    skates.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        skates.remove((skates.size() - 1));
        System.out.println(s.getName() + " are getting a skate");
        lock.unlock();
        return null;
    }

    @Override
    public void returnSk(Skater s, Skate f) {
        synchronized (skates) {
            skates.notifyAll();
        }
        skates.add(new Skate());
        System.out.println(s.getName() + " are returning the skate");
    }

    public Skate getSomeSkate(Skater f) {
        Skate sk=null;
        while(true) {
            if (skates.isEmpty()) {

                System.out.println(f.getName() + " are waiting");
                try {
                    Thread.currentThread().sleep((100));
//                    getSomeSkate(f);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {

                sk = skates.poll();
                if (sk != null) {
                    System.out.println(f.getName() + " are getting the skate");
                }
                return sk;
            }

        }

    }

    public void returnSomeSkate(Skater f, Skate skate) {
        skates.add(skate);
        System.out.println(f.getName() + " are returning the skate");
    }
}
