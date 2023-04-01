package it.unibo.game.app.api;

import it.unibo.game.Pair;

public interface GameObject {
	/*
	 * game object deve implementare tutti i metodi degli oggetti di gioco
	 * considerando che siano statici
	 */
	void setPos(Pair<Double, Double> pos);

	Pair<Double, Double> getPos();

	BoundingBox getBoundingBox();

	void setBoundingBox(BoundingBox box);

	Dimension getDimension();

	void setDimension(Dimension d);
}