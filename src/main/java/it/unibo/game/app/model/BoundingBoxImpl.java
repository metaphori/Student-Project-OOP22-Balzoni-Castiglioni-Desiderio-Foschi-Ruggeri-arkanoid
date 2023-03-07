package it.unibo.game.app.model;

import java.util.List;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BoundingBox;

public class BoundingBoxImpl implements BoundingBox {

    private Pair<Integer, Integer> leftCornerDown ;
    private Pair<Integer, Integer> rightCornerDown ;
    private Pair<Integer, Integer> leftCornerUp ;
    private Pair<Integer, Integer> rightCornerUp ;

    public BoundingBoxImpl(Ball b){
        var radius = b.getR();
        var centre = b.getPos();
        //this.leftCornerDown = new Pair<Integer,Integer>(centre.getX()-radius,centre.getY()+radius );
        //this.rightCornerDown = new Pair<Integer,Integer>(centre.getX()+radius,centre.getY()+radius );
        //this.leftCornerUp = new Pair<Integer,Integer>(centre.getX()-radius,centre.getY()-radius );
        //this.rightCornerUp = new Pair<Integer,Integer>(centre.getX()+radius,centre.getY()-radius );
    }
    public BoundingBoxImpl(Brick b){
       setRectBox(b.getBrickH(), b.getBrickW(), b.getPos());
    }

    public BoundingBoxImpl (Pad p){
       // setRectBox();
    }
    private void setRectBox (int h, int w, Pair<Integer, Integer> pos){
        this.leftCornerDown = new Pair<Integer,Integer>( pos.getX()+h, pos.getY() );
        this.rightCornerDown = new Pair<Integer,Integer>(pos.getX() + h, pos.getY() + w);
        this.leftCornerUp = pos;
        this.rightCornerUp = new Pair<Integer, Integer> (pos.getX(), pos.getY()+w);
    }
    @Override
    public Boolean collideWith(BoundingBox b) {
       return (this.rightCornerUp.getX() <= b.getLeftCornerDown().getX())
        && (leftCornerDown.getX() >= b.getRightConrnerUp().getX())
        && (rightCornerUp.getY() <= b.getLeftCornerDown().getY())
        && (leftCornerDown.getY() >= b.getRightConrnerUp().getY());
    }
    @Override
    public Pair<Integer, Integer> getLeftCornerDown() {
        return leftCornerDown;
    }
    @Override
    public Pair<Integer, Integer> getLeftCornerUP() {
        return leftCornerUp;
    }
    @Override
    public Pair<Integer, Integer> getRightConrnerDown() {
        return rightCornerDown;
    }
    @Override
    public Pair<Integer, Integer> getRightConrnerUp() {
        return rightCornerUp;
    }
  
    
}
