package it.unibo.game.app.model;

import org.junit.jupiter.api.Test;

import it.unibo.game.app.model.leaderb.LeaderBoard;
import it.unibo.game.app.model.leaderb.LeaderBoardImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.UUID;

public class LeaderBoardTest {

  @Test
  void leaderBoardTest() throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    String name = getString();
    String pass = getString();
    System.out.println(name+" "+pass);
    LeaderBoard l = new LeaderBoardImpl();
    l.updatePoints(name, pass, 10, 1);
    assertEquals(l.getPoints(name, pass), Optional.of(10));
    l.updatePoints(name, pass, 20, 1);
    assertEquals(l.getPoints(name, pass), Optional.of(20));
    l.updatePoints(name, pass, 40, 2);
    assertEquals(l.getPoints(name, pass), Optional.of(60));
    l.updatePoints(name, pass, 6, 2);
    assertEquals(l.getPoints(name, pass), Optional.of(26));
    l.updatePoints(name, pass, 32, 1);
    assertEquals(l.getPoints(name, pass), Optional.of(38));
  }

  private String getString() {
    UUID rand = UUID.randomUUID();
    return rand.toString().replaceAll("_", "").substring(0, 5);
  }
}
