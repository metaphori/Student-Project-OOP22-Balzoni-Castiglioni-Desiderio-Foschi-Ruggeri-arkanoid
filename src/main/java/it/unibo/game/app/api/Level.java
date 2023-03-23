package it.unibo.game.app.api;

public interface Level {
    void setFirstRound();
    void setSecondRound();
    void setThirdRound();

    int increaseLife();
    int decreaseLife();
    boolean isAlive();
    boolean checkRound();
    Round getRound();
    int getNumRoundPassed();
    boolean checkLife();
}
