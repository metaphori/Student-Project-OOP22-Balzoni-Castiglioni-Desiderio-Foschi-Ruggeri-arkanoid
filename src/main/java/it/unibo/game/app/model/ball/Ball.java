package it.unibo.game.app.model.ball;

import it.unibo.game.app.api.Physics;
import it.unibo.game.app.model.GameObjectImpl;
import it.unibo.game.app.api.MovingObject;

public class Ball extends GameObjectImpl implements MovingObject {

    private Double r;
    private Physics phi;

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    @Override
    public Physics getPhysics() {
        return phi;
    }

}
