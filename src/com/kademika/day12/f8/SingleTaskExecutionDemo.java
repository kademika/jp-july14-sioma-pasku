package com.kademika.day12.f8;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Админ on 01.08.2014.
 */
public class SingleTaskExecutionDemo {
    public static void main(String[] args) throws Exception{
//        ExecutorService es = Executors.newSingleThreadExecutor();
        int i=0;
        ExecutorService es = Executors.newFixedThreadPool(6);
        Queue<Future<Integer>> results = new LinkedBlockingQueue<>();
        Queue<Integer> result = new LinkedBlockingQueue<>();

        i++;
        try{
//            Future<Integer> future= es.submit(new Task());
//            System.out.println(future.get()+" "+i);
            for(int i1=0; i1<8; i1++){
                results.add(es.submit(new Task()));
            }
            for(Future<Integer> future: results){
                result.add(future.get());
            }
        }finally {
            es.shutdown();
        }
        for(Integer in :  result){
            System.out.println(in);
        }
    }
}
