package it.unibo.game.app.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BoundingBox;
import it.unibo.game.app.api.Brick;
import it.unibo.game.app.model.ball.Ball;
import it.unibo.game.app.model.brick.AbstractBrick;
import it.unibo.game.app.model.pad.Pad;

public class BoundingBoxImpl implements BoundingBox {

    private Map<Corner, Pair<Double,Double>> corners = new HashMap<>();
  
    public BoundingBoxImpl(Ball b){
        var radius = b.getR();
        var centre = b.getPos();
        this.corners.put(Corner.LEFT_DOWN, new Pair<Double,Double>(centre.getX()+radius,centre.getY()-radius ));
        this.corners.put(Corner.LEFT_UP,new Pair<Double,Double>(centre.getX()-radius,centre.getY()-radius ) );
        this.corners.put(Corner.RIGHT_DOWN, new Pair<Double,Double>(centre.getX()+radius,centre.getY()+radius ));
        this.corners.put(Corner.RIGHT_UP,new Pair<Double,Double>(centre.getX()-radius,centre.getY()+radius ));
  
    }
    public BoundingBoxImpl(Brick b){
       setRectBox(b.getBrickH(), b.getBrickW(), b.getPos());
    }

    public BoundingBoxImpl (Pad p){
       setRectBox(p.getHight(), p.getWidth(), p.getPos());
    }
    private void setRectBox (Double double1, Double double2, Pair<Double, Double> pair){
        this.corners.put(Corner.LEFT_DOWN,new Pair<Double,Double>( pair.getX()+double1, pair.getY() ) );
        this.corners.put(Corner.LEFT_UP, pair );
        this.corners.put(Corner.RIGHT_DOWN,new Pair<Double,Double>(pair.getX() + double1, pair.getY() + double2) );
        this.corners.put(Corner.RIGHT_UP,new Pair<Double,Double> (pair.getX(), pair.getY()+double2));
      
    }
    @Override
    public Optional<Side> collideWith(BoundingBox b) {
        if((this.corners.get(Corner.LEFT_UP).getX() <= b.getBox().get(Corner.LEFT_DOWN).getX() 
            || this.corners.get(Corner.LEFT_DOWN).getX() >= b.getBox().get(Corner.LEFT_UP).getX())
            && (this.corners.get(Corner.LEFT_UP).getY()<= b.getBox().get(Corner.RIGHT_DOWN).getY() 
            && this.corners.get(Corner.RIGHT_UP).getY()>= b.getBox().get(Corner.LEFT_DOWN).getY())){

                return Optional.of(Side.UP_DOWN);

            }else if((this.corners.get(Corner.RIGHT_DOWN).getY() >= b.getBox().get(Corner.LEFT_UP).getY() 
                    || this.corners.get(Corner.LEFT_DOWN).getY() <= b.getBox().get(Corner.RIGHT_UP).getY())
                    && (this.corners.get(Corner.RIGHT_DOWN).getX() >= b.getBox().get(Corner.LEFT_UP).getX() 
                    && this.corners.get(Corner.RIGHT_UP).getX() <= b.getBox().get(Corner.LEFT_DOWN).getX())){
                        return Optional.of(Side.LEFT_RIGHT);
                    }
   
       return Optional.empty();
    }
    public Map<Corner, Pair<Double,Double>> getBox(){
        return this.corners;
    }
  
    
}
