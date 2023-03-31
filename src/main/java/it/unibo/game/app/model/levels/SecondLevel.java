package it.unibo.game.app.model.levels;

import it.unibo.game.Pair;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.round.*;

public class SecondLevel extends AbstractLevel {
	private final static int BRICKROW = 15;
	private final static int JUMP = 4;

	private final static int GRAY1 = 8;
	private final static int NORMAL1 = 37;
	private final static int SURPRISE1 = 3;
	private final static int BRICKCOL1 = 4;

	private final static int GRAY2 = 12;
	private final static int NORMAL2 = 56;
	private final static int SURPRISE2 = 4;
	private final static int BRICKCOL2 = 6;

	private final static int GRAY3 = 14;
	private final static int NORMAL3 = 65;
	private final static int SURPRISE3 = 5;
	private final static int BRICKCOL3 = 7;

	private final static int ID = 2;
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
