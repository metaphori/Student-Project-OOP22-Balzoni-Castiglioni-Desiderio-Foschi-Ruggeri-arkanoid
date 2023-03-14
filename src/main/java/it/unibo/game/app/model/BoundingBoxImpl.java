package it.unibo.game.app.model;

import java.util.Map;
import java.util.Optional;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BoundingBox;

public class BoundingBoxImpl implements BoundingBox {

    private Map<Corner, Pair<Integer, Integer>> corners;
  
    public BoundingBoxImpl(Ball b){
        var radius = b.getR();
        var centre = b.getPos();
       // this.corners.put(Corner.LEFT_DOWN, new Pair<Integer,Integer>(centre.getX()-radius,centre.getY()+radius ));
        //this.corners.put(Corner.LEFT_UP,new Pair<Integer,Integer>(centre.getX()-radius,centre.getY()-radius ) );
        //this.corners.put(Corner.RIGHT_DOWN, new Pair<Integer,Integer>(centre.getX()+radius,centre.getY()+radius ));
        //this.corners.put(Corner.RIGHT_UP,new Pair<Integer,Integer>(centre.getX()+radius,centre.getY()-radius ));
  
    }
    public BoundingBoxImpl(AbstractBrick b){
       setRectBox(b.getBrickH(), b.getBrickW(), b.getPos());
    }

    public BoundingBoxImpl (Pad p){
       setRectBox(p.getHight(), p.getWidth(), p.getPos());
    }
    private void setRectBox (int h, int w, Pair<Integer, Integer> pos){
        this.corners.put(Corner.LEFT_DOWN,new Pair<Integer,Integer>( pos.getX()+h, pos.getY() ) );
        this.corners.put(Corner.LEFT_UP, pos );
        this.corners.put(Corner.RIGHT_DOWN,new Pair<Integer,Integer>(pos.getX() + h, pos.getY() + w) );
        this.corners.put(Corner.RIGHT_UP,new Pair<Integer, Integer> (pos.getX(), pos.getY()+w));
      
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
    public Map<Corner, Pair<Integer, Integer>> getBox(){
        return this.corners;
    }
  
    
}
