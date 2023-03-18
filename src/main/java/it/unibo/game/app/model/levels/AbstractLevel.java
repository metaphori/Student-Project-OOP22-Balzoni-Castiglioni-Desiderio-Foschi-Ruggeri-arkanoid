package it.unibo.game.app.model.levels;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.api.Round;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.round.GameOver;


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

    protected Round currentRound;
    protected SizeCalculation sizeCalc;
    private GameOver gameOver = new GameOver(currentRound);

    protected Pair<Integer,Integer> frameSize;
    protected int numRoundPassed = 0;

    /*Posizionano gli oggetti (pad,pallina e blocchi) all'interno di ciascun round*/
    public abstract void setFirstRound();
    public abstract void setSecondRound();
    public abstract void setThirdRound();

    public int increaseLife() {
        return this.lives++;
    }
    public int decreaseLife() {
        return this.lives--;
    }
    public boolean isAlive() {
        return this.lives > 0 ? true : false;
    }
    
    public Round getRound() {
        return this.currentRound;
    }
    public int getNumRoundPassed() {
        return this.numRoundPassed;
    }
    public boolean checkRound() {
        if(gameOver.isRoundFinished()) {
            this.numRoundPassed++;
            return true;
        }else {
            return false;
        }
    }
}
