package com.kademika.BattleShip.domain;

import java.util.Random;

/**
 * Created by Админ on 08.08.2014.
 */
public enum Direction {
    NONE(0),UP(1), DOWN(2);
    private  int id;

    private Direction(int i) {
        id=i;
    }
    public  int getId(){
        return id;
    }
    public int f(){
        Random r = new Random();
        int f = 0;
        while(f>0 && f!=2){
            f +=r.nextInt(4);
        }
        this.id = f;
        return this.id;
    }
}
