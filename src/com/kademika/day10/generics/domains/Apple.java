package com.kademika.day10.generics.domains;

/**
 * Created by Семен on 25.06.2014.
 */
public class Apple extends Fruit {
    private int mass;

    public Apple(String name,int i){
        setName(name);
        setCost(i);

    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }
}
