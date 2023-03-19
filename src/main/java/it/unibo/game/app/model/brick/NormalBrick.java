package it.unibo.game.app.model.brick;

import it.unibo.game.app.api.BrickType;

public class NormalBrick extends AbstractBrick{

    private int brickResistence;

    public NormalBrick(BrickType type, Double width, Double hight, int resistence) {
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

    public void increaseRes(int res) {
        this.brickResistence = ++res;
    }
    
}
