package it.unibo.game.app.model.round;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Brick;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.MovingObject;
import it.unibo.game.app.api.Round;

import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.ball.Ball;
import it.unibo.game.app.model.dynamic.SpeedImpl;
import it.unibo.game.app.model.pad.Pad;

/**
 * class that implements the methods common to different rounds.
 */
public abstract class AbstractRound implements Round {

	private int numBrick;
	private int numSurprise;
	protected List<Brick> brick = new ArrayList<>();
	private MovingObject ball;
	private MovingObject pad;
	private SizeCalculation sizeC;
	private final Pair<Double, Double> ballInitialPos;
	// private final Pair<Double, Double> padInitialPos;
	protected List<MovingObject> surprise = new ArrayList<>();

	/**
	 * constructor of the class.
	 * 
	 * @param numB number of normal bricks
	 * @param numS number of surprise bricks
	 * @param size objects that contains information of where collocate bricks
	 */
	public AbstractRound(final int numB, final int numS, final SizeCalculation size) {
		this.numBrick = numB;
		this.numSurprise = numS;
		this.sizeC = size;
		pad = new Pad(size.getPadDim());
		// this.padInitialPos = pad.getPos();
		ball = new Ball(size.getBallDim());
		this.ballInitialPos = ball.getPos();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Pair<Double, Double> getBallInitialPosition() {
		this.surprise.clear();
		return this.ballInitialPos;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MovingObject> getSurprise() {
		return this.surprise;
	}

	/**
	 * method that add a surprise a new ball to the list.
	 * 
	 * @param ball the ball to add
	 */
	private void addSurprise(final MovingObject ball) {
		this.surprise.add(ball);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SizeCalculation getSizeCalc() {
		return this.sizeC;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNumBrick() {
		return this.numBrick;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNumSur() {
		return this.numSurprise;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Brick> getBrick() {
		return this.brick;
	}

	/**
	 * method that to randomly places surprise bricks.
	 */
	protected boolean setBrickSurprise() {
		Random random = new Random();
		int idx = random.nextInt(brick.size());

		if (brick.get(idx).getType() == BrickType.NORMAL) {
			brick.get(idx).changeType(BrickType.SURPRISE);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPosBall(final Pair<Double, Double> pos) {
		this.ball.setPos(pos);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPosPad(final Pair<Double, Double> pos) {
		pad.setPos(pos);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Pair<Double, Double> getPosBall() {
		return this.ball.getPos();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Pair<Double, Double> getPosPad() {
		return this.pad.getPos();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MovingObject getPad() {
		return this.pad;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MovingObject getBall() {
		return this.ball;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remove(final int index) {
		Brick brick = this.brick.get(index);
		if (brick.getType().equals(BrickType.SURPRISE)) {
			Ball b = new Ball(sizeC.getBallDim());
			b.setPos(new Pair<>(brick.getPos().getX() + brick.getBrickW() / 2, brick.getPos().getY() + brick.getBrickH()));
			b.setSpeed(new SpeedImpl(0, 1));
			this.addSurprise(b);
		}
		brick.hit();
		if (brick.isDestroyed()) {
			this.brick.remove(index);
		}
	}

	/**
	 * method that returns ball initial position.
	 * @return
	 */
	public Pair<Double, Double> getInitialBallPos() {
		return this.ballInitialPos;
	}

	/**
	 * method to set position of bricks.
	 */
	protected abstract void setPosBrick();
}
