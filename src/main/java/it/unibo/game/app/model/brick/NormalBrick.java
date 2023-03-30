package it.unibo.game.app.model.brick;

import java.util.Optional;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.Dimension;

public class NormalBrick extends AbstractBrick{

    private int brickResistence;

    public NormalBrick(BrickType type,  Dimension d, Pair<Double,Double> pos, int resistence) {
        super(type, d, pos);
        this.brickResistence = resistence;
    }

    public Optional<Integer> getRes () {
        return Optional.of(this.brickResistence);
    }

    public void hit() {
        this.brickResistence --;
    }

    @Override
    public boolean isDestroyed() {
        return this.brickResistence ==0;
    }

    public void increaseRes(int res) {
        this.brickResistence = ++res;
    }

    @Override
    public void decreaseRes(int res) {
       this.brickResistence = --res;
    }
    
}
