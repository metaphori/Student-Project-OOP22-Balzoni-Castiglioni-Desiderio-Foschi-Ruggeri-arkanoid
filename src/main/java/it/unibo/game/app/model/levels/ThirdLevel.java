package it.unibo.game.app.model.levels;

import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.round.RoundDifficult;

/**
 * class that represents the third level of the game which has the
 * characteristic of having also obstacles as bricks.
 */
public final class ThirdLevel extends AbstractLevel {

  private static final int NORMAL1 = 6;
  private static final int SURPRISE1 = 2;
  private static final int OBSTACLE1 = 2;

  private static final int NORMAL2 = 13;
  private static final int SURPRISE2 = 4;
  private static final int OBSTACLE2 = 4;

  private static final int NORMAL3 = 16;
  private static final int SURPRISE3 = 6;
  private static final int OBSTACLE3 = 6;

  private static final int ID = 3;
  private SizeCalculation sizeC;

  /**
   * constructor of this class.
   */
  public ThirdLevel() {
    super(ID);
    this.setFirstRound();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setFirstRound() {

    int h = getCol(NORMAL1, SURPRISE1, OBSTACLE1);
    this.sizeC = new SizeCalculation(h, h + 1, super.getNumRoundPassed());
    super.setRound(new RoundDifficult(NORMAL1, SURPRISE1, sizeC, OBSTACLE1));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setSecondRound() {

    int h = getCol(NORMAL2, SURPRISE2, OBSTACLE2);
    this.sizeC = new SizeCalculation(h, h + 1, super.getNumRoundPassed());
    super.setRound(new RoundDifficult(NORMAL2, SURPRISE2, sizeC, OBSTACLE2));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setThirdRound() {

    int h = getCol(NORMAL3, SURPRISE3, OBSTACLE3);
    this.sizeC = new SizeCalculation(h, h + 1, super.getNumRoundPassed());
    super.setRound(new RoundDifficult(NORMAL3, SURPRISE3, sizeC, OBSTACLE3));
  }

  /**
   * method that calculates the height of the pyramid of bricks.
   * 
   * @param normal
   * @param surprise
   * @param obstacles
   * @return height of pyramid
   */
  private int getCol(final int normal, final int surprise, final int obstacles) {
    return (int) Math.sqrt((double) (2 * (normal + surprise + obstacles)));
  }

}
