package it.unibo.game.app.api;

/**
 * interface Level that contains method that can be useful when a new Level starts.
 */
public interface Level {

	/**
	 * sets first round.
	 */
	void setFirstRound();

	/**
	 * sets second round.
	 */
	void setSecondRound();

	/**
	 * sets third round.
	 */
	void setThirdRound();

	/**
	 * increment lives.
	 */
	void increaseLife();

	/**
	 * decrement lives.
	 */
	void decreaseLife();

	/**
	 * 
	 * @return true if has other lives.
	 */
	boolean isAlive();

	/**
	 * 
	 * @return current round.
	 */
	Round getRound();

	/**
	 * sets new round.
	 * @param r
	 */
	void setRound(Round r);

	/**
	 * 
	 * @return number of rounds passed.
	 */
	int getNumRoundPassed();

	/**
	 * pass to next round.
	 */
	void increaseRound();

	/**
	 * 
	 * @return number of lives.
	 */
	int getLife();

	/**
	 * 
	 * @return level identifier.
	 */
	int getId();

	/**
	 * 
	 * @return player current score.
	 */
	Score getScore();

	/**
	 * 
	 * @param suBrick
	 * @param i
	 */
	void setLastSurpriseBrick(Brick suBrick, int i);

	/**
	 * 
	 * @return
	 */
	Brick getLastSurpriseBrick();

	/**
	 * 
	 * @return
	 */
	int getIndex();
}
