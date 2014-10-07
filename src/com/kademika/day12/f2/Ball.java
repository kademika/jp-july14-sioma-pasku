package com.kademika.day12.f2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Админ on 23.07.2014.
 */
public class Ball extends Thread {
    private int speed;
    private int x;
    private int y;
    private Color color;
public Ball(int i, int y,Color color){
    super();
   x=i;
   this.y=y;
    this.color = color;
}
    public int getX() {
        return x;
    }

    @Override
    public void run() {
//        super.run();
        try {
            this.sleep(getSpeed());
        }catch(Exception e){}
        System.out.println(this.getName()+"!!!");
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSpeed() {

        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void paintBall( int x){
////        g.setColor(getColor());
////        g.fillOval(x, getY(), 10, 10);
//        try {
//            sleep(speed);
//        }catch(Exception t){}
        setY(x);
    }
}
