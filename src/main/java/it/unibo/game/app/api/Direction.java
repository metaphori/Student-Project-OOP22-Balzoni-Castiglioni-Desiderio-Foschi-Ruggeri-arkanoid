package it.unibo.game.app.api;

import it.unibo.game.Pair;

/**
 * Descrive direction o an obj that can move
 */
public interface Direction {

  void setDirectionUp();

  void setDirectionDown();

  void setDirectionLeft();

  void setDirectionRight();

  boolean isDirectionUp();

  boolean isDirectionLeft();

  /**
   * 
   * @return true if the obj go to the right
   */
  boolean isDirectionRight();

  void resetDirection();

  Pair<Integer, Integer> getDirection();

}
