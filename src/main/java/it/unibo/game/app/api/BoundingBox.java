package it.unibo.game.app.api;

import java.util.Map;
import java.util.Optional;

import it.unibo.game.Pair;

public interface BoundingBox {
	/**
	 * Side where the box collide.
	 */
	enum Side {
		/**
		 * Side top and bottom.
		 */
		UP_DOWN,
		/**
		 * Side left and right.
		 */
		LEFT_RIGHT
	};

	/**
	 * Corners of the bounding box.
	 */
	enum Corner {
		LEFT_DOWN, LEFT_UP, RIGHT_DOWN, RIGHT_UP
	};

	/**
	 * 
	 * @return Map of Corners and their respective coordinates.
	 */
	Map<Corner, Pair<Double, Double>> getBox();

	/**
	 * 
	 * @param b BoundinBox of the GameObject with which the collision could occur.
	 * @return the side where the box collide or an empty optional if no collision.
	 *         occurs
	 */
	Optional<Side> collideWith(BoundingBox b);
}
