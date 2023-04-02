package it.unibo.game.app.model.dynamic;

import java.util.Iterator;
import java.util.Optional;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.api.MovingObject;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.Surprise;

public class Move {
  private Collision coll;
  private Optional<Integer> index;
  private Level l;
  private Surprise surprise;

  public Move(Level l) {
    coll = new Collision(l);
    this.l = l;
    this.surprise = new Surprise(l);
  }

  public void nextBall(MovingObject ball) {
    coll.collideWithEdges(ball, SizeCalculation.getWorldSize().getX(),
        SizeCalculation.getWorldSize().getY());
    index = coll.collideWithBrick(ball);
    if (index.isPresent()) {
      if (this.l.getRound().getBrick().get(index.get()).getType()
          .equals(BrickType.SURPRISE)) {
        this.l.setLastSurpriseBrick(this.l.getRound().getBrick().get(index.get()),
            index.get());
      }
      this.l.getRound().remove(index.get());
    }
    if (coll.collideWithPad(ball, this.l.getRound().getPad())) {
      this.l.getScore().resetPoints();
    }
    var newPos = new Pair<Double, Double>(
        ball.getPos().getX()
            + ball.getPhysics().getDir().getDirection().getX() * ball.getSpeed().getX(),
        ball.getPos().getY()
            + ball.getPhysics().getDir().getDirection().getY() * ball.getSpeed().getY());
    ball.setPos(newPos);
  }

  private void checkSurprise() {
    Iterator<MovingObject> it = this.l.getRound().getSurprise().iterator();
    while (it.hasNext()) {
      MovingObject next = it.next();
      if (next.getPos().getY() >= SizeCalculation.getWorldSize().getX()) {
        it.remove();
      } else if (coll.collideWithPad(next, this.l.getRound().getPad())) {
        this.surprise.chooseSurprise();
        // this.surprise.bonus();
        it.remove();
      } else {
        next.setPos(
            new Pair<Double, Double>(next.getPos().getX(), next.getPos().getY() + 2));
      }
    }
  }

  public Optional<Integer> indexBrick() {
    return index;
  }

  public void update() {
    /* ora solo per una palla */
    for (var ball : this.l.getRound().getBalls()) {
      nextBall(ball);
    }
    this.checkSurprise();
    this.l.getRound().getBalls().addAll(this.l.getRound().getExtraBalls());
    this.l.getRound().getExtraBalls().clear();
  }

  public int getScore() {
    return this.coll.getScore();
  }

}
