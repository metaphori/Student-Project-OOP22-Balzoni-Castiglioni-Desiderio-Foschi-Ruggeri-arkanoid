package it.unibo.game.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.unibo.game.app.api.Level;
import it.unibo.game.app.model.levels.FirstLevel;
import it.unibo.game.app.model.levels.SecondLevel;
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

		Method method = Surprise.class.getDeclaredMethod("changeHard");
		method.setAccessible(true);

		List<Integer> oldHardIndex = new ArrayList<>();
		/*
		 * level.getRound().getBrick().stream().filter(b -> b.getRes().get().equals(2))
		 * .map(b -> oldHardIndex.add(level.getRound().getBrick().indexOf(b)));
		 */
		for (var brick : level.getRound().getBrick()) {
			if (brick.getRes().get() == 2) {
				oldHardIndex.add(level.getRound().getBrick().indexOf(brick));
			}
		}
		method.invoke(surprise);
		for (var i : oldHardIndex) {
			assertEquals(1, level.getRound().getBrick().get(i).getRes().get());
		}
		Thread.sleep(10010);
		for (var i : oldHardIndex) {
			assertEquals(2, level.getRound().getBrick().get(i).getRes().get());
		}
	}

  @Test 
  void testExplosiveBomb() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Level level = new FirstLevel();
    Surprise surprise = new Surprise(level);
    Method method = Surprise.class.getDeclaredMethod("explosiveBomb");
    method.setAccessible(true);
    Map<Brick,Integer> mappa = new HashMap<>();
    int oldSize = level.getRound().getBrick().size();

    for(Brick brick : level.getRound().getBrick()) {
      if(brick.getType().equals(BrickType.SURPRISE)) {
        mappa.put(brick, level.getRound().getBrick().indexOf(brick));
      }
    }			
    for (Map.Entry<Brick,Integer> element : mappa.entrySet()) {
      level.setLastSurpriseBrick(element.getKey(), element.getValue());
      method.invoke(surprise);
      int newSize = level.getRound().getBrick().size();
      assertTrue(oldSize == newSize +1 || oldSize == newSize +2 || oldSize == newSize +3 || oldSize == newSize +4);
      assertNotEquals(oldSize, newSize);
    }
  }
}
