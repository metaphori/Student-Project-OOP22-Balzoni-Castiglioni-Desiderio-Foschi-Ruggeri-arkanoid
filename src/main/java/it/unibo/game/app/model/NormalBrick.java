package it.unibo.game.app.model;

import it.unibo.game.app.api.BrickType;

public class NormalBrick extends Brick{

    private int brickResistence;

    public NormalBrick(BrickType type, int width, int hight, int resistence) {
        super(type, width, hight);
        this.brickResistence = resistence;
    }

    public int getRes () {
        return this.brickResistence;
    }

    public void hit() {
        this.brickResistence --;
    }

    @Override
    public boolean isDestroyable() {
        return true;
    }
    
}
