package it.unibo.game.app.model.round;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Brick;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.Round;

import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.ball.Ball;
import it.unibo.game.app.model.pad.Pad;

public abstract class AbstractRound implements Round {
    
    private int jump; /*Serve per indicate quanti blocchi saltare se vogliamo fare le colonne */
    private int numBrick;
    private int numSurprise;
    protected List<Brick> brick = new ArrayList<>();
    private Ball ball = new Ball();
    private Pad pad;
    private SizeCalculation sizeC;
    private final Pair<Double, Double> ballInitialPos;
    private final Pair<Double, Double> padInitialPos;
    protected List<Ball> surprise=new ArrayList<>();
    private List<Ball> extraBalls = new ArrayList<>();


    public AbstractRound (int jump, int numB, int numS, SizeCalculation size) {
        this.jump = jump;
        this.numBrick = numB;
        this.numSurprise = numS;
        this.sizeC = size;
        pad = new Pad(SizeCalculation.getWorldSize());
        this.padInitialPos = pad.getPos();
        ball.setR(SizeCalculation.getWorldSize().getY()/30);
        this.ballInitialPos = new Pair<>(padInitialPos.getX(),padInitialPos.getY()-(2*ball.getR())-5);
        ball.setPos(ballInitialPos);
    }

    public int getJump () {
        return this.jump;
    }

    public Pair<Double, Double> getBallInitialPosition() {
        this.surprise.clear();
        return this.ballInitialPos;
    }

    public List<Ball> getSurprise(){
        return this.surprise;
    }

    private void addSurprise(Ball b){
        this.surprise.add(b);
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

    public List<Brick> getBrick () {
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

    public void setPosBall (Pair<Double,Double> pos) {
        this.ball.setPos(pos);
    }

    public void setPosPad (Pair<Double,Double> pos) {
        pad.setPos(pos);
    }

    public Pair<Double,Double> getPosBall() {
        return this.ball.getPos();
    }

    public Pair<Double,Double> getPosPad() {
        return this.pad.getPos();
    }

    public Pad getPad(){
        return this.pad;
    }

    public Ball getBall(){
        return this.ball;
    }

    public void addBalls(List<Ball> b){
        this.extraBalls.addAll(b);
    }

    public List<Ball> getExtraBalls(){
        return this.extraBalls;
    }


    public void remove(int index){
        Brick brick=this.brick.get(index);
        if(brick.getType().equals(BrickType.SURPRISE)) {
            Ball b=new Ball();
            b.setPos(new Pair<>(brick.getPos().getX()+brick.getBrickW()/2,brick.getPos().getY()+brick.getBrickH()));
            b.setR(10.0);
            this.addSurprise(b);
        }
        brick.hit();
        if(brick.isDestroyed()) {
            this.brick.remove(index);
        }
    }
    public Pair<Double, Double> getInitialBallPos(){
        return this.ballInitialPos;
    }

    protected abstract void setPosBrick ();
}
