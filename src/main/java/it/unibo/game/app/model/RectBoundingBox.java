package it.unibo.game.app.model;

import it.unibo.game.Pair;
import it.unibo.game.app.api.GameObject;

public class RectBoundingBox extends AbstractBoundingBox {

	public RectBoundingBox(GameObject obj) {
		super(obj.getDimension().getWidth(), obj.getDimension().getHeight(), obj.getPos());
	}
	
}
