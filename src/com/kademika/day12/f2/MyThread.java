package com.kademika.day12.f2;

/**
 * Created by Админ on 22.07.2014.
 */
public class MyThread implements Runnable {
    private Thread t;
    @Override
    public void run() {
        try{
        Thread.sleep(50);}
        catch(Exception r){}
    }
    public void start(){
        if (t == null)
        {
            t = new Thread (this);
            t.start ();
        }
    }
}
