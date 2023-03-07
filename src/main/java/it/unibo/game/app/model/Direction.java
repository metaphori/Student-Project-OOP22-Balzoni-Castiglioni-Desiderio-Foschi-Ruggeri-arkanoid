package it.unibo.game.app.model;

import it.unibo.game.Pair;

public class Direction {
    private static final int CENTRE = 0;
    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final int UP = -1;
    private static final int DOWN = 1;
    private static Pair<Integer, Integer> d ;

    public Direction(){
        this.d= new Pair<Integer,Integer>(UP, CENTRE);
    }
    public void setDirectionUp(){
        this.d = new Pair<Integer,Integer>(UP, this.d.getY());
    }
    public void setDirectionDown(){
        this.d = new Pair<Integer,Integer>(DOWN, this.d.getY());
    }
    public void setDirectionLeft(){
        this.d = new Pair<Integer,Integer>(this.d.getX(), LEFT);
    }
    public void setDirectionRight(){
        this.d = new Pair<Integer,Integer>(this.d.getX(), RIGHT);
    }
    public void setDirectionCentre(){
        this.d = new Pair<Integer,Integer>(this.d.getX(), CENTRE);
    }
    public Pair<Integer, Integer> getDirection(){
        return d;
    }
}
