package it.unibo.game.app.api;

import java.util.Map;
import java.util.Optional;

import it.unibo.game.Pair;

public interface BoundingBox {
    enum Side {UP_DOWN, LEFT_RIGHT};
    enum Corner {LEFT_DOWN , LEFT_UP, RIGHT_DOWN, RIGHT_UP};
    Map<Corner, Pair<Integer, Integer>> getBox();
    Optional<Side> collideWith(BoundingBox b);
}
