package it.unibo.game.app.model;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Direction;

public class DirectionImpl implements Direction {
    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final int UP = -1;
    private static final int DOWN = 1;
    private Pair<Integer, Integer> d ;

    public DirectionImpl(){
        this.d= new Pair<Integer,Integer>(UP, RIGHT);
    }
    @Override
    public void setDirectionUp(){
        this.d = new Pair<Integer,Integer>(UP, this.d.getY());
    }
    @Override
    public void setDirectionDown(){
        this.d = new Pair<Integer,Integer>(DOWN, this.d.getY());
    }
    @Override
    public void setDirectionLeft(){
        this.d = new Pair<Integer,Integer>(this.d.getX(), LEFT);
    }
    @Override
    public void setDirectionRight(){
        this.d = new Pair<Integer,Integer>(this.d.getX(), RIGHT);
    }
    @Override
    public boolean isDirectionUp(){
        return (this.d.getX() == UP)? true : false;
    }
    @Override
    public boolean isDirectionLeft(){
        return (this.d.getX() == LEFT)? true : false;
    }
    @Override
    public Pair<Integer, Integer> getDirection(){
        return this.d;
    }
}
