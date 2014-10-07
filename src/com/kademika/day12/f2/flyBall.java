package com.kademika.day12.f2;

import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Админ on 21.07.2014.
 */
public class flyBall extends JPanel {
    private int x;
    private int y;
    private int i;
    private List<Balls> bl;
    private Color[] color = new Color[]{Color.BLUE, Color.CYAN, Color.GRAY, Color.GRAY, Color.GREEN};
    private Ball f;
    private JFrame frame;
    private Color color1;

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x += x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static void main(String[] args) throws Exception {
        new flyBall();
    }

    public flyBall() throws Exception {
        frame = new JFrame(" FIELD, DAY 11");
        frame.setLocation(500, 130);
        frame.setMinimumSize(new Dimension(500, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setVisible(true);
        createBalls();
        while (true) {
            repaint();
            Thread.sleep(100);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setX(i);
        int i = 0;
        for (Balls fg : bl) {
            if (fg.isAlive()) {
                g.setColor(fg.getColor());
                g.fillOval(fg.getX(), fg.getY(), 10, 10);
            }
        }
    }


    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void createBalls() {
        bl = new ArrayList<>();
        int h = 0;
        for (int i = 0; i < 5; i++) {
            Balls d = new Balls(10, h += 10, color[i]);
            d.start();
            bl.add(d);
        }
    }


    class Balls extends Thread {
        private int speed;
        private int x;
        private int y;
        private int i = 10;
        private Color color;

        public Color getColor() {
            return color;
        }


        public Balls(int i, int y, Color color) {
            super();
            setY(y);
            this.color = color;
            x = i;
            this.y = y;
            this.color = color;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public void setX(int i) {
            this.x += i;
        }

        public void setI(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(getName());
            super.run();
            while (true) {
                try {
                    paintBall();
                    sleep(getY() * 10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println((this.getName() + "Working"));
            }
        }

        public void paintBall() throws Exception {
            if (getX() == 250) {
                setI(-10);
            } else if (getX() == 0) {
                setI(10);
            }
            setX(i);
        }
    }
}
