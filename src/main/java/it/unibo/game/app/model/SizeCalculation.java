package it.unibo.game.app.model;

import it.unibo.game.Pair;

public class SizeCalculation {
    private final static Double WorldHight = 400d;
    private final static Double WorldWidth = 300d;
    private int numBrickCol;
    //private int numBrickRow;
    private Double startX;
    private Double startY = 0d;
    private Double stopX;
    private Double stopY;
    private Double brickL;
    private Double brickH;

    public SizeCalculation(int numBrickCol, int numBrickRow, int roundPassed) {
        this.numBrickCol = numBrickCol;
        //this.numBrickRow = numBrickRow;
        startX = (WorldHight / 2) / 6;
        stopX = this.getStopX(roundPassed);
        stopY = WorldWidth;
        brickL = WorldWidth / numBrickRow;
        brickH = (stopX - startX) / numBrickCol;
    }

    private Double getStopX(int numR) {
        if (numBrickCol > 6) {
            return (((WorldHight / 2) / 3) * 1.75); 
        }
        else if (numBrickCol > 4) {
            return (((WorldHight / 2) / 3) * 1.5);
        }
        else {
           return ((WorldHight / 2) / 3); 
        }
    }

    public static Pair<Double,Double> getWorldSize() {
        return new Pair<Double,Double>(WorldHight, WorldWidth);
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

}
