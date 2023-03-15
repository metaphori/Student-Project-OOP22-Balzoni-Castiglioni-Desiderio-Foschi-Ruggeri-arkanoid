package it.unibo.game.app.model;

import it.unibo.game.Pair;

public class SizeCalculation {
    private int frameSizeW;
    private int frameSizeH;
    private int numBrickCol;
    private int numBrickRow;
    private int startX;
    private int startY = 0;
    private int stopX;
    private int stopY;
    private int brickL;
    private int brickH;

    public SizeCalculation(int frameW, int frameH, int numBrickCol, int numBrickRow, int roundPassed) {
        this.frameSizeW = frameW;
        this.frameSizeH = frameH;
        this.numBrickCol = numBrickCol;
        this.numBrickRow = numBrickRow;
        startX = (frameSizeH / 2) / 6;
        stopX = this.getStopX(roundPassed);
        stopY = frameSizeW;
        brickL = frameSizeW / numBrickRow;
        brickH = (stopX - startX) / numBrickCol;
    }

    private int getStopX(int numR) {
        if (numR == 0) {
            return ((this.frameSizeH / 2) / 3);
        } else {
            return ((frameSizeH / 2) / 3) * 2;
        }
    }

    public Pair<Integer,Integer> getFrameSize() {
        return new Pair<Integer,Integer>(frameSizeH, frameSizeW);
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

}
