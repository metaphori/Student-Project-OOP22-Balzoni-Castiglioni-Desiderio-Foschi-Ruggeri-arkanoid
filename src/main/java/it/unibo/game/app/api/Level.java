package it.unibo.game.app.api;

public interface Level {
    void setFirstRound();
    void setSecondRound();
    void setThirdRound();

    int increaseLife();
    int decreaseLife();
    boolean isAlive();
    Round getRound();
    int getNumRoundPassed();
    void increaseRound();
    int getLife();
    int getId();
    Score getScore();
    void setLastSurpriseBrick(Brick suBrick, int i);
    Brick getLastSurpriseBrick();
    int getIndex();
}
