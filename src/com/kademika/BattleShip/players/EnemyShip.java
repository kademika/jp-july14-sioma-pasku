package com.kademika.BattleShip.players;

import com.kademika.BattleShip.domain.Direction;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Админ on 08.08.2014.
 */
public class EnemyShip extends Ship {
    public EnemyShip(int x, int y, Direction direction){
        super(x,y, direction);
    }
    public void setImages() {
        images = new Image[2];
        try {
            images[1] = ImageIO.read(new File("tigerup.bmp").getAbsoluteFile());
            images[2] = ImageIO.read(new File("tigerdown.bmp")
                    .getAbsoluteFile());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Cann`t search that file");
        }

    }
}
