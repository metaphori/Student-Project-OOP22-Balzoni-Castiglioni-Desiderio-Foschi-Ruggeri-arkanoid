package it.unibo.game.app.model;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BoundingBox;
import it.unibo.game.app.api.GameObject;

public class GameObj implements GameObject {
    private Pair<Double, Double> pos;
    private BoundingBox Bbox;

    @Override
    public void setPos(Pair<Double, Double> pos) {
        this.pos = pos;
    }

    @Override
    public Pair<Double, Double> getPos() {
        return this.pos;
    }

    @Override
    public BoundingBox getBoundingBox() {
        return this.Bbox;
    }

    
}
