package it.unibo.game.app.view.jswing.api;
import java.awt.*;
import it.unibo.game.Pair;

public interface UpdateView {
    void update(Graphics g, Pair<Integer, Integer> dimension, Pair<Integer, Integer> pos, GameView view);
}
