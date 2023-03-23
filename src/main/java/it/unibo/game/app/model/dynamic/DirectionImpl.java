package it.unibo.game.app.model.dynamic;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Direction;

public class DirectionImpl implements Direction {
    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final int UP = -1;
    private static final int DOWN = 1;
    private Pair<Integer, Integer> d ;

    public DirectionImpl(){
       this.resetDirection();
    }
    public void setDirection(Pair<Integer,Integer> newD){
        this.d = newD;
    }
    @Override
    public void setDirectionUp(){
        this.d = new Pair<Integer,Integer>(this.d.getX(), UP);
    }
    @Override
    public void setDirectionDown(){
        this.d = new Pair<Integer,Integer>(this.d.getX(), DOWN);
    }
    @Override
    public void setDirectionLeft(){
        this.d = new Pair<Integer,Integer>(LEFT, this.d.getY());
    }
    @Override
    public void setDirectionRight(){
        this.d = new Pair<Integer,Integer>(RIGHT,this.d.getY());
    }
    @Override
    public boolean isDirectionUp(){
        return (this.d.getY() == UP)? true : false;
    }
    @Override
    public boolean isDirectionLeft(){
        return (this.d.getX() == LEFT)? true : false;
    }
    @Override
    public Pair<Integer, Integer> getDirection(){
        return this.d;
    }
    @Override
    public void resetDirection() {
        this.d = new Pair<Integer,Integer>(LEFT, UP);
    }
    
}
