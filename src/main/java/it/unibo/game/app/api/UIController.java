package it.unibo.game.app.api;

import java.util.Map;

import it.unibo.game.Pair;
import java.util.*;
import it.unibo.game.app.model.*;

public interface UIController {
    enum PAGES {
        START_MENU("START MENU"), 
        PAUSE_MENU("PAUSE MENU"), 
        GAME("ARKANOID"), 
        TOP_10("TOP FIVE");

        String name;

        PAGES(String name){
            this.name=name;
        }

        public String getName(){
            return this.name;
        }
    };

    void initialView();
    void pauseMenu();
    void gameView();
    void leaderBoardView();
    void level(int numLevel);
    Map<Pair<Integer, Integer>, Integer> getList();
    Pair<Integer,Integer> getDimension();
    Pair<Integer,Integer> getDimensionBrick();
    Pair<Integer,Integer> getBall();
    Pair<Integer,Integer> getPad();
    //aggiunto
    void changePosPad(Pair<Integer,Integer> pos);
    int getPadWight();
    int getPadHeight();
    double getRBall();
    void rPaint();
}
