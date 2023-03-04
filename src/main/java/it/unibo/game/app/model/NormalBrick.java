package it.unibo.game.app.model;

import it.unibo.game.app.api.BrickType;
import java.awt.*;

public class NormalBrick extends Brick{

    private int brickResistence;

    public NormalBrick(BrickType type, int width, int hight, Color color, int resistence) {
        super(type, width, hight, color);
        this.brickResistence = resistence;
    }

    public int getRes () {
        return this.brickResistence;
    }

    public void hit() {
        this.brickResistence --;
    }
    
}
