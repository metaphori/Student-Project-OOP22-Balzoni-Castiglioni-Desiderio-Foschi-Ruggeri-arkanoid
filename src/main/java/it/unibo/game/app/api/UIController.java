package it.unibo.game.app.api;

public interface UIController {
    enum PAGES {START_MENU, PAUSE_MENU, GAME, TOP_10};

    void initialView();
    void pauseMenu();
    void gameView();
    void leaderBoardView();
}
