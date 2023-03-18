package it.unibo.game.app.model;

import it.unibo.game.Pair;

public class SizeCalculation {
    private final static int WorldHight = 400;
    private final static int WorldWidth = 300;
    private int numBrickCol;
    private int numBrickRow;
    private int startX;
    private int startY = 0;
    private int stopX;
    private int stopY;
    private int brickL;
    private int brickH;

    public SizeCalculation(int numBrickCol, int numBrickRow, int roundPassed) {
        this.numBrickCol = numBrickCol;
        this.numBrickRow = numBrickRow;
        startX = (WorldHight / 2) / 6;
        stopX = this.getStopX(roundPassed);
        stopY = WorldWidth;
        brickL = WorldWidth / numBrickRow;
        brickH = (stopX - startX) / numBrickCol;
    }

    private int getStopX(int numR) {
        if (numR == 0) {
            return ((WorldHight / 2) / 3);
        } else {
            return ((WorldHight / 2) / 4) * 2;
        }
    }

    public static Pair<Integer,Integer> getWorldSize() {
        return new Pair<Integer,Integer>(WorldHight, WorldWidth);
    }

    public Pair<Integer,Integer> getStart() {
        return new Pair<Integer,Integer>(startX, startY);
    }

    public Pair<Integer,Integer> getStop() {
        return new Pair<Integer,Integer>(stopX, stopY);
    }

    public Pair<Integer,Integer> getBrickDim() {
        return new Pair<Integer,Integer>(brickH, brickL);
    }

    public int getRowCordinate(int x) {
        return this.startX + (x * this.brickH);
    }

}
