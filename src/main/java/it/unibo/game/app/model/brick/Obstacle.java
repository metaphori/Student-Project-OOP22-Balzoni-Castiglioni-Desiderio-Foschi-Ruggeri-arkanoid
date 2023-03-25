package it.unibo.game.app.model.brick;

import java.util.Optional;

import it.unibo.game.app.api.BrickType;

public class Obstacle extends AbstractBrick {

    public Obstacle(BrickType type, Double double1, Double double2) {
        super(type, double1, double2);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean isDestroyed() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void hit() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Optional<Integer> getRes() {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void increaseRes(int res) {
        // TODO Auto-generated method stub
    }

    @Override
    public void decreaseRes(int res) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'decreseRes'");
    }
    
}