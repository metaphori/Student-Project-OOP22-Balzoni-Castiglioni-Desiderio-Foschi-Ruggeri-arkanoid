package it.unibo.game.app.model;

/*dodo*/
import it.unibo.game.Pair;
import it.unibo.game.app.api.BoundingBox;
import it.unibo.game.app.api.Dimension;
import it.unibo.game.app.api.MovingObject;
import it.unibo.game.app.api.Physics;
import it.unibo.game.app.api.Speed;
import it.unibo.game.app.model.dynamic.SpeedImpl;

public abstract class AbstractMovingObject implements MovingObject {

	private Pair<Double, Double> pos;
	private BoundingBox Bbox;
	private Speed speed;
	private Dimension d;
	private Physics pysic;

	public AbstractMovingObject(Pair<Double, Double> pos, Dimension d) {
		this.pos = pos;
		this.d = d;
		this.speed = new SpeedImpl(3, 3);
	}

	public void setDimension(Dimension d) {
		this.d = d;
	}

	@Override
	public Pair<Double, Double> getPos() {
		return this.pos;
	}

	@Override
	public BoundingBox getBoundingBox() {
		return this.Bbox;
	}

	@Override
	public void setBoundingBox(BoundingBox box) {
		this.Bbox = box;
	}

	@Override
	public void setPos(Pair<Double, Double> pos) {
		this.pos = pos;
	}

	@Override
	public Speed getSpeed() {
		// TODO Auto-generated method stub
		return this.speed;
	}

	@Override
	public void setSpeed(Speed vel) {
		// TODO Auto-generated method stub
		this.speed = vel;
	}

	@Override
	public Dimension getDimension() {
		// TODO Auto-generated method stub
		return this.d;
	}

	public Physics getPhysics() {
		return this.pysic;
	}

	public void setPhysics(Physics phsycs) {
		this.pysic = phsycs;
	}
}