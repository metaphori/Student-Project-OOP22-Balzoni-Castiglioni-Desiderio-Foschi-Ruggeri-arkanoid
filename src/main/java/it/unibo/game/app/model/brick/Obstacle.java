package it.unibo.game.app.model.brick;

import it.unibo.game.app.api.BrickType;

public class Obstacle extends AbstractBrick {

    public Obstacle(BrickType type, Double double1, Double double2) {
        super(type, double1, double2);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean isDestroyable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void hit() {
        // TODO Auto-generated method stub
        
    }
    
}