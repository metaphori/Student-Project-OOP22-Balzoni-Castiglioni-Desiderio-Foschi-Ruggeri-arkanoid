package it.unibo.game.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.GameObject;

public abstract class AbstractRound {
    
    private int jump; /*Serve per indicate quanti blocchi saltare se vogliamo fare le colonne */
    private int numBrick;
    private int numSurprise;
    private List<NormalBrick> brick = new ArrayList<>();
    private GameObject ball = new Ball();
    //private GameObject pad = new Pad();
    private SizeCalculation sizeC;


    public AbstractRound (int jump, int numB, int numS, SizeCalculation size) {
        this.jump = jump;
        this.numBrick = numB;
        this.numSurprise = numS;
        this.sizeC = size;
    }

    public int getJump () {
        return this.jump;
    }

    public SizeCalculation getSizeCalc() {
        return this.sizeC;
    }

    public int getNumBrick () {
        return this.numBrick;
    }

    public int getNumSur () {
        return this.numSurprise;
    }

    public List<NormalBrick> getBrick () {
        return this.brick; 
    }

    public boolean setBrickSurprise () {
        Random random = new Random();
        NormalBrick brickS;
        int idx = random.nextInt(brick.size());
        
        if (brick.get(idx).getType() == BrickType.NORMAL) {
            brickS = new NormalBrick(BrickType.SURPRISE, brick.get(idx).getBrickW(),brick.get(idx).getBrickH(), 1);
            brick.remove(idx);
            brick.add(idx, brickS);
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
    public Pair<Integer,Integer> getPosBall() {
        return this.ball.getPos();
    }
    public Pair<Integer,Integer> getPosPad() {
        return this.pad.getPos();
    }
    
    public abstract void setPosBrick ();
}
