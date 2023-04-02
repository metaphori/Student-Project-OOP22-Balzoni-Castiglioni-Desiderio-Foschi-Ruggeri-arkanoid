package it.unibo.game.app.model;

import it.unibo.game.app.api.Dimension;

public class DimensionImpl implements Dimension {

  private double width;
  private double hight;

  public DimensionImpl(final double hight, final double width) {
    this.hight = hight;
    this.width = width;
  }

  @Override
  public double getHeight() {

    return this.hight;
  }

  @Override
  public double getWidth() {

    return this.width;
  }

  @Override
  public void setHeight(double height) {

    this.hight = height;
  }

  @Override
  public void setWidth(double width) {

    this.width = width;
  }

  @Override
  public void increaseWidth(double width) {

    this.width += width;
  }

  @Override
  public void increaseHeight(double height) {

    this.hight += hight;
  }

}
