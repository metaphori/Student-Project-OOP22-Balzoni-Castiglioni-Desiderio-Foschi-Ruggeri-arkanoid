package it.unibo.game.app.model;

import it.unibo.game.Pair;

public class FirstLevel extends Level{

    private final static int NORMAL_FIRST = 19;
    private final static int NORMAL_SECOND = 27;
    private final static int NORMAL_THIRD = 35;
    private final static int SURPRISE_FIRST = 2; 
    private final static int SURPRISE_SECOND = 3;
    private final static int SURPRISE_THIRD = 4;
    private final static int JUMP = 0;
    private final static int BRICK_COLUMNS = 3;
    private final static int BRICK_ROWS_FIRST = 7;
    private final static int BRICK_ROWS_SECOND = 10;
    private final static int BRICK_ROWS_THIRD = 13;

    public FirstLevel(Pair<Integer,Integer> frameSize) {
        this.normalBricksFirstRound = NORMAL_FIRST;
        this.normalBricksSecondRound = NORMAL_SECOND;
        this.normalBricksThirdRound = NORMAL_THIRD;
        this.surpriseBricksFirstRound = SURPRISE_FIRST;
        this.surpriseBricksSecondRound = SURPRISE_SECOND;
        this.surpriseBricksThirdRound = SURPRISE_THIRD;
        this.frameSize = frameSize;
    }


    @Override
    protected void setFirstRound() {
        this.sizeCalc = new SizeCalculation(frameSize.getX(), frameSize.getY(), BRICK_COLUMNS, BRICK_ROWS_FIRST);
        this.currentRound = new RoundEasy(JUMP, normalBricksFirstRound, surpriseBricksFirstRound, this.sizeCalc);
    }

    @Override
    protected void setSecondRound() {
        this.sizeCalc = new SizeCalculation(frameSize.getX(), frameSize.getY(), BRICK_COLUMNS, BRICK_ROWS_SECOND);
        this.currentRound = new RoundEasy(JUMP, normalBricksSecondRound, surpriseBricksSecondRound, this.sizeCalc);
    }

    @Override
    protected void setThirdRound() {
        this.sizeCalc = new SizeCalculation(frameSize.getX(), frameSize.getY(), BRICK_COLUMNS, BRICK_ROWS_THIRD);
        this.currentRound = new RoundEasy(JUMP, normalBricksThirdRound, surpriseBricksThirdRound, this.sizeCalc);
    }
    
}
