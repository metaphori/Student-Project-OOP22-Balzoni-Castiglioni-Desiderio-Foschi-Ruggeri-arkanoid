package it.unibo.game.app.model;

import it.unibo.game.Pair;

/*Questa classe astratta dichiara variabili e definisce metodi in comune ai vari livelli */

public abstract class Level {

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


    /*Posizionano gli oggetti (pad,pallina e blocchi) all'interno di ciascun round*/
    protected abstract void setFirstRound();
    protected abstract void setSecondRound();
    protected abstract void setThirdRound();
    
    public AbstractRound getRound() {
        return this.currentRound;
    }
}
