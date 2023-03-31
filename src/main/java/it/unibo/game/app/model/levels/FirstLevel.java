package it.unibo.game.app.model.levels;

import it.unibo.game.Pair;
import it.unibo.game.app.model.ScoreImpl;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.round.*;

public class FirstLevel extends AbstractLevel{

    private final static int NORMAL_FIRST = 19;
    private final static int NORMAL_SECOND = 27;
    private final static int NORMAL_THIRD = 35;
    private final static int SURPRISE_FIRST = 2; 
    private final static int SURPRISE_SECOND = 3;
    private final static int SURPRISE_THIRD = 4;
    private final static int BRICK_COLUMNS = 3;
    private final static int BRICK_ROWS_FIRST = 8; 
    private final static int BRICK_ROWS_SECOND = 11;
    private final static int BRICK_ROWS_THIRD = 13;

		private final static int ID = 1;
		private SizeCalculation sizeCalc;

    public FirstLevel() {
			super(ID);
      this.setFirstRound();
    }


    @Override
    public void setFirstRound() {
        this.sizeCalc = new SizeCalculation(BRICK_COLUMNS, BRICK_ROWS_FIRST, super.getNumRoundPassed());
        super.setRound(new RoundEasy(NORMAL_FIRST, SURPRISE_FIRST, this.sizeCalc));
    }

    @Override
    public void setSecondRound() {
        this.sizeCalc = new SizeCalculation( BRICK_COLUMNS, BRICK_ROWS_SECOND, super.getNumRoundPassed());
        super.setRound(new RoundEasy(NORMAL_SECOND, SURPRISE_SECOND, this.sizeCalc));
    }

    @Override
    public void setThirdRound() {
        this.sizeCalc = new SizeCalculation(BRICK_COLUMNS, BRICK_ROWS_THIRD, super.getNumRoundPassed());
        super.setRound(new RoundEasy(NORMAL_THIRD, SURPRISE_THIRD, this.sizeCalc));
    }
    
}
