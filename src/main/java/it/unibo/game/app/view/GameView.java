package it.unibo.game.app.view;

import java.util.Map;
import java.util.Random;

import javax.swing.JPanel;
import it.unibo.game.Pair;
import java.awt.*;


public class GameView extends JPanel{

    public void drawBrick(Map<Pair<Integer,Integer>, Integer> brickMap, Pair<Integer,Integer> brickDimension, Graphics g) {
        Pair<Integer,Integer> pos;
        int res; 
        Random random = new Random();
        int casualNum;

        for (var elem : brickMap.entrySet()) {
            pos = elem.getKey();
            res = elem.getValue();
            if (res != 2) {
                casualNum = random.nextInt(5);
                switch (casualNum) {
                    case 0: g.setColor(Color.BLUE);
                        break;
                    case 1: g.setColor(Color.GREEN);
                        break;
                    case 2: g.setColor(Color.MAGENTA);
                        break; 
                    case 3: g.setColor(Color.ORANGE);
                        break;  
                    case 4: g.setColor(Color.RED);
                        break;   
                    case 5: g.setColor(Color.CYAN);
                        break;      
                    default:
                        break;
                }
            } else {
                g.setColor(Color.LIGHT_GRAY);
            }
            g.fillRect(pos.getY(), pos.getX(), brickDimension.getY(), brickDimension.getX());
            g.setColor(Color.BLACK);
            g.drawRect(pos.getY(), pos.getX(), brickDimension.getY(), brickDimension.getX());
        }
    }  
}
