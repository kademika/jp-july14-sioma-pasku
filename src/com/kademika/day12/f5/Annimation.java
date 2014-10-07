package com.kademika.day12.f5;


import javax.swing.*;
import java.awt.*;

/**
 * Created by Админ on 27.07.2014.
 */
public class Annimation extends JPanel {
    private Car car;
    private Barrier barrier;
    private JFrame frame;
    private boolean sweatch = true;

    public Annimation() {
        frame = new JFrame(" FIELD, DAY 12");
        frame.setLocation(500, 130);
        frame.setMinimumSize(new Dimension(500, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
        int i = 10;
        while (true) {
            while (sweatch) {
                car = new Car();
                barrier = new Barrier();
                new Thread(moveBarier()).start();
                new Thread(moveCar()).start();
            }
            try {
                Thread.currentThread().sleep(1000/60);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(car.getX(), 50, 25, 10);
        g.setColor(barrier.getCol());
        g.fillOval(148, 28, 6, 6);
        g.setColor(Color.red);
        g.drawLine(150, 30, barrier.getX(), barrier.getY());

    }

    public Runnable moveBarier() {
        return new Runnable() {
            @Override
            public void run() {
                sweatch = false;
                synchronized (barrier) {
                    try {
                        barrier.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                barrier.setCol(Color.GREEN);
                while (barrier.getY() > 30) {
                    barrier.setY(-5);
                    barrier.setX(5);
                    methodAreSleep();
                }
                synchronized (car) {
                    car.notify();
                }
                synchronized (barrier) {
                    try {
                        barrier.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                barrier.setCol(Color.RED);
                while (barrier.getY() < 70) {
                    barrier.setY(5);
                    barrier.setX(-5);
                    methodAreSleep();
                }
                sweatch = true;
            }
        };
    }

    public Runnable moveCar() {
        return new Runnable() {
            @Override
            public void run() {
                sweatch = false;
                while (car.getX() < (barrier.getX() - 35)) {
                    car.setX(10);
                    methodAreSleep();
                }
                System.out.println("Barrier are openning");
                synchronized (barrier) {
                    barrier.notify();
                }
                System.out.println("car are waitining");
                synchronized (car) {
                    try {
                        car.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                while (car.getX() < frame.getWidth()) {
                    car.setX(10);
                    methodAreSleep();
                    if (car.getX() > (barrier.getX() + 30)) {
                        synchronized (barrier) {
                            barrier.notify();
                        }
                    }
                }
                sweatch = true;
            }
        };
    }
    private void methodAreSleep(){
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Annimation();
    }
}
