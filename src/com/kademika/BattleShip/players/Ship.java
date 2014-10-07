package com.kademika.BattleShip.players;

import com.kademika.BattleShip.domain.Direction;
import com.kademika.tanks.interfaces.IDrawble;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * Created by Админ on 08.08.2014.
 */
public class Ship implements IDrawble
{
    private int shipX;
    private int shipY;
    private boolean destroyed;
    protected Image[] images;
    private Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public Ship(int x, int y, Direction direction){
        setShipX(x);
        setShipY(y);
        this.direction = direction;
    }

    @Override
    public void draw(Graphics g) {
        if (!destroyed) {
            g.drawImage(images[getDirection().getId()], getShipX(), getShipY(),
                    new ImageObserver() {
                        @Override
                        public boolean imageUpdate(Image img, int infoflags,
                                                   int x, int y, int width, int height) {
                            // TODO Auto-generated method stub
                            return false;
                        }
                    });
        }	else{
    }
}

    public int getShipX() {
        return shipX;
    }

    public void setShipX(int shipX) {
        this.shipX = shipX;
    }

    public int getShipY() {
        return shipY;
    }

    public void setShipY(int shipY) {
        this.shipY = shipY;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
}
