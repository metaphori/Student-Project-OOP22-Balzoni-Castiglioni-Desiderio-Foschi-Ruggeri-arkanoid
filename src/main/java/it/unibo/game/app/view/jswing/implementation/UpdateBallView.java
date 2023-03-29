package it.unibo.game.app.view.jswing.implementation;

import it.unibo.game.Pair;
import it.unibo.game.app.view.jswing.api.*;

import java.awt.*;

public class UpdateBallView implements UpdateView {

    @Override
    public void update(Graphics g, Pair<Integer, Integer> dimension, Pair<Integer, Integer> pos, GameView view){
        view.drawBall(pos, dimension.getX(), g);
    }
}
