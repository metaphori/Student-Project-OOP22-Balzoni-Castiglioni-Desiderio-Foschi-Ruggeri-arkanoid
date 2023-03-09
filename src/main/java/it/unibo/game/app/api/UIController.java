package it.unibo.game.app.api;

import java.util.Map;

import it.unibo.game.Pair;

public interface UIController {
    enum PAGES {START_MENU, PAUSE_MENU, GAME, TOP_10};

    void initialView();
    void pauseMenu();
    void gameView();
    void leaderBoardView();
    void level(int numLevel);
    Map<Pair<Integer, Integer>, Integer> getList();
    Pair<Integer,Integer> getDimension();
}
