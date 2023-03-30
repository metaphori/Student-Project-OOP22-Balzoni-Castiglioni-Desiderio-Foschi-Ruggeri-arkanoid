package it.unibo.game.app.model.brick;
import java.util.Optional;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BoundingBox;
import it.unibo.game.app.api.Brick;
/*questa classe deve essere estesa da 
 * la classe che rappresenta i mattoni come ostacoli e 
 * mattoni di gioco
 * 
 */
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.Dimension;
import it.unibo.game.app.model.RectBoundingBox;


public abstract class AbstractBrick  implements Brick{
    
    private BrickType type;
		private BoundingBox box;
    private Dimension d;
    private Pair<Double,Double> pos;
    
    public AbstractBrick (BrickType type, Dimension d, Pair<Double,Double> pos) {
        this.type = type;
				this.pos = pos;
        this.d = d;
        this.setBoundingBox(new RectBoundingBox(this));
        
    }

    public BrickType getType() {
        return this.type;
    }

    public void changeType(BrickType type) {
        this.type = type;
    }

    public Double getBrickH () {
        return this.d.getHeight();
    }

    public Double getBrickW () {
        return this.d.getWidth();
    }
		@Override
    public void setPos(Pair<Double, Double> pos) {
        this.pos = pos;
    }

    @Override
    public Pair<Double, Double> getPos() {
        return this.pos;
    }

    @Override
    public BoundingBox getBoundingBox() {
        return this.box;
    }

    @Override
    public void setBoundingBox(BoundingBox box) {
        this.box = box;
    }

    @Override
    public Dimension getDimension() {
        return this.d;
    }

    public void setDimension(Dimension d){
        this.d = d;
    }

    public abstract boolean isDestroyed();

    public abstract void hit();

    public abstract Optional<Integer> getRes();

    public abstract void increaseRes(int res);

}
