package com.kademika.day10.generics.domains.server;

import com.kademika.day10.generics.domains.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Семен on 26.06.2014.
 */
public class Action<T> {
    List<T> fruit;
    public Action(){
    fruit = new ArrayList<T>();
    }

    public void countDiscount(List<? extends Fruit>fruit){
        for(int i =0; i <fruit.size();i++){
        if(fruit.get(i).getCost()>500 && fruit.get(i).getCost()<1000 ){
         fruit.get(i).setCost(fruit.get(i).getCost()*5/100);
        }
         else if(fruit.get(i).getCost()>1000){
            fruit.get(i).setCost(fruit.get(i).getCost()/10);
        }
    }
    }
}
