package it.unibo.game.app.model.levels;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Score;
import it.unibo.game.app.model.ScoreImpl;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.round.*;

public class SecondLevel extends AbstractLevel {
    private final static int GRAY1 = 8;
    private final static int GRAY2 = 12;
    private final static int GRAY3 = 14;
    private final static int NORMAL1 = 37;
    private final static int SURPRISE1 = 3;
    private final static int NORMAL2 = 56;
    private final static int SURPRISE2 = 4;
    private final static int NORMAL3 = 65;
    private final static int SURPRISE3 = 5;
    private final static int BRICKCOL1 = 4;
    private final static int BRICKCOL2 = 6;
    private final static int BRICKCOL3 = 7;
    private final static int BRICKROW = 15;

    
    public SecondLevel (Pair<Double, Double> pair) {
        super();
        super.levelId = 2;
        super.score = new ScoreImpl();
        this.normalBricksFirstRound = NORMAL1;
        this.surpriseBricksFirstRound = SURPRISE1;
        this.normalBricksSecondRound = NORMAL2;
        this.surpriseBricksSecondRound = SURPRISE2;
        this.normalBricksThirdRound = NORMAL3;
        this.surpriseBricksThirdRound = SURPRISE3;
        this.worldSize = pair;
        this.setFirstRound();

    }

    @Override
    public void setFirstRound() {
        this.sizeCalc = new SizeCalculation(BRICKCOL1, BRICKROW, super.getNumRoundPassed());
        this.currentRound = new RoundMedium(4, normalBricksFirstRound, surpriseBricksFirstRound, GRAY1, this.sizeCalc);
    }

    @Override
    public void setSecondRound() {
        this.sizeCalc = new SizeCalculation(BRICKCOL2, BRICKROW, super.getNumRoundPassed());
        this.currentRound = new RoundMedium(4, normalBricksSecondRound, surpriseBricksSecondRound, GRAY2, this.sizeCalc);
    }

    @Override
    public void setThirdRound() {
        this.sizeCalc = new SizeCalculation(BRICKCOL3 , BRICKROW, super.getNumRoundPassed());
        this.currentRound = new RoundMedium(4, normalBricksThirdRound, surpriseBricksThirdRound, GRAY3, this.sizeCalc);
    }
    
}
