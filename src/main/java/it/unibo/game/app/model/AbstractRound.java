package it.unibo.game.app.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRound {
    
    private final int step = 1; /*Indica il bordo dei blocchi */
    private int jump; /*Serve per indicate quanti blocchi saltare se vogliamo fare le colonne */
    private int numBrick;
    private int numSurprise;
    private List<Brick> brick = new ArrayList<>();

    public AbstractRound (int jump, int numB, int numS) {
        this.jump = jump;
        this.numBrick = numB;
        this.numSurprise = numS;
    }

    public int getJump () {
        return this.jump;
    }

    public int getStep () {
        return this.step;
    }

    public int getNumBrick () {
        return this.numBrick;
    }

    public int getNumSur () {
        return this.numSurprise;
    }

    public List<Brick> getBrick () {
        return this.brick; /*Mettere quella non modificabile --> unmodifiable*/
    }

    public abstract void setPosBrick ();
}
