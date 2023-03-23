package it.unibo.game.app.api;

import it.unibo.game.Pair;

public interface Direction {

    void setDirectionUp();

    void setDirectionDown();

    void setDirectionLeft();

    void setDirectionRight();

    boolean isDirectionUp();

    boolean isDirectionLeft();
    
    void resetDirection();

    Pair<Integer, Integer> getDirection();

}