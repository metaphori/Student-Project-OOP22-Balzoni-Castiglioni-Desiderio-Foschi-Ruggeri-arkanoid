package it.unibo.game.app.model;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BoundingBox;
import it.unibo.game.app.api.GameObject;

public class GameObjectImpl implements GameObject {
    
    private Pair<Integer,Integer> pos;
    private BoundingBox Bbox;

    @Override
    public Pair<Integer, Integer> getPos() {
        return this.pos;
    }

    @Override
    public BoundingBox getBoundingBox() {
        return this.Bbox;
    }

    @Override
    public void setPos(Pair<Integer, Integer> pos) {
        this.pos = pos;
    }

    
}
