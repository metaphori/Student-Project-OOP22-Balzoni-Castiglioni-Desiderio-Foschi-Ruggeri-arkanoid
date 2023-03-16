package it.unibo.game.app.api;

import it.unibo.game.app.api.BoundingBox.Side;

public interface BallPhysics {

    Direction changeDirection(Side side);

}