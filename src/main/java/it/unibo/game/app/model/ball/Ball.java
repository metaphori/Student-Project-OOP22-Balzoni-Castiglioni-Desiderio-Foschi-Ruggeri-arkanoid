package it.unibo.game.app.model.ball;

import it.unibo.game.app.model.AbstractMovingObject;
import it.unibo.game.app.model.CircleBoundingBox;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.dynamic.SpeedImpl;
import it.unibo.game.Pair;
import it.unibo.game.app.api.Dimension;

public class Ball extends AbstractMovingObject {

  public Ball(Dimension d) {
    super(new Pair<>(SizeCalculation.getWorldSize().getY() / 2 - d.getWidth() / 2,
        (SizeCalculation.getWorldSize().getX() - 100) - (2 * d.getHeight()) - 5), d);
    super.setSpeed(new SpeedImpl(4, 3));
    super.setPhysics(new BallPhysicsImpl());
    super.setBoundingBox(new CircleBoundingBox(this));
  }

}
