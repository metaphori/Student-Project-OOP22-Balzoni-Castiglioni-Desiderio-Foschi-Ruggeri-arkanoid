package it.unibo.game.app.api;

public interface Dimension {

	double getHeight();

	double getWidth();

	void setHeight(double height);

	void setWidth(double width);

	void increaseWidth(double width);

	void increaseHeight(double height);
}