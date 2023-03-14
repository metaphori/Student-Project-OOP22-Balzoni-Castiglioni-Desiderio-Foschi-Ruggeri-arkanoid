package it.unibo.game.app.api;

import it.unibo.game.app.model.AbstractRound;

public interface Level {
    void setFirstRound();
    void setSecondRound();
    void setThirdRound();

    int increaseLife();
    int decreaseLife();
    boolean isAlive();
    
    Round getRound();
    int getNumRoundPassed();
}
