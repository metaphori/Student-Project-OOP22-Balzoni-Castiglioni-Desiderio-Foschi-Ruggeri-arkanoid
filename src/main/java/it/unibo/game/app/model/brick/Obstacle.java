package it.unibo.game.app.model.brick;

import java.util.Optional;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.Dimension;

/**
 * an obstacle is a brick that is undestroyable.
 */
public class Obstacle extends AbstractBrick {

  /**
   * constructor of this class.
   * 
   * @param type type of brick
   * @param d    dimension of brick
   * @param pos  position of upper-left corner
   */
  public Obstacle(final BrickType type, final Dimension d,
      final Pair<Double, Double> pos) {
    super(type, d, pos);
    // TODO Auto-generated constructor stub
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isDestroyed() {
    // TODO Auto-generated method stub
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void hit() {
    // TODO Auto-generated method stub

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<Integer> getRes() {
    // TODO Auto-generated method stub
    return Optional.empty();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void increaseRes(final int res) {
    // TODO Auto-generated method stub
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void decreaseRes(final int res) {
    // TODO Auto-generated method stub
  }

}
