package com.kademika.day12.f6;

/**
 * Created by Админ on 29.07.2014.
 */
public class Skate {
private int countOfSk;

    public Skate(){
    }
    public Skate(int i){
        countOfSk=i;
    }

    public int getCountOfSk() {
        return countOfSk;
    }

    public void setCountOfSk(int countOfSk) {
        this.countOfSk -= countOfSk;
    }
}
