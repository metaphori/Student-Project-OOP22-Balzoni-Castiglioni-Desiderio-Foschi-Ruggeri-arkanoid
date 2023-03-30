package it.unibo.game.app.model.leaderb;

import it.unibo.game.Pair;
import java.util.List;

/**
 * interface of the class that saves informations of leaderboard in a file.
 */
public interface LeaderBoard {

	/**
	 * method that let the user to save his points.
	 * @param name     of player
	 * @param passWord
	 * @param points   totalize by the player
	 * @param levelId  in which player totalize his points
	 */
  void updatePoints(String name, String passWord, Integer points, Integer levelId);

	/**
	 * 
	 * @return an ordered list that contains name and points of best five players
	 */
	List<Pair<String, Integer>> getBestFive();

}
