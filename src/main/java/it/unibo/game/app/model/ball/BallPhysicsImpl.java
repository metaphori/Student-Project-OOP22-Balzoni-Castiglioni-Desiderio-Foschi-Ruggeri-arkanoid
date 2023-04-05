package it.unibo.game.app.model.ball;

import it.unibo.game.app.api.Physics;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.game.app.api.Direction;
import it.unibo.game.app.api.BoundingBox.Side;
import it.unibo.game.app.model.dynamic.DirectionImpl;

/**
 * Class that manages the change of direction of the Ball.
 */
public class BallPhysicsImpl implements Physics {

  private Direction d = new DirectionImpl();

  /**
   * {@inheritDoc}
   */
  @Override
  public void changeDirection(final Side side) {
    if (side == Side.UP_DOWN) {
      if (this.d.isDirectionUp()) {
        this.d.setDirectionDown();
      } else {
        this.d.setDirectionUp();
      }
    } else if (side == Side.LEFT_RIGHT) {
      if (this.d.isDirectionLeft()) {
        this.d.setDirectionRight();
      } else {
        this.d.setDirectionLeft();
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
