package it.unibo.game.app.api;
import java.awt.*;
import it.unibo.game.Pair;
import it.unibo.game.app.view.GameView;

public interface UpdateView {
    void update(Graphics g, Pair<Integer, Integer> dimension, Pair<Integer, Integer> pos, GameView view);
}
