package it.unibo.game.app.model.levels;

import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.round.RoundMedium;

/**
 * class that represents the second level of the game which has the
 * characteristic of having also hardBrick as bricks.
 */
public class SecondLevel extends AbstractLevel {
  private static final int BRICKROW = 15;
  private static final int JUMP = 4;

  private static final int GRAY1 = 8;
  private static final int NORMAL1 = 37;
  private static final int SURPRISE1 = 3;
  private static final int BRICKCOL1 = 4;

  private static final int GRAY2 = 12;
  private static final int NORMAL2 = 56;
  private static final int SURPRISE2 = 4;
  private static final int BRICKCOL2 = 6;

  private static final int GRAY3 = 14;
  private static final int NORMAL3 = 65;
  private static final int SURPRISE3 = 5;
  private static final int BRICKCOL3 = 7;

  private static final int ID = 2;
  private SizeCalculation sizeC;

  /**
   * constructor of this class.
   */
  public SecondLevel() {
    super(ID);
    this.setFirstRound();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setFirstRound() {
    this.sizeC = new SizeCalculation(BRICKCOL1, BRICKROW, super.getNumRoundPassed());
    super.setRound(new RoundMedium(JUMP, NORMAL1, SURPRISE1, GRAY1, this.sizeC));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setSecondRound() {
    this.sizeC = new SizeCalculation(BRICKCOL2, BRICKROW, super.getNumRoundPassed());
    super.setRound(new RoundMedium(JUMP, NORMAL2, SURPRISE2, GRAY2, this.sizeC));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setThirdRound() {
    this.sizeC = new SizeCalculation(BRICKCOL3, BRICKROW, super.getNumRoundPassed());
    super.setRound(new RoundMedium(JUMP, NORMAL3, SURPRISE3, GRAY3, this.sizeC));
  }

}
