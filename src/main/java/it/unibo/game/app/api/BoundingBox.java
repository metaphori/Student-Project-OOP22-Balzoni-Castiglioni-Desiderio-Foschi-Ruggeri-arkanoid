package it.unibo.game.app.api;

import it.unibo.game.Pair;

public interface BoundingBox {
    Pair<Integer, Integer> getLeftCornerDown();
    Pair<Integer, Integer> getLeftCornerUP();
    Pair<Integer, Integer> getRightConrnerDown();
    Pair<Integer, Integer> getRightConrnerUp();
    Boolean collideWith(BoundingBox b);
}
