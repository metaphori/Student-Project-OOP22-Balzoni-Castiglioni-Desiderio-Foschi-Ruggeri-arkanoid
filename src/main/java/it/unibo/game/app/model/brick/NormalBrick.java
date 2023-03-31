package it.unibo.game.app.model.brick;

import java.util.Optional;
import it.unibo.game.Pair;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.Dimension;

public class NormalBrick extends AbstractBrick {

	private int brickResistence;

	/**
	 * 
	 * @param type
	 * @param d
	 * @param pos
	 * @param resistence resistence of the brick
	 */
	public NormalBrick(BrickType type, Dimension d, Pair<Double, Double> pos, int resistence) {
		super(type, d, pos);
		this.brickResistence = resistence;
	}

	/**
	 * returns the resistence of the brick
	 */
	@Override
	public Optional<Integer> getRes() {
		return Optional.of(this.brickResistence);
	}

	/**
	 * method that decrease the resistence of brick when hit
	 */
	@Override
	public void hit() {
		this.brickResistence--;
	}

	/**
	 * returns true if the resistence of the brick is 0
	 */
	@Override
	public boolean isDestroyed() {
		return this.brickResistence == 0;
	}

	/**
	 * @param res resistence of brick method to increase resistence of brick
	 */
	@Override
	public void increaseRes(int res) {
		this.brickResistence = ++res;
	}

	/**
	 * @param res method to decrease the resistence of brick
	 */
	public void decreaseRes(int res) {
		this.brickResistence = --res;
	}

}
