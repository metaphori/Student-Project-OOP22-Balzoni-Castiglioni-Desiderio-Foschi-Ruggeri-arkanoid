package it.unibo.game.app.model.dynamic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.api.MovingObject;
import it.unibo.game.app.model.levels.FirstLevel;

public class MoveTest {
  @Test
  void testUpdate() {
    Level level = new FirstLevel();
    level.setFirstRound();
    Move move = new Move(level);
    Pair<Double, Double> pos = level.getRound().getBalls().get(0).getPos();
    move.update();
    pos = new Pair<Double, Double>(pos.getX()
        + (level.getRound().getBalls().get(0).getPhysics().getDir().getDirection().getX())
            * level.getRound().getBalls().get(0).getSpeed().getX(),
        pos.getY()
            + level.getRound().getBalls().get(0).getPhysics().getDir().getDirection()
                .getY() * level.getRound().getBalls().get(0).getSpeed().getY());
    assertEquals(pos, level.getRound().getBalls().get(0).getPos());
  }
}
