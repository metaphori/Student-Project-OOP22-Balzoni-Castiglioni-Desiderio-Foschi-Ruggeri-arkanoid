package it.unibo.game.app.model.brick;

import it.unibo.game.app.api.BrickType;

public class Obstacle extends AbstractBrick {

    public Obstacle(BrickType type, int width, int hight) {
        super(type, width, hight);
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