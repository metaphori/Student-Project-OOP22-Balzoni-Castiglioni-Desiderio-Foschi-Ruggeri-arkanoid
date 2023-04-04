package it.unibo.game.app.model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.game.Pair;
import it.unibo.game.app.api.BoundingBox;
import it.unibo.game.app.api.Dimension;
import it.unibo.game.app.api.MovingObject;
import it.unibo.game.app.api.Physics;
import it.unibo.game.app.api.Speed;
import it.unibo.game.app.model.dynamic.SpeedImpl;

public abstract class AbstractMovingObject implements MovingObject {

  private Pair<Double, Double> pos;
  private BoundingBox box;
  private Speed speed;
  private Dimension d;
  private Physics pysic;

  public AbstractMovingObject(Pair<Double, Double> pos, Dimension d) {
    this.pos = new Pair<Double, Double>(pos.getX(), pos.getY());
    this.d = new DimensionImpl(d.getHeight(), d.getWidth());
    this.speed = new SpeedImpl(3, 3);
  }

  public void setDimension(Dimension d) {
    this.d = new DimensionImpl(d.getHeight(), d.getWidth());
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
  public void setPos(Pair<Double, Double> pos) {
    this.pos = pos;
  }

  @Override
  public Speed getSpeed() {
    return this.speed;
  }

  @Override
  public void setSpeed(Speed vel) {

    this.speed = vel;
  }

  @SuppressFBWarnings("EI_EXPOSE_REP")
  @Override
  public Dimension getDimension() {

    return this.d;
  }

  public Physics getPhysics() {
    return this.pysic;
  }

  public void setPhysics(Physics phsycs) {
    this.pysic = phsycs;
  }
}
