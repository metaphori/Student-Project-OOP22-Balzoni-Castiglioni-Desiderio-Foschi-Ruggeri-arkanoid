package it.unibo.game.app.model;

/*Questa classe astratta dichiara variabili e definisce metodi in comune ai vari livelli */

public abstract class Level {

    /*Definire delle costanti per ogni livello che definiscno queste variabili */
    protected int NormalBricksFirstRound;
    protected int SurpriseBricksFirstRound;

    protected int NormalBricksSecondRound;
    protected int SurpriseBricksSecondRound;

    protected int NormalBricksThirdRound;
    protected int SurpriseBricksThirdRound;

    /*Posizionano gli oggetti (pad,pallina e blocchi) all'interno di ciascun round*/
    protected abstract void setFirstRound();
    protected abstract void setSecondRound();
    protected abstract void setThirdRound();
}
