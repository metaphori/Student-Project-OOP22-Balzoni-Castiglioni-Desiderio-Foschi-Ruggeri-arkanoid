package it.unibo.game.app.api;

import it.unibo.game.app.api.BoundingBox.Side;

public interface Physics {

    void changeDirection(Side side);
    Direction getDir();

}