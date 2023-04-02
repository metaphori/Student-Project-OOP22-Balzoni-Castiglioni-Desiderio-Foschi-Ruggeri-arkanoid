package it.unibo.game.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import it.unibo.game.app.api.Level;
import it.unibo.game.app.api.Score;
import it.unibo.game.app.api.Speed;
import it.unibo.game.app.model.dynamic.Move;
import it.unibo.game.app.model.dynamic.SpeedImpl;
import it.unibo.game.app.model.levels.FirstLevel;
import it.unibo.game.app.model.levels.SecondLevel;
import it.unibo.game.app.model.levels.ThirdLevel;
import it.unibo.game.app.api.Brick;
import it.unibo.game.app.api.BrickType;

public class SurpriseTest {

  @Test
  void testExtraLife() throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Level level = new FirstLevel();
    Surprise surprise = new Surprise(level);

    Method method = Surprise.class.getDeclaredMethod("extraLife");
    method.setAccessible(true);

    int oldLives = level.getLife();
    method.invoke(surprise);
    int newLives = level.getLife();
    assertEquals(oldLives + 1, newLives);
  }

  @Test
  void testChangeHard()
      throws NoSuchMethodException, SecurityException, IllegalAccessException,
      IllegalArgumentException, InvocationTargetException, InterruptedException {
    Level level = new SecondLevel();
    Surprise surprise = new Surprise(level);
    Timer timer = new Timer();

    Method method = Surprise.class.getDeclaredMethod("changeHard");
    method.setAccessible(true);

    List<Integer> oldHardIndex = new ArrayList<>();
    for (var brick : level.getRound().getBrick()) {
      if (brick.getRes().get() == 2) {
        oldHardIndex.add(level.getRound().getBrick().indexOf(brick));
      }
    }
    method.invoke(surprise);
    for (var i : oldHardIndex) {
      assertEquals(1, level.getRound().getBrick().get(i).getRes().get());
    }
    TimerTask task = new TimerTask() {

      @Override
      public void run() {
        for (var i : oldHardIndex) {
          assertEquals(2, level.getRound().getBrick().get(i).getRes().get());
        }
      }
    };
    timer.schedule(task, 10000);

  }

  @Test
  void testExplosiveBomb() throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Level level = new FirstLevel();
    Surprise surprise = new Surprise(level);
    Method method = Surprise.class.getDeclaredMethod("explosiveBomb");
    method.setAccessible(true);
    Map<Brick, Integer> mappa = new HashMap<>();
    int oldSize = level.getRound().getBrick().size();

    for (Brick brick : level.getRound().getBrick()) {
      if (brick.getType().equals(BrickType.SURPRISE)) {
        mappa.put(brick, level.getRound().getBrick().indexOf(brick));
      }
    }
    for (Map.Entry<Brick, Integer> element : mappa.entrySet()) {
      level.setLastSurpriseBrick(element.getKey(), element.getValue());
      method.invoke(surprise);
      int newSize = level.getRound().getBrick().size();
      assertTrue(oldSize >= newSize + 1 && oldSize <= newSize + 4);
      assertNotEquals(oldSize, newSize);
    }
  }

  @Test
  void initTestAddHardRow() throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Level l1 = new FirstLevel();
    Level l2 = new SecondLevel();
    Level l3 = new ThirdLevel();
    testAddHardRow(l1);
    testAddHardRow(l2);
    testAddHardRow(l3);
  }

  void testAddHardRow(Level l) throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    List<Brick> reverse = new ArrayList<>();
    Surprise surprise = new Surprise(l);
    int count = 0;
    Method method = Surprise.class.getDeclaredMethod("addHardRow");
    method.setAccessible(true);

    reverse.addAll(l.getRound().getBrick());
    Collections.reverse(reverse);
    Double y = reverse.get(0).getPos().getY();
    for (Brick brick : reverse) {
      if (brick.getPos().getY().equals(y)) {
        ++count;
      }
    }
    int oldSize = l.getRound().getBrick().size();
    method.invoke(surprise);
    if (l.getId() == 2) {
      assertEquals(oldSize + count + 2, l.getRound().getBrick().size());
    } else if (l.getId() == 1) {
      assertEquals(oldSize + count, l.getRound().getBrick().size());
    } else {
      assertEquals(oldSize + count, l.getRound().getBrick().size());
    }
    assertEquals(
        l.getRound().getBrick().get(l.getRound().getBrick().size() - 1).getPos().getX(),
        reverse.get(0).getPos().getX());
  }

  @Test
  void testIncreaseBallSpeed() throws IllegalAccessException, IllegalArgumentException,
      InvocationTargetException, NoSuchMethodException, SecurityException {
    Level level = new ThirdLevel();
    Surprise surprise = new Surprise(level);
    Speed initial = new SpeedImpl(level.getRound().getBalls().get(0).getSpeed().getX(),
        level.getRound().getBalls().get(0).getSpeed().getY());
    int num = 10;
    Method method = Surprise.class.getDeclaredMethod("increaseBallSpeed");
    method.setAccessible(true);
    for (int i = 0; i < num; i++) {
      method.invoke(surprise);
      initial.sum(new SpeedImpl(0.5, 0.2));
      assertEquals(level.getRound().getBalls().get(0).getSpeed(), initial);
    }
  }

  @Test
  void testDecreaseBallSpeed() throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Level level = new ThirdLevel();
    Surprise surprise = new Surprise(level);
    Speed initial = new SpeedImpl(level.getRound().getBalls().get(0).getSpeed().getX(),
        level.getRound().getBalls().get(0).getSpeed().getY());
    int num = 10;
    Method method = Surprise.class.getDeclaredMethod("decreaseBallSpeed");
    method.setAccessible(true);
    for (int i = 0; i < num; i++) {
      method.invoke(surprise);
      initial.sum(new SpeedImpl(-0.5, -0.2));
      assertEquals(level.getRound().getBalls().get(0).getSpeed(), initial);
    }
  }

  @Test
  void testAddBalls() throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Level level = new ThirdLevel();
    Surprise surprise = new Surprise(level);
    Move move = new Move(level);
    Method method = Surprise.class.getDeclaredMethod("addBalls");
    Method method2 = Move.class.getDeclaredMethod("update");
    method.setAccessible(true);
    method2.setAccessible(true);
    assertEquals(1, level.getRound().getBalls().size());
    method.invoke(surprise);
    method2.invoke(move);
    Boolean bool = level.getRound().getBalls().size() > 1;
    assertTrue(bool);

  }

  @Test
  void testIncreaseScore() throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Level level = new ThirdLevel();
    Score score = new ScoreImpl();
    int s = 0;
    Surprise surprise = new Surprise(level);
    /* controllo che il punteggio parta da 0 */
    assertEquals(0, score.getScore());
    score.increaseScore();
    /* controllo che lo score sia aumentato di 1 */
    assertEquals(1, score.getScore());
    Method method = Surprise.class.getDeclaredMethod("increaseScore");
    method.setAccessible(true);
    method.invoke(surprise);
    Timer timer = new Timer();

    TimerTask task = new TimerTask() {

      @Override
      public void run() {
        Integer s = score.getScore();
        score.increaseScore();
        assertEquals(s + 4, score.getScore());
      }
    };
    timer.schedule(task, 10000);

  }
}
