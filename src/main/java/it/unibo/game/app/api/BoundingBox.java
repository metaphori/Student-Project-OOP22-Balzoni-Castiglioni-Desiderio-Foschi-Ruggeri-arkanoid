package it.unibo.game.app.api;

import java.util.Map;

import it.unibo.game.Pair;

public interface BoundingBox {
    enum Corner {LEFT_DOWN , LEFT_UP, RIGHT_DOWN, RIGHT_UP};
    Map<Corner, Pair<Integer, Integer>> getBox();
    Boolean collideWith(BoundingBox b);
}
