package it.unibo.game.app.model;

import it.unibo.game.Pair;

public class Direction {
    private final int CENTRE = 0;
    private final int LEFT = 0;
    private final int RIGHT = 0;
    private final int UP = 0;
    private final int DOWN = 0;
    private Pair<Integer, Integer> d ;

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
    public void setDirectionCentre(){
        this.d = new Pair<Integer,Integer>(this.d.getX(), CENTRE);
    }
    public void setDirectionRight(){
        this.d = new Pair<Integer,Integer>(this.d.getX(), RIGHT);
    }
    public Pair<Integer, Integer> getDirection(){
        return d;
    }
}
