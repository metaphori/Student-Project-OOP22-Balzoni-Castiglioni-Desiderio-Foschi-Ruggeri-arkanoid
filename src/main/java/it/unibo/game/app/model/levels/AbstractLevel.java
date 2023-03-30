package it.unibo.game.app.model.levels;

import it.unibo.game.app.api.Brick;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.api.Round;
import it.unibo.game.app.api.Score;
import it.unibo.game.app.model.ScoreImpl;

/**
 * Questa classe astratta dichiara variabili e definisce metodi in comune ai
 * vari livelli.
 */
public abstract class AbstractLevel implements Level {

	private final static int INITIAL_LIVES = 3;
	private int lives = INITIAL_LIVES;
	private Round currentRound;
	private Score score;
	private int numRoundPassed = 0;
	private int levelId;
	private Brick lastSurpriseBrick;
	private int indexLastSurprise;

	/**
	 * constructor of this class.
	 * 
	 * @param levelId represents level identifier
	 */
	public AbstractLevel(final int levelId) {
		this.levelId = levelId;
		this.score = new ScoreImpl();
	}

	/*
	 * Posizionano gli oggetti (pad,pallina e blocchi) all'interno di ciascun round
	 */
	public abstract void setFirstRound();

	public abstract void setSecondRound();

	public abstract void setThirdRound();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void increaseLife() {
		this.lives++;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void decreaseLife() {
		this.lives--;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAlive() {
		return this.lives > 0 ? true : false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Round getRound() {
		return this.currentRound;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRound(final Round r) {
		this.currentRound = r;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNumRoundPassed() {
		return this.numRoundPassed;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void increaseRound() {
		++this.numRoundPassed;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLife() {
		return this.lives;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getId() {
		return this.levelId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Score getScore() {
		return this.score;
	}

	public void setLastSurpriseBrick(final Brick surBrick, final int i) {
		this.lastSurpriseBrick = surBrick;
		this.indexLastSurprise = i;
	}

	public int getRoundPassed() {
		return this.numRoundPassed;
	}

	public Brick getLastSurpriseBrick() {
		return this.lastSurpriseBrick;
	}

	public int getIndex() {
		return this.indexLastSurprise;
	}
}
