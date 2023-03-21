package it.unibo.game.app.view.jswing.api;

import java.util.Map;
import java.util.Optional;

import it.unibo.game.Pair;
import it.unibo.game.app.api.AppController;

public interface UIController {
    enum PAGES {
        START_MENU("START MENU"), 
        PAUSE_MENU("PAUSE MENU"), 
        GAME("ARKANOID"), 
        TOP_5("TOP FIVE"),
        VICTORY("VICTORY"),
        GAME_OVER("GAME_OVER");

        String name;

        PAGES(String name){
            this.name=name;
        }

        public String getName(){
            return this.name;
        }
    };

    void setController(AppController observer);
    void initialView();
    void pauseMenu();
    void gameView();
    void leaderBoardView();
    void gameOver();
    void victory();
    void level(int numLevel);
    Map<Pair<Double, Double>, Optional<Integer>> getList();
    Pair<Double, Double> getDimension();
    Pair<Double, Double> getDimensionBrick();
    Pair<Double, Double> getBall();
    Pair<Double, Double> getPadPos();
    
    Double getPadWight();
    Double getPadHeight();
    Double getRBall();
    void rPaint();
    Double getRowC(Double x);
    void movePadLeft();
    void movePadRight();
    
}
