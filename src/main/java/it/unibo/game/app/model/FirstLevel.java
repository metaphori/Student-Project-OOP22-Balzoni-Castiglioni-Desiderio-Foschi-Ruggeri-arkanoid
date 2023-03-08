package it.unibo.game.app.model;

public class FirstLevel extends Level{

    private final static int NORMAL_FIRST = 15;
    private final static int NORMAL_SECOND = 20;
    private final static int NORMAL_THIRD = 25;
    private final static int SURPRISE_FIRST = 2; 
    private final static int SURPRISE_SECOND = 3;
    private final static int SURPRISE_THIRD = 4;
    private final static int JUMP = 0;

    public FirstLevel() {
        this.normalBricksFirstRound = NORMAL_FIRST;
        this.normalBricksSecondRound = NORMAL_SECOND;
        this.normalBricksThirdRound = NORMAL_THIRD;
        this.surpriseBricksFirstRound = SURPRISE_FIRST;
        this.surpriseBricksSecondRound = SURPRISE_SECOND;
        this.surpriseBricksThirdRound = SURPRISE_THIRD;
    }


    @Override
    protected void setFirstRound() {
        this.currentRound = new RoundEasy(JUMP, normalBricksFirstRound, surpriseBricksFirstRound, 600, 400);
    }

    @Override
    protected void setSecondRound() {
        this.currentRound = new RoundEasy(JUMP, normalBricksSecondRound, surpriseBricksSecondRound, 600, 400);
    }

    @Override
    protected void setThirdRound() {
        this.currentRound = new RoundEasy(JUMP, normalBricksThirdRound, surpriseBricksThirdRound, 600, 400);
    }
    
}
