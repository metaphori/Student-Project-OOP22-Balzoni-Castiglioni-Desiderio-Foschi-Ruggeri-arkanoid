package it.unibo.game.app.model;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BallPhysics;
import it.unibo.game.app.api.MovingObject;

public class BonusBall extends GameObjectImpl implements MovingObject{

    private BallPhysics bonusBallPhysics;
    private Pair<Integer,Integer> coordinates;
    private int height;
    private int width;

    public BonusBall(Pair<Integer,Integer> coord, int h, int w) {
        this.coordinates = coord;
        this.height = h;
        this.width = w;
    }


    @Override
    public BallPhysics getPhysics() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPhysics'");
    }
    
}
