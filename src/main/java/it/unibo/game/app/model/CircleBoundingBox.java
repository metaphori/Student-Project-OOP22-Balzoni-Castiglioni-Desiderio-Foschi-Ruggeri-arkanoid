package it.unibo.game.app.model;

import it.unibo.game.app.api.MovingObject;

public class CircleBoundingBox  extends AbstractBoundingBox{

	public CircleBoundingBox(MovingObject obj) {
		super(obj.getDimension().getWidth(), obj.getDimension().getHeight(), obj.getPos());
		
	}
	
}
