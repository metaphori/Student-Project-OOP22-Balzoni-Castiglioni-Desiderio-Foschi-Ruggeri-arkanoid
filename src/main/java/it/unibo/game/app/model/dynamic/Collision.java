package it.unibo.game.app.model.dynamic;

import java.util.Optional;

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

public class Collision {
  private Level level;

  public Collision(Level lev) {
    this.level = lev;
  }

  public void CollideWithEdges(MovingObject b, Double h, Double w) {
    b.setBoundingBox(new CircleBoundingBox(b));
    if (b.getBoundingBox().getBox().get(Corner.LEFT_DOWN).getX() <= 0.5
        || b.getBoundingBox().getBox().get(Corner.RIGHT_DOWN).getX() >= w - 7.5) {
      b.getPhysics().changeDirection(Side.LEFT_RIGHT);
    }
    if (b.getBoundingBox().getBox().get(Corner.LEFT_UP).getY() <= 0.5) {
      b.getPhysics().changeDirection(Side.UP_DOWN);
    }
  }

  public boolean collideWithBorder(BoundingBox b) {
    if (b.getBox().get(Corner.LEFT_DOWN).getX() <= 0.5 || b.getBox()
        .get(Corner.RIGHT_DOWN).getX() >= SizeCalculation.getWorldSize().getY() - 7.5) {
      return true;
    }
    return false;
  }

  public Optional<Integer> collideWithBrick(MovingObject b) {
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

  public boolean CollideWithPad(MovingObject b, MovingObject p) {
    b.setBoundingBox(new CircleBoundingBox(b));
    p.setBoundingBox(new RectBoundingBox(p));
    var opt = b.getBoundingBox().collideWith(p.getBoundingBox());
    if (opt.isPresent()) {
      b.getPhysics().changeDirection(opt.get());
      return true;
    }
    return false;
  }

  public int getScore() {
    return this.level.getScore().getScore();
  }

}
