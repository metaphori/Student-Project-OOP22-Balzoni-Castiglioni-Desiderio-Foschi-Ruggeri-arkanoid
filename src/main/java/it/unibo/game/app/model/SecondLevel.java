package it.unibo.game.app.model;

public class SecondLevel extends Level {
    private final static int GRAY1 = 5;
    private final static int GRAY2 = 10;
    private final static int GRAY3 = 15;
    private final static int NORMAL1 = 30;
    private final static int SURPRISE1 = 5;
    private final static int NORMAL2 = 40;
    private final static int SURPRISE2 = 10;
    private final static int NORMAL3 = 50;
    private final static int SURPRISE3 = 10;

    
    public SecondLevel () {
        this.normalBricksFirstRound = NORMAL1;
        this.surpriseBricksFirstRound = SURPRISE1;
        this.normalBricksSecondRound = NORMAL2;
        this.surpriseBricksSecondRound = SURPRISE2;
        this.normalBricksThirdRound = NORMAL3;
        this.surpriseBricksThirdRound = SURPRISE3;
    }

    @Override
    protected void setFirstRound() {
        this.currentRound = new RoundMedium(1, normalBricksFirstRound, surpriseBricksFirstRound, GRAY1, 50, 25);
    }

    @Override
    protected void setSecondRound() {
        this.currentRound = new RoundMedium(1, normalBricksSecondRound, surpriseBricksSecondRound, GRAY2, 50, 25);
    }

    @Override
    protected void setThirdRound() {
        this.currentRound = new RoundMedium(1, normalBricksThirdRound, surpriseBricksThirdRound, GRAY3, 50, 25);
    }
    
}
