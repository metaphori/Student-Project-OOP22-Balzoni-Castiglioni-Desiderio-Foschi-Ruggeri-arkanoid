package it.unibo.game.app.view;

import java.util.Map;
import java.awt.*;

import it.unibo.game.Pair;

public class BrickView {
    public void update (Map<Pair<Integer, Integer>, Integer> bricks, Pair<Integer,Integer> brickDimension, GameView view, Graphics g){
        view.drawBrick(bricks, brickDimension, g );
    }
}
