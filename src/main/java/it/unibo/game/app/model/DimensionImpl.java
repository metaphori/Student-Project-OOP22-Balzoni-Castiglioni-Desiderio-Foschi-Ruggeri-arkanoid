package it.unibo.game.app.model;

import it.unibo.game.app.api.Dimension;

public class DimensionImpl implements Dimension {

	private double width;
	private double hight;

	public DimensionImpl(final double hight, final double width) {
		this.hight=hight;
		this.width=width;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return this.hight;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	@Override
	public void setHeight(double height) {
		// TODO Auto-generated method stub
		this.hight=height;
	}

	@Override
	public void setWidth(double width) {
		// TODO Auto-generated method stub
		this.width=width;
	}

	@Override
	public void increaseWidth(double width) {
		// TODO Auto-generated method stub
		this.width+=width;
	}

	@Override
	public void increaseHeight(double height) {
		// TODO Auto-generated method stub
		this.hight+=hight;
	}
	
}
