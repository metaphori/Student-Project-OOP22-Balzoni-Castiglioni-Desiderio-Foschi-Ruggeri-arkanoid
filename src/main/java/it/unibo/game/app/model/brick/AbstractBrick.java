package it.unibo.game.app.model.brick;

import java.util.Optional;
import it.unibo.game.Pair;
import it.unibo.game.app.api.BoundingBox;
import it.unibo.game.app.api.Brick;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.Dimension;
import it.unibo.game.app.model.RectBoundingBox;

public abstract class AbstractBrick implements Brick {

	private BrickType type;
	private BoundingBox box;
	private Dimension d;
	private Pair<Double, Double> pos;

	/**
	 * 
	 * @param type type of brick
	 * @param d    dimension of brick
	 * @param pos  position of brick
	 */
	public AbstractBrick(BrickType type, Dimension d, Pair<Double, Double> pos) {
		this.type = type;
		this.pos = pos;
		this.d = d;
		this.setBoundingBox(new RectBoundingBox(this));

	}

	/**
	 * return the type of brick
	 */
	public BrickType getType() {
		return this.type;
	}

	/**
	 * method for changing the type to the brick
	 */
	public void changeType(BrickType type) {
		this.type = type;
	}

	/**
	 * return the height of brick
	 */
	public Double getBrickH() {
		return this.d.getHeight();
	}

	/**
	 * return the width of brick
	 */
	public Double getBrickW() {
		return this.d.getWidth();
	}

	/**
	 * @param pos position of brick method to set block position
	 */
	@Override
	public void setPos(Pair<Double, Double> pos) {
		this.pos = pos;
	}

	/**
	 * return the brick position
	 */
	@Override
	public Pair<Double, Double> getPos() {
		return this.pos;
	}

	/**
	 * return the boundingBox of brick
	 */
	@Override
	public BoundingBox getBoundingBox() {
		return this.box;
	}

	/**
	 * @param box boundingBox of the brick
	 */
	@Override
	public void setBoundingBox(BoundingBox box) {
		this.box = box;
	}

	/**
	 * return the dimension of brick
	 */
	@Override
	public Dimension getDimension() {
		return this.d;
	}

	/**
	 * @param d dimension of brick set the dimension of brick
	 */
	public void setDimension(Dimension d) {
		this.d = d;
	}

	public abstract boolean isDestroyed();

	public abstract void hit();

	public abstract Optional<Integer> getRes();

	public abstract void increaseRes(int res);

}
