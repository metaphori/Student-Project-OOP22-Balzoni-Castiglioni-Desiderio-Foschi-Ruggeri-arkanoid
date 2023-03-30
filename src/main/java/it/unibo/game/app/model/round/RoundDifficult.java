package it.unibo.game.app.model.round;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Brick;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.model.DimensionImpl;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.brick.NormalBrick;
import it.unibo.game.app.model.brick.Obstacle;

/**
 * class that contains informations about different rounds in third level.
 */
public class RoundDifficult extends AbstractRound {

	private int obstacles;

	/**
	 * constructor of this class.
	 * 
	 * @param numB      num of normal bricks
	 * @param numS      num of surprise bricks
	 * @param size      information of where to collocate bricks
	 * @param obstacles num of obstacles
	 */
	public RoundDifficult(final int numB, final int numS, final SizeCalculation size, final int obstacles) {
		super(numB, numS, size);
		this.obstacles = obstacles;
		setPosBrick();
	}

	/**
	 * method that set position of bricks.
	 */
	protected void setPosBrick() {
		// TODO Auto-generated method stub
		int num = 0;
		int lines;
		for (Double i = getSizeCalc().getStart().getX(); super.brick.size() < (this.obstacles + this.getNumBrick()
				+ this.getNumSur()); i = i + getSizeCalc().getBrickDim().getX()) {
			num++;
			lines = 0;
			for (double j = SizeCalculation.getWorldSize().getY() / 2 - (num) * (getSizeCalc().getBrickDim().getY() / 2)
					- 10; lines < num; j = j + getSizeCalc().getBrickDim().getY()) {
				Brick b = new NormalBrick(BrickType.NORMAL,
						new DimensionImpl(getSizeCalc().getBrickDim().getX(), getSizeCalc().getBrickDim().getY()), new Pair<>(j, i),
						1);
				super.brick.add(b);
				lines++;
			}
		}
		setPosObstacles();
		setSurprise();
	}

	/**
	 * method that collocates surprise bricks.
	 */
	private void setSurprise() {
		int num = 0;
		while (num < getNumSur()) {
			if (setBrickSurprise()) {
				++num;
			}
		}
	}

	/**
	 * method that collocates obstacles.
	 */
	private void setPosObstacles() {
		int height = (int) Math.sqrt((double) (2 * (this.obstacles + this.getNumBrick() + this.getNumSur())));
		int first = brick.size() - height;
		int last = brick.size() - 1;
		int num = 0;
		while (num < (obstacles / 2)) {
			replace(first++);
			replace(last--);
			++num;
		}
	}

	/**
	 * method that replace a normal brick with an obstacle.
	 * 
	 * @param val position of the brick to replace in the list
	 */
	private void replace(final int val) {
		Brick oldB = brick.get(val);
		Brick newB = new Obstacle(BrickType.OBSTACLE, new DimensionImpl(oldB.getBrickH(), oldB.getBrickW()), oldB.getPos());
		brick.set(val, newB);
	}

}
