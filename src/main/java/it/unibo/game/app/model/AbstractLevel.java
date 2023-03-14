package it.unibo.game.app.model;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Level;

/*Questa classe astratta dichiara variabili e definisce metodi in comune ai vari livelli */

public abstract class AbstractLevel implements Level {

    private final static int INITIAL_LIVES=3;
    protected int lives = INITIAL_LIVES;

    /*Definire delle costanti per ogni livello che definiscno queste variabili */
    protected int normalBricksFirstRound;
    protected int surpriseBricksFirstRound;

    protected int normalBricksSecondRound;
    protected int surpriseBricksSecondRound;

    protected int normalBricksThirdRound;
    protected int surpriseBricksThirdRound;

    protected AbstractRound currentRound;
    protected SizeCalculation sizeCalc;

    protected Pair<Integer,Integer> frameSize;
    protected int numRoundPassed;

    /*Posizionano gli oggetti (pad,pallina e blocchi) all'interno di ciascun round*/
    public abstract void setFirstRound();
    public abstract void setSecondRound();
    public abstract void setThirdRound();

    public AbstractLevel () {
        this.numRoundPassed = 0;
    }
    public int increaseLife() {
        return this.lives++;
    }
    public int decreaseLife() {
        return this.lives--;
    }
    public boolean isAlive() {
        return this.lives > 0 ? true : false;
    }
    
    public AbstractRound getRound() {
        return this.currentRound;
    }
    public int getNumRoundPassed() {
        return this.numRoundPassed;
    }
}
