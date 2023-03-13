package it.unibo.game.app.view.jswing.impleentation;

import java.awt.Graphics;

import it.unibo.game.Pair;
import it.unibo.game.app.view.jswing.api.*;

public class UpdatePadView implements UpdateView {

    @Override
    public void update(Graphics g, Pair<Integer, Integer> dimension, Pair<Integer, Integer> pos, GameView view) {
       view.drawPad(pos, dimension, g);
    }
    
}

