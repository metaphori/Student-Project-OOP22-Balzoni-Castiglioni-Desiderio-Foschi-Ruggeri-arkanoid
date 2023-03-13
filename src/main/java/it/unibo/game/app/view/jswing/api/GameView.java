package it.unibo.game.app.view.jswing.api;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import it.unibo.game.Pair;

public interface GameView {

    void paint(Graphics g);

    void actionPerformed(ActionEvent arg0);

    void keyPressed(KeyEvent arg0);

    void keyReleased(KeyEvent arg0);

    void keyTyped(KeyEvent arg0);

    void drawBall(Pair<Integer, Integer> pos, Integer radius, Graphics g);

    void drawPad(Pair<Integer, Integer> pos, Pair<Integer, Integer> dimPad, Graphics g);

}