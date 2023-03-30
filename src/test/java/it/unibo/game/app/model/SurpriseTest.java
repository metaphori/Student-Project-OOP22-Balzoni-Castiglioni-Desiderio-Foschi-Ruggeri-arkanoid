package it.unibo.game.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import it.unibo.game.app.api.AppController;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.controller.ControllerImpl;
import it.unibo.game.app.model.levels.FirstLevel;

public class SurpriseTest {
	
	@Test
    void testExtraLife() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
        AppController controller = new ControllerImpl();
        Level level = new FirstLevel(controller.getWorldDimension());
        Surprise surprise = new Surprise(level);

        Method method = Surprise.class.getDeclaredMethod("extraLife");
        method.setAccessible(true);
        
        int oldLives = level.getLife();
        method.invoke(surprise);
        int newLives = level.getLife();
        assertEquals(oldLives + 1, newLives);
    }
}
