package com.kademika.day10.generics.domains;

/**
 * Created by Семен on 25.06.2014.
 */
public abstract  class Fruit {
    private long id;
    private String name;
    private int cost;


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }
}
