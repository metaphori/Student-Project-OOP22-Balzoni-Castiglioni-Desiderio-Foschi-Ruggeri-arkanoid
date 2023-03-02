package it.unibo.game.app.model;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BoundingBox;
import it.unibo.game.app.api.GameObject;

public abstract class AbstractGameObj implements GameObject {
    private Pair<Double, Double> pos;

    public Pair<Double, Double> getPos() {
        return pos;
    }
    public void setPos(Pair<Double, Double> pos) {
        this.pos = pos;
    }

    
    @Override
    public BoundingBox getBoundingBox() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
