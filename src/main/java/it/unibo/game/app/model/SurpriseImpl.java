package it.unibo.game.app.model;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.api.Surprise;

public class SurpriseImpl implements Surprise{

    private Level level;

    public SurpriseImpl(Level level) {
        this.level = level;
        this.chooseSurprise();
    }

    @Override //simone
    public void extraLife() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extraLife'");
    }

    @Override //simone
    public void explosiveBomb() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'explosiveBomb'");
    }

    @Override //edoardo
    public void deleteRandomBricks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRandomBricks'");
    }

    @Override //edoardo
    public void reduceSizePad() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reduceSizePad'");
    }

    @Override //edoardo
    public void enlargeSizePad() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enlargeSizePad'");
    }

    @Override //virginia
    public void increaseBallSpeed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'increaseBallSpeed'");
    }

    @Override //virginia
    public void decreaseBallSpeed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'decreaseBallSpeed'");
    }

    @Override //virginia
    public void changeObstacles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeObstacles'");
    }

    @Override //margherita
    public void increaseScore() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'increaseScore'");
    }

    @Override //margherita
    public void addBalls() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addBalls'");
    }

    @Override //chiara
    public void changeRow() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeRow'");
    }

    @Override //chiara
    public void changeHard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeHard'");
    }

    @Override //simone
    public void chooseSurprise() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chooseSurprise'");
    }
    
}
