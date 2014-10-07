package com.kademika.day10.generics.basic.service1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Админ on 30.06.2014.
 */
//@service
public class ApplicationManager {
    public ApplicationManager(List<? extends service> cl){
//cl = new Object<service>();
       List <InitService> d= new ArrayList<InitService>();
    for(Object ser: cl){
        cl=new ArrayList<service>();
        if(cl.getClass().getDeclaredMethods().getClass().getDeclaredAnnotations().equals("InitService")){
        cl.getClass().getDeclaredMethods();
        }
    }
    }

    public static void main(String[] args) {

    }
    public void someMake(){};
    public <T> T getService(List<? extends service> cl){
        for(Object ser: cl){
            cl=new ArrayList<service>();
            if(cl.getClass().getDeclaredMethods().getClass().getDeclaredAnnotations().equals("InitService")){
               return (T) cl.getClass().getDeclaredMethods();
            }
        }
        return null;
    }
}
