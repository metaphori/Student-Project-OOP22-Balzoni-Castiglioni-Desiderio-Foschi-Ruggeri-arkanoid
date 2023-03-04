package it.unibo.game.app.model;

import java.util.ArrayList;
import java.util.List;

import it.unibo.game.Pair;

public abstract class AbstractRound {
    
    private final int step = 1; /*Indica il bordo dei blocchi */
    private int jump; /*Serve per indicate quanti blocchi saltare se vogliamo fare le colonne */
    private int numBrick;
    private int numSurprise;
    private List<Brick> brick = new ArrayList<>();
    private GameObj ball = new Ball();
    //private GameObj pad = new Pad();

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

    public void setPosBall (Pair<Integer,Integer> pos) {
        this.ball.setPos(pos);
    }

    public void setPosPad (Pair<Integer,Integer> pos) {
        //pad.setPos(pos);
    }
}
