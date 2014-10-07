package com.kademika.day10.generics.basic.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Семен on 26.06.2014.
 */
public class SomeClass<T> implements Service {
     List<T> type;

    public SomeClass(){
        type = new ArrayList<T>();
    }
    public void someMake(){
        while(true){

        }
    }
}
