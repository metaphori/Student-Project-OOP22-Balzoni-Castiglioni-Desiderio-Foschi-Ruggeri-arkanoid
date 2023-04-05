package it.unibo.game.app.model.dynamic;

import java.util.Optional;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.game.app.api.BoundingBox;
import it.unibo.game.app.api.Brick;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.api.MovingObject;
import it.unibo.game.app.api.BoundingBox.Corner;
import it.unibo.game.app.api.BoundingBox.Side;
import it.unibo.game.app.model.CircleBoundingBox;
import it.unibo.game.app.model.RectBoundingBox;
import it.unibo.game.app.model.SizeCalculation;

/**
 * Class that handles collisions.
 */
public class Collision {
  private static final double DELTA = 7.5;
  private Level level;

  /**
   * 
   * @param lev
   */
  @SuppressFBWarnings("EI_EXPOSE_REP2")
  public Collision(final Level lev) {
    this.level = lev;
  }

  /**
   * 
   * @param b Ball.
   * @param h Height of the Model world.
   * @param w Width of the Model World.
   */
  public void collideWithEdges(final MovingObject b, final Double h, final Double w) {
    b.setBoundingBox(new CircleBoundingBox(b));
    if (b.getBoundingBox().getBox().get(Corner.LEFT_DOWN).getX() <= 0.5
        || b.getBoundingBox().getBox().get(Corner.RIGHT_DOWN).getX() >= w - DELTA) {
      b.getPhysics().changeDirection(Side.LEFT_RIGHT);
    }
    if (b.getBoundingBox().getBox().get(Corner.LEFT_UP).getY() <= 0.5) {
      b.getPhysics().changeDirection(Side.UP_DOWN);
    }
  }

  /**
   * 
   * @param b boundingbox
   * @return true if collide with border
   */
  public boolean collideWithBorder(final BoundingBox b) {
    if (b.getBox().get(Corner.LEFT_DOWN).getX() <= 0.5 || b.getBox()
        .get(Corner.RIGHT_DOWN).getX() >= SizeCalculation.getWorldSize().getY() - DELTA) {
      return true;
    }
    return false;
  }

  /**
   * 
   * @param b Ball.
   * @return the index of the block that is hit by the ball.
   */
  public Optional<Integer> collideWithBrick(final MovingObject b) {
    b.setBoundingBox(new CircleBoundingBox(b));
    for (Brick obj : level.getRound().getBrick()) {
      var opt = b.getBoundingBox().collideWith(obj.getBoundingBox());

      if (opt.isPresent()) {
        if (obj.getType() == BrickType.NORMAL) {
          this.level.getScore().increaseScore();
        } else {
          this.level.getScore().resetPoints();
        }
        b.getPhysics().changeDirection(opt.get());
        return Optional.of(level.getRound().getBrick().indexOf(obj));
      }
    }
    return Optional.empty();
  }

  /**
   * 
   * @param b Ball.
   * @param p Pad.
   * @return true if the ball collide with the pad.
   */
  public boolean collideWithPad(final MovingObject b, final MovingObject p) {
    b.setBoundingBox(new CircleBoundingBox(b));
    p.setBoundingBox(new RectBoundingBox(p));
    var opt = b.getBoundingBox().collideWith(p.getBoundingBox());
    if (opt.isPresent()) {
      b.getPhysics().changeDirection(opt.get());
      return true;
    }
    return false;
  }

  /**
   * 
   * @return the score.
   */
  public int getScore() {
    return this.level.getScore().getScore();
  }

}
