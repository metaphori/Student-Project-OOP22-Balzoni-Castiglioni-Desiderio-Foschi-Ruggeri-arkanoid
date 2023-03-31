package it.unibo.game.app.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BoundingBox;


public class AbstractBoundingBox implements BoundingBox {

    private Map<Corner, Pair<Double,Double>> corners = new HashMap<>();
  
		public AbstractBoundingBox(Double w, Double h, Pair<Double,Double> pos){
			setRectBox(w, h, pos);
		}
		
    private void setRectBox (Double double1, Double double2, Pair<Double, Double> pair){
        this.corners.put(Corner.LEFT_DOWN,new Pair<Double,Double>( pair.getX(), pair.getY()+double2 ) );
        this.corners.put(Corner.LEFT_UP, pair );
        this.corners.put(Corner.RIGHT_DOWN,new Pair<Double,Double>(pair.getX() + double1, pair.getY() + double2) );
        this.corners.put(Corner.RIGHT_UP,new Pair<Double,Double> (pair.getX()+double1, pair.getY()));
      
    }
    @Override
    public Optional<Side> collideWith(BoundingBox b) {
        if((this.equals(this.corners.get(Corner.LEFT_DOWN).getY(), b.getBox().get(Corner.LEFT_UP).getY())
            ||this.equals(this.corners.get(Corner.LEFT_UP).getY(), b.getBox().get(Corner.LEFT_DOWN).getY()))
            && (this.corners.get(Corner.LEFT_UP).getX()<= b.getBox().get(Corner.RIGHT_DOWN).getX() 
            && this.corners.get(Corner.RIGHT_UP).getX()>= b.getBox().get(Corner.LEFT_DOWN).getX())){
                    return Optional.of(Side.UP_DOWN);

            }else if((this.equals(this.corners.get(Corner.RIGHT_DOWN).getX(), b.getBox().get(Corner.LEFT_DOWN).getX())
                    || this.equals(this.corners.get(Corner.LEFT_DOWN).getX(), b.getBox().get(Corner.RIGHT_DOWN).getX()))
                    && (this.corners.get(Corner.RIGHT_DOWN).getY() >= b.getBox().get(Corner.LEFT_UP).getY() 
                    && this.corners.get(Corner.RIGHT_UP).getY() <= b.getBox().get(Corner.LEFT_DOWN).getY())){
                        return Optional.of(Side.LEFT_RIGHT);
                    }
   
       return Optional.empty();
    }

		private boolean equals(Double d1, Double d2){
			return (d1 >= d2 -2 && d1 <= d2 + 2);
		}
    public Map<Corner, Pair<Double,Double>> getBox(){
        return this.corners;
    }
  
    
}
