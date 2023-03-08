package it.unibo.game.app.model;

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


    /*Posizionano gli oggetti (pad,pallina e blocchi) all'interno di ciascun round*/
    protected abstract void setFirstRound();
    protected abstract void setSecondRound();
    protected abstract void setThirdRound();
    
    public AbstractRound getRound() {
        return this.currentRound;
    }
}
