package com.kademika.day10.junit;

/**
 * Created by Семен on 26.06.2014.
 */
public class HouseGirl {
    private String name;
    private int age;
    public void feedCat(Cat[] cat){
        for(Cat c: cat){
            if(c.isHungry()){
                c.setHungry(false);
            }else{throw new  CatNotHungreException(c.getName() + " isn`t hungry");}
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
