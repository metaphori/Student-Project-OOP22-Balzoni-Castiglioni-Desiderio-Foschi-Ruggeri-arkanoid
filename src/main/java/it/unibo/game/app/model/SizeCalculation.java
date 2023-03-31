package it.unibo.game.app.model;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Dimension;

public class SizeCalculation {
	private final static Double WorldHeight = 400d;/* Height of the world inside the model */
	private final static Double WorldWidth = 300d; /* Width of the world inside the model */
	private int numBrickCol;
	private Double startX;
	private Double startY = 0d;
	private Double stopX;
	private Double stopY;
	private Double brickL;
	private Double brickH;

	/**
	 * 
	 * @param numBrickCol number of bricks in a column
	 * @param numBrickRow number of brick in a row
	 * @param roundPassed number of rounds passed
	 */
	public SizeCalculation(int numBrickCol, int numBrickRow, int roundPassed) {
		this.numBrickCol = numBrickCol;
		startX = (WorldHeight / 2) / 6;
		stopX = this.getStopX(roundPassed);
		brickL = WorldWidth / numBrickRow;
		brickH = (stopX - startX) / numBrickCol;
		stopY = WorldWidth - 7.5;
	}

	/**
	 * 
	 * @param numR number of rounds passed
	 * @return returns the height at which to stop the placement of the bricks
	 */
	private Double getStopX(int numR) {
		if (numBrickCol > 6) {
			return (((WorldHeight / 2) / 3) * 1.75);
		} else if (numBrickCol > 4) {
			return (((WorldHeight / 2) / 3) * 1.5);
		} else {
			return ((WorldHeight / 2) / 3);
		}
	}

	/**
	 * 
	 * @return the size of the model
	 */
	public static Pair<Double, Double> getWorldSize() {
		return new Pair<Double, Double>(WorldHeight, WorldWidth);
	}

	/**
	 * 
	 * @return the starting coordinates from which to start the positioning of the
	 *         bricks
	 */
	public Pair<Double, Double> getStart() {
		return new Pair<Double, Double>(startX, startY);
	}

	/**
	 * 
	 * @return the end coordinates from which to stop the positioning of the bricks
	 */
	public Pair<Double, Double> getStop() {
		return new Pair<Double, Double>(stopX, stopY);
	}

	/**
	 * 
	 * @return the brick dimension
	 */
	public Pair<Double, Double> getBrickDim() {
		return new Pair<Double, Double>(brickH, brickL);
	}

	/**
	 * 
	 * @param x number of row
	 * @return method used to know the y of the rows of bricks
	 */
	public Double getRowCordinate(Double x) {
		return this.startX + (x * this.brickH);
	}

	/**
	 * 
	 * @return the dimension of pad method that calculates the size of the pad
	 */
	public Dimension getPadDim() {
		return new DimensionImpl(WorldHeight / 60, WorldWidth / 4);
	}

	/**
	 * 
	 * @return the dimension of ball method that calculates the size of the ball
	 */
	public Dimension getBallDim() {
		return new DimensionImpl(WorldWidth / 30, WorldWidth / 30);
	}
}
