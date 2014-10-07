package com.kademika.day10.generics.basic.box;

import com.kademika.day10.generics.basic.aboutClass.MyClass;
import com.kademika.day10.generics.domains.Fruit;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Семен on 25.06.2014.
 */
public class MyBox<E> extends LinkedList  {
  private  E element;

    public void addMyBox(E element){
        add(element);

    }
    public E getElement(){
        return element;
    }
    public void removeE(E element){
    remove(element);
    }
    public void copyElement(List<? extends Fruit> f, List<? super Fruit> f1){
        for(Fruit fr: f){
            f1.add(fr);
        }
    }
}
