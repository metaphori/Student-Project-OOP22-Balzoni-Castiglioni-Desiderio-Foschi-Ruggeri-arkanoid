package it.unibo.game.app.model;

import it.unibo.game.Pair;

public class SizeCalculation {
    private int frameSizeW;
    private int frameSizeH;
    private int numBrickCol;
    private int numBrickRow;
    private int startX = (frameSizeH / 2) / 6;
    private int startY = 0;
    private int stopX = ((frameSizeH / 2) / 3) * 2;
    private int stopY = frameSizeW;
    private int brickL = frameSizeW / numBrickRow;
    private int brickH = (stopX - startX) / numBrickCol;

    public SizeCalculation(int frameW, int frameH, int numBrickCol, int numBrickRow) {
        this.frameSizeW = frameW;
        this.frameSizeH = frameH;
        this.numBrickCol = numBrickCol;
        this.numBrickRow = numBrickRow;
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
