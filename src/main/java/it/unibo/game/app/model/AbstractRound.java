package it.unibo.game.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.GameObject;
import it.unibo.game.app.api.Round;

public abstract class AbstractRound implements Round {
    
    private int jump; /*Serve per indicate quanti blocchi saltare se vogliamo fare le colonne */
    private int numBrick;
    private int numSurprise;
    protected List<NormalBrick> brick = new ArrayList<>();
    private Ball ball = new Ball();
    private Pad pad;
    private SizeCalculation sizeC;


    public AbstractRound (int jump, int numB, int numS, SizeCalculation size) {
        this.jump = jump;
        this.numBrick = numB;
        this.numSurprise = numS;
        this.sizeC = size;
        pad = new Pad(size.getFrameSize());
        ball.setR(size.getFrameSize().getY()/15);
        ball.setPos(new Pair<>(pad.getPos().getX(),pad.getPos().getY()-(int)ball.getR()));
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

    protected boolean setBrickSurprise () {
        Random random = new Random();
        int idx = random.nextInt(brick.size());
        
        if (brick.get(idx).getType() == BrickType.NORMAL) {
            brick.get(idx).changeType(BrickType.SURPRISE);
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
        pad.setPos(pos);
    }

    public Pair<Integer,Integer> getPosBall() {
        return this.ball.getPos();
    }

    public Pair<Integer,Integer> getPosPad() {
        return this.pad.getPos();
    }

    public Pad getPad(){
        return this.pad;
    }

    public Ball getBall(){
        return this.ball;
    }
    
    protected abstract void setPosBrick ();
}
