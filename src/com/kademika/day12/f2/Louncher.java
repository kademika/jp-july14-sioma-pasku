package com.kademika.day12.f2;

import java.awt.*;

/**
 * Created by Админ on 21.07.2014.
 */
public class Louncher {
    public static void main(String[] args)throws Exception {
//        Thread d =new Thread(new MyThread());
//        d.setDaemon(true);
//        d.start();
        flyBall f=new flyBall();

       /* try{
            Thread d =new Thread(new MyThread());
            d.setDaemon(true);
            d.start();
          f.paintBall(Color.BLUE);

            while(true){
            f.repaint();
            d.sleep(1000/60);
            }


             d =new Thread(new MyThread());
            f=new flyBall();
            d.setDaemon(true);
            d.start();
            f.paintBall(10, Color.RED);
            f.repaint();
            d.sleep(1000/600);
//            f=new flyBall();
            f.setY(20);

            new Thread().start();
            f.setY(50);
          f.paintBall(25, Color.YELLOW);
            new Thread().start();
            f.setY(80);
            f.paintBall(25, Color.GRAY);
            new Thread().start();
            f.setY(10);
            f.paintBall(25, Color.GREEN);
        }
        catch(Exception e){e.printStackTrace();}*/


}
}
