package com.kademika.day12.f8;


import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by Админ on 01.08.2014.
 */
public class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception{
        Random r = new Random();
        int result=0;
        for(int p =0;p<r.nextInt(Integer.MAX_VALUE); p++){
            result++;
        }
        System.out.println(Thread.currentThread().getName());
        return result;
    }
}
