package it.unibo.game.app.model;

import it.unibo.game.app.api.BoundingBox;
import it.unibo.game.app.api.MovingObject;
public class Ball extends GameObj implements MovingObject {

    private final static double PI = Math.PI;
    private double r;
    
    public double getR() {
        return r;
    }
    public void setR(double r) {
        this.r = r;
    }
    
    
    @Override
    public BoundingBox getBoundingBox() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoundingBox'");
    }
    
    
}
