package com.kademika.day10.generics.basic.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Семен on 26.06.2014.
 */
public class ServiceRepository< SomeClass> {
    List<SomeClass> someClass;
    List<ChildOfSomeClass> child;
public ServiceRepository(){
     someClass = new ArrayList<SomeClass>();
     child = new ArrayList<ChildOfSomeClass>();
}

    public List<SomeClass> getSomeClass() {
        return someClass;
    }

    public void setSomeClass(List<SomeClass> someClass) {
        this.someClass = someClass;
    }

    public List<ChildOfSomeClass> getChild() {
        return child;
    }

    public void setChild(List<ChildOfSomeClass> child) {
        this.child = child;
    }
}
