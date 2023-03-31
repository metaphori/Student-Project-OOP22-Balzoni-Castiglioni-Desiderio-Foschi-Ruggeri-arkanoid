package it.unibo.game.app.model;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Dimension;

public class SizeCalculation {
    private final static Double WorldHeight = 400d;
    private final static Double WorldWidth = 300d;
    private int numBrickCol;
    private Double startX;
    private Double startY = 0d;
    private Double stopX;
    private Double stopY;
    private Double brickL;
    private Double brickH;

    public SizeCalculation(int numBrickCol, int numBrickRow, int roundPassed) {
        this.numBrickCol = numBrickCol;
        startX = (WorldHeight / 2) / 6;
        stopX = this.getStopX(roundPassed);
        brickL = WorldWidth / numBrickRow;
        brickH = (stopX - startX) / numBrickCol;
        stopY = WorldWidth -7.5;
    }

    private Double getStopX(int numR) {
        if (numBrickCol > 6) {
            return (((WorldHeight / 2) / 3) * 1.75); 
        }
        else if (numBrickCol > 4) {
            return (((WorldHeight / 2) / 3) * 1.5);
        }
        else {
           return ((WorldHeight / 2) / 3); 
        }
    }

    public static Pair<Double,Double> getWorldSize() {
        return new Pair<Double,Double>(WorldHeight, WorldWidth);
    }

    public Pair<Double,Double> getStart() {
        return new Pair<Double,Double>(startX, startY);
    }

    public Pair<Double,Double> getStop() {
        return new Pair<Double,Double>(stopX, stopY);
    }

    public Pair<Double,Double> getBrickDim() {
        return new Pair<Double,Double>(brickH, brickL);
    }

    public Double getRowCordinate(Double x) {
        return this.startX + (x * this.brickH);
    }

		public Dimension getPadDim(){
			return new DimensionImpl(WorldHeight/60,WorldWidth/4);
	}

	public Dimension getBallDim(){
			return new DimensionImpl(WorldWidth/30,WorldWidth/30);
	}
}
