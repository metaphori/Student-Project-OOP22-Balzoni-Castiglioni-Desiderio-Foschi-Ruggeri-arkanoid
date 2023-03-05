package it.unibo.game.app.api;

public interface UIController {
    enum PAGES {START_MENU, PAUSE_MENU, GAME, TOP_10};

    void chargeView(PAGES p);
}
