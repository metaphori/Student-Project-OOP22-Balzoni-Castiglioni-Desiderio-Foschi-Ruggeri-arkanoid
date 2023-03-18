package it.unibo.game.app.model;

import it.unibo.game.app.api.Physics;
import it.unibo.game.app.api.MovingObject;

public class Ball extends GameObjectImpl implements MovingObject {

    private Integer r;
    private Physics phi;

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    @Override
    public Physics getPhysics() {
        return phi;
    }

}
