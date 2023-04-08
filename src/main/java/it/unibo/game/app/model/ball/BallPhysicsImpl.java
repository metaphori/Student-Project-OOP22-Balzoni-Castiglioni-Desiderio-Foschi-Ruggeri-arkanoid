package it.unibo.game.app.model.ball;

import it.unibo.game.app.api.Physics;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.game.Pair;
import it.unibo.game.app.api.Direction;
import it.unibo.game.app.api.Side;
import it.unibo.game.app.model.dynamic.DirectionImpl;

/**
 * Class that manages the change of direction of the Ball.
 */
public class BallPhysicsImpl implements Physics {

  private Direction d = new DirectionImpl();
  private Pair<Integer, Integer> temp;
  private boolean centre = false;

  public BallPhysicsImpl() {
    this.temp = d.getDirection();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void changeDirection(final Side side) {
    this.d.setDirection(temp);
    if (centre) {
      d.setDirectionUp();
      centre = false;
    }

    switch (side) {
    case CORNER: {
      if (this.d.isDirectionLeft()) {
        this.d.setDirectionRight();
      } else {
        this.d.setDirectionLeft();
      }

      if (this.d.isDirectionUp()) {
        this.d.setDirectionDown();
      } else {
        this.d.setDirectionUp();
      }
      temp = d.getDirection();
    }
      break;
    case LEFT_RIGHT: {
      if (this.d.isDirectionLeft()) {
        this.d.setDirectionRight();
      } else {
        this.d.setDirectionLeft();
      }
      temp = d.getDirection();

    }
      break;
    case UP_DOWN: {
      if (this.d.isDirectionUp()) {
        this.d.setDirectionDown();
      } else {
        this.d.setDirectionUp();
      }
      temp = d.getDirection();
    }
      break;
    case PAD_CENTRE: {
      centre = true;
      d.setDirection(new Pair<Integer, Integer>(0, -2));
    }

    }

  }

  /**
   * {@inheritDoc}
   */
  @SuppressFBWarnings("EI_EXPOSE_REP")
  @Override
  public Direction getDir() {
    return this.d;
  }

}
