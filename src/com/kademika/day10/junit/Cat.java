package com.kademika.day10.junit;

/**
 * Created by Семен on 26.06.2014.
 */
public class Cat {
    private String name;
    private int mass;
    private boolean isHungry = true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }
}
