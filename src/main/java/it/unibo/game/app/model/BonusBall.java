package it.unibo.game.app.model;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BallPhysics;
import it.unibo.game.app.api.MovingObject;

public class BonusBall extends GameObjectImpl implements MovingObject{

    private BallPhysics bonusBallPhysics;
    private int height;
    private int width;
    private int radius;

    public BonusBall(Pair<Integer,Integer> coord, int h, int w, int r) {
        this.height = h;
        this.width = w;
        this.radius = r;
        this.setPos(centerCalculate(coord));        
    }
    private Pair<Integer,Integer> centerCalculate(Pair<Integer,Integer> c) {
        return new Pair<Integer,Integer>(c.getX() + (this.height/2), c.getY() + (this.width/2));
    }

    @Override
    public BallPhysics getPhysics() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPhysics'");
    }
    
}
