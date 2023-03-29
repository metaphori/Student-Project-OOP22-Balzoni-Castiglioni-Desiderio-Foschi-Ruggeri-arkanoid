package it.unibo.game.app.api;
/*la calsse Speeed sono affari della Virginia */

public interface MovingObject extends GameObject {
	void setPhysics(Physics phsycs);

	Physics getPhysics();

	void setDimension(Dimension d);

	Speed getSpeed();

	void setSpeed(Speed vel);
}