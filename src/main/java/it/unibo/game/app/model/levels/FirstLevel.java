package it.unibo.game.app.model.levels;

import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.round.RoundEasy;

/**
 * Define the three round of FirstLevel.
 */
public class FirstLevel extends AbstractLevel {

  private static final int NORMAL_FIRST = 19;
  private static final int NORMAL_SECOND = 27;
  private static final int NORMAL_THIRD = 35;
  private static final int SURPRISE_FIRST = 2;
  private static final int SURPRISE_SECOND = 3;
  private static final int SURPRISE_THIRD = 4;
  private static final int BRICK_COLUMNS = 3;
  private static final int BRICK_ROWS_FIRST = 8;
  private static final int BRICK_ROWS_SECOND = 11;
  private static final int BRICK_ROWS_THIRD = 13;

  private static final int ID = 1;
  private SizeCalculation sizeCalc;

  /**
   * Constructor of the class.
   */
  public FirstLevel() {
    super(ID);
    this.setFirstRound();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setFirstRound() {
    this.sizeCalc = new SizeCalculation(BRICK_COLUMNS, BRICK_ROWS_FIRST,
        super.getNumRoundPassed());
    super.setRound(new RoundEasy(NORMAL_FIRST, SURPRISE_FIRST, this.sizeCalc));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setSecondRound() {
    this.sizeCalc = new SizeCalculation(BRICK_COLUMNS, BRICK_ROWS_SECOND,
        super.getNumRoundPassed());
    super.setRound(new RoundEasy(NORMAL_SECOND, SURPRISE_SECOND, this.sizeCalc));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setThirdRound() {
    this.sizeCalc = new SizeCalculation(BRICK_COLUMNS, BRICK_ROWS_THIRD,
        super.getNumRoundPassed());
    super.setRound(new RoundEasy(NORMAL_THIRD, SURPRISE_THIRD, this.sizeCalc));
  }

}
