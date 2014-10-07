package com.kademika.day12.f3;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Админ on 25.07.2014.
 */
public class RaceConditions {
    private static volatile boolean killVar=true;
    public static void main(String[] args) {
        Random r = new Random();
        long husband = 1111;
        long wife = 2222;
        Atm amt = new LegacyAtm(10000);
        Set<Runnable> th = new HashSet<>();
        for(int i=0; i<50;i++){
            th.add(createThread(amt,wife, r.nextInt(1000)));
            th.add(createThread(amt,husband, r.nextInt(1000)));
        }
        for(Runnable tg : th){
            new Thread(tg).start();
        }
    }
    private static Runnable createThread(final Atm atm,final long acount, final int ac){
        return new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(killVar && i<10){
                atm.checkBalance(acount);
                atm.withdrawMoney(acount, ac);
                if(atm instanceof LegacyAtm){
                    ((LegacyAtm) atm).withdrawCash(acount);
                }
                i++;
                    if(i> 8){
                        try {
                            Thread.currentThread().sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Now, the thread "+Thread.currentThread().getName()+" is die");
                        killThread();
                    }
                }
            }
        };
        }
    public static void killThread(){
        killVar = false;
    }
    }

