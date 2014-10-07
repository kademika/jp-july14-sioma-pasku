package com.kademika.day10.generics.domains;

/**
 * Created by Семен on 25.06.2014.
 */
public class Banana extends Fruit{
    private boolean mellow;
    private String mellow1;

    public String getMellow1() {
        return mellow1;
    }

    public void setMellow1(String mellow1) {
        this.mellow1 = mellow1;
    }

    public Banana(){
        setName("Banana");
    }
    public boolean isMellow() {
        return mellow;
    }

    public void setMellow(boolean mellow) {
        this.mellow = mellow;
    }
}
