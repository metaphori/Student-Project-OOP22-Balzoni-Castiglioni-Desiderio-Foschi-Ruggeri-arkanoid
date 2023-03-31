package it.unibo.game.app.api;

import java.util.List;

import it.unibo.game.Pair;
import it.unibo.game.app.model.SizeCalculation;

/**
 * interface that contains useful methods to manage different rounds in a game.
 */
public interface Round {

	/**
	 * 
	 * @return object of class SizeCalculation.
	 */
	SizeCalculation getSizeCalc();

	/**
	 * 
	 * @return number of normal bricks.
	 */
	int getNumBrick();

	/**
	 * 
	 * @return number of brick surprise.
	 */
	int getNumSur();

	/**
	 * returns the ball to its initial position.
	 */
	void restart();

	/**
	 * 
	 * @return list of all bricks.
	 */
	List<Brick> getBrick();

	/**
	 * method to set ball position.
	 * 
	 * @param pos
	 */
	void setPosBall(Pair<Double, Double> pos);

	/**
	 * method to set pos of pad.
	 * 
	 * @param pos
	 */
	void setPosPad(Pair<Double, Double> pos);

	/**
	 * 
	 * @return list of surprise balls.
	 */
	List<MovingObject> getSurprise();

	/**
	 * 
	 * @return ball position.
	 */
	Pair<Double, Double> getPosBall();

	/**
	 * 
	 * @return pad position.
	 */
	Pair<Double, Double> getPosPad();

	/**
	 * 
	 * @return pad.
	 */
	MovingObject getPad();

	/**
	 * 
	 * @return ball.
	 */
	MovingObject getBall();

	/**
	 * method to remove a brick when is hitten.
	 * 
	 * @param index
	 */
	void remove(int index);

	/**
	 * 
	 * @return ball position when game starts.
	 */
	//Pair<Double, Double> getBallInitialPosition();

}
