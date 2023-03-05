package it.unibo.game.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.GameObject;

public abstract class AbstractRound {
    
    protected final int step = 2; /*Indica il bordo dei blocchi */
    private int jump; /*Serve per indicate quanti blocchi saltare se vogliamo fare le colonne */
    private int setColor = 0; /*serve per settare il colore */
    private int numBrick;
    private int numSurprise;
    private List<Brick> brick = new ArrayList<>();
    private GameObject ball = new Ball();
    //private GameObject pad = new Pad();
    protected int brickH; /*Ci servono all'inzio del round per sapere quanto fare i brick grandi che dipendono dalla finestra */
    protected int brickW;

    public AbstractRound (int jump, int numB, int numS, int bH, int bW) {
        this.jump = jump;
        this.numBrick = numB;
        this.numSurprise = numS;
        this.brickH = bH;
        this.brickW = bW;
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

    public boolean setBrickSurprise () {
        Random random = new Random();
        GameObj brickS;
        int idx = random.nextInt(brick.size());
        
        if (brick.get(idx).getType() == BrickType.NORMAL) {
            brickS = new Brick(BrickType.SURPRISE, brick.get(idx).getBrickW(),brick.get(idx).getBrickH() , brick.get(idx).getBrickColor());
            brick.remove(idx);
            brick.add(idx, (Brick)brickS);
            return true;
        }
        else {
            return false;
        }
    }

    public void setPosBall (Pair<Integer,Integer> pos) {
        this.ball.setPos(pos);
    }

    public void setPosPad (Pair<Integer,Integer> pos) {
        //pad.setPos(pos);
    }
    
    public abstract void setPosBrick ();
}
