package it.unibo.game.app.model.dynamic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Direction;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.model.CircleBoundingBox;
import it.unibo.game.app.model.DimensionImpl;
import it.unibo.game.app.model.RectBoundingBox;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.levels.FirstLevel;
import it.unibo.game.app.model.pad.Pad;

public class CollisionTest {
  Collision colls;

  @Test
  void TestEdgesColl() {
    Level level = new FirstLevel();
    this.colls = new Collision(level);
    Direction dir = new DirectionImpl();

    /* la pallina collide con il bordo a sinistra */
    level.getRound().getBalls().get(0).setPos(new Pair<>(0.0, 100.0));
    level.getRound().getBalls().get(0).getPhysics().getDir().setDirectionLeft();
    dir.setDirectionRight();
    this.colls.CollideWithEdges(level.getRound().getBalls().get(0),
        SizeCalculation.getWorldSize().getX(), SizeCalculation.getWorldSize().getY());
    assertEquals(dir.getDirection(),
        level.getRound().getBalls().get(0).getPhysics().getDir().getDirection());

    /* la pallina collide con il bordo superiore */
    level.getRound().getBalls().get(0).setPos(new Pair<>(100.0, 0.0));
    level.getRound().getBalls().get(0).getPhysics().getDir().setDirectionUp();
    dir.setDirectionDown();
    this.colls.CollideWithEdges(level.getRound().getBalls().get(0),
        SizeCalculation.getWorldSize().getX(), SizeCalculation.getWorldSize().getY());
    assertEquals(dir.getDirection(),
        level.getRound().getBalls().get(0).getPhysics().getDir().getDirection());

    /* la pallina collide con il bordo a destra */
    level.getRound().getBalls().get(0)
        .setPos(new Pair<>(SizeCalculation.getWorldSize().getY(), 100.0));
    level.getRound().getBalls().get(0).getPhysics().getDir().setDirectionRight();
    dir.setDirectionLeft();
    this.colls.CollideWithEdges(level.getRound().getBalls().get(0),
        SizeCalculation.getWorldSize().getX(), SizeCalculation.getWorldSize().getY());
    assertEquals(dir.getDirection(),
        level.getRound().getBalls().get(0).getPhysics().getDir().getDirection());
  }

  @Test
  void TestPadColl() {
    Level level = new FirstLevel();
    this.colls = new Collision(level);
    var posPad = level.getRound().getPad().getPos();
    var dir = new DirectionImpl();

    /* collisione con il pad dall'alto */
    level.getRound().getBalls().get(0).setPos(new Pair<Double, Double>(posPad.getX() + 1,
        posPad.getY() - level.getRound().getBalls().get(0).getDimension().getHeight()));
    level.getRound().getBalls().get(0).getPhysics().getDir().setDirectionDown();
    dir.setDirectionUp();
    assertTrue(colls.CollideWithPad(level.getRound().getBalls().get(0),
        level.getRound().getPad()));
    assertEquals(dir.getDirection(),
        level.getRound().getBalls().get(0).getPhysics().getDir().getDirection());

    /* collisione con il pad da lato */
    level.getRound().getBalls().get(0)
        .setPos(new Pair<Double, Double>(
            posPad.getX() - level.getRound().getBalls().get(0).getDimension().getWidth(),
            posPad.getY()));
    level.getRound().getBalls().get(0).getPhysics().getDir().setDirectionRight();
    dir.setDirectionLeft();
    assertTrue(colls.CollideWithPad(level.getRound().getBalls().get(0),
        level.getRound().getPad()));
    assertEquals(dir.getDirection(),
        level.getRound().getBalls().get(0).getPhysics().getDir().getDirection());

    /* collisione nell'angolo */
    level.getRound().getBalls().get(0).setPos(new Pair<Double, Double>(
        posPad.getX() - level.getRound().getBalls().get(0).getDimension().getWidth(),
        posPad.getY() - level.getRound().getBalls().get(0).getDimension().getHeight()));
    level.getRound().getBalls().get(0).getPhysics().getDir().setDirectionRight();
    level.getRound().getBalls().get(0).getPhysics().getDir().setDirectionDown();
    dir.setDirectionUp();
    dir.setDirectionRight();
    assertTrue(colls.CollideWithPad(level.getRound().getBalls().get(0),
        level.getRound().getPad()));
    assertEquals(dir.getDirection(),
        level.getRound().getBalls().get(0).getPhysics().getDir().getDirection());

  }

  @Test
  void testPadInsideShene() {
    Level l = new FirstLevel();
    this.colls = new Collision(l);
    /* set pad on right side */
    var pad = new Pad(SizeCalculation.getPadDim());
    pad.setPos(new Pair<Double, Double>(
        SizeCalculation.getWorldSize().getY() - pad.getDimension().getWidth(),
        l.getRound().getPad().getPos().getY()));
    pad.setBoundingBox(new RectBoundingBox(pad));

    assertTrue(this.colls.collideWithBorder(pad.getBoundingBox()));

    /* set pad on left side */
    pad.setPos(new Pair<Double, Double>(0d, 0d));
    pad.setBoundingBox(new RectBoundingBox(pad));
    assertTrue(this.colls.collideWithBorder(pad.getBoundingBox()));

    /* set pad in the middle */
    pad.setPos(l.getRound().getPad().getPos());
    pad.setBoundingBox(new RectBoundingBox(pad));
    assertFalse(this.colls.collideWithBorder(pad.getBoundingBox()));
  }

}
