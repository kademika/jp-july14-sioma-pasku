package com.kademika.day12.f4;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Админ on 27.07.2014.
 */
public class Animation extends JPanel {
    private Gates gates;
    private Ship ship;
    private JFrame frame;
    private List<Model> list;

    public Animation() {
        frame = new JFrame(" FIELD, DAY 11");
        frame.setLocation(500, 130);

//        JMenuBar menuBar = new JMenuBar();
//        JMenu menu = new JMenu("File");
//        JMenuItem m = new JMenuItem("Save as");
//        JMenuItem m1 = new JMenuItem("Open");
//        menu.add(m);
//        menu.add(m1);
//        menuBar.add(menu);
//        frame.setJMenuBar(menuBar);
        frame.setMinimumSize(new Dimension(500, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
//        frame.pack();
        frame.setVisible(true);
        list = new ArrayList<>();
        ship = new Ship();
//        list.add(ship);
        gates = new Gates();
//        list.add(gates);


       new Thread(moveShip()).start();
        new Thread(openGates()).start();
    }
private int i=50;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
                g.setColor(Color.CYAN);
                g.fillOval(ship.getX(), 150, 10, 10);

                g.setColor(Color.GREEN);
                g.fillRect(gates.getX(), gates.getY(), 10, 50);
                g.fillRect(gates.getX(), gates.getY()+i, 10, 50);


    }

    public Runnable openGates() {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (gates) {
                        gates.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Alieve");
                if(ship.getX()>(gates.getX()-45)){


                        try {
                            System.out.println("Alieve1");

                            System.out.println("open gates");
                            while (gates.getY() > 70) {
                                try {
                                    Thread.currentThread().sleep(600);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                gates.setY(-10);
                                i+=20;
                                repaint();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();

                    }


                }
                synchronized (ship) {
                    ship.notify();
                }
                synchronized (gates) {
                    try {
                        gates.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Door are closing");
                while (gates.getY() <100) {
                    try {
                        Thread.currentThread().sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    gates.setY(10);
                    i-=20;
                    repaint();
                }
            }

        };
    }

    public Runnable moveShip() {
        return new Runnable() {
            @Override
            public void run() {
                while (ship.getX() < (gates.getX() - 30)) {
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ship.setX(10);
                    repaint();
                }

                synchronized (gates) {
                    gates.notify();
                }
                synchronized (ship) {
                    try {
                        ship.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("come in");
                    while (ship.getX() < (gates.getX() + 90)) {
                        try {
                            Thread.currentThread().sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ship.setX(10);
                        repaint();
                        if(ship.getX() > (gates.getX()+10)){
                            synchronized (gates) {
                                gates.notify();
                            }
                        }
                }


            }
        };
    }

    public static void main(String[] args) {
        new Animation();
    }
}
