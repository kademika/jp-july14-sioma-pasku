package com.kademika.day12.f7;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Админ on 30.07.2014.
 */
final public  class IdGenerator {
     private AtomicInteger i;

    public IdGenerator(AtomicInteger i){
        this.i=i;
}
    public void setI(int i){
        this.i.addAndGet(i);
    }
    public AtomicInteger getI(){
        setI(1);
        return i;
    }

}
