package com.kademika.day12.f5;

import java.awt.*;

/**
 * Created by Админ on 27.07.2014.
 */
public class Barrier {
    private int X=150;
    private int Y=70;
    private double corner;
    private Color col=Color.RED;

    public Color getCol() {
        return col;
    }

    public void setCol(Color col) {
        this.col = col;
    }

    public double getCorner() {
        return corner;
    }

    public void setCorner(double corner) {
        this.corner = corner;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X += x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y += y;
    }
}
