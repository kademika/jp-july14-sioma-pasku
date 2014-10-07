package com.kademika.day10.generics.basic.box;

/**
 * Created by Семен on 25.06.2014.
 */
//import com.kademika.day10.generics.domains.*;
public class BoxDemo {
    public static void  main(String[] args){
        MyBox<Integer> box = new MyBox<Integer>();
        box.addMyBox(5);
        box.addMyBox(3);
        box.addMyBox(8);
        box.removeE(3);
    }
}
