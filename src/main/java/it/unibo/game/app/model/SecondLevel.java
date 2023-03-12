package it.unibo.game.app.model;

import it.unibo.game.Pair;

public class SecondLevel extends Level {
    private final static int GRAY1 = 8;
    private final static int GRAY2 = 12;
    private final static int GRAY3 = 14;
    private final static int NORMAL1 = 30;
    private final static int SURPRISE1 = 10;
    private final static int NORMAL2 = 50;
    private final static int SURPRISE2 = 10;
    private final static int NORMAL3 = 60;
    private final static int SURPRISE3 = 10;
    private final static int BRICKCOL1 = 4;
    private final static int BRICKCOL2 = 6;
    private final static int BRICKCOL3 = 7;
    private final static int BRICKROW = 15;

    
    public SecondLevel (Pair<Integer,Integer> fSize) {
        this.normalBricksFirstRound = NORMAL1;
        this.surpriseBricksFirstRound = SURPRISE1;
        this.normalBricksSecondRound = NORMAL2;
        this.surpriseBricksSecondRound = SURPRISE2;
        this.normalBricksThirdRound = NORMAL3;
        this.surpriseBricksThirdRound = SURPRISE3;
        this.frameSize = fSize;
        this.setFirstRound();
    }

    @Override
    protected void setFirstRound() {
        this.sizeCalc = new SizeCalculation(frameSize.getX(), frameSize.getY(), BRICKCOL1 - 1, BRICKROW);
        this.currentRound = new RoundMedium(4, normalBricksFirstRound, surpriseBricksFirstRound, GRAY1, this.sizeCalc);
    }

    @Override
    protected void setSecondRound() {
        this.sizeCalc = new SizeCalculation(frameSize.getX(), frameSize.getY(), BRICKCOL2 - 1, BRICKROW);
        this.currentRound = new RoundMedium(4, normalBricksSecondRound, surpriseBricksSecondRound, GRAY2, this.sizeCalc);
    }

    @Override
    protected void setThirdRound() {
        this.sizeCalc = new SizeCalculation(frameSize.getX(), frameSize.getY(), BRICKCOL3 - 1, BRICKROW);
        this.currentRound = new RoundMedium(4, normalBricksThirdRound, surpriseBricksThirdRound, GRAY3, this.sizeCalc);
    }
    
}
