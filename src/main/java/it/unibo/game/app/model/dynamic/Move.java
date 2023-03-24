package it.unibo.game.app.model.dynamic;

import java.util.Iterator;
import java.util.Optional;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.ball.Ball;
import it.unibo.game.app.model.pad.Pad;

public class Move {
    private Collision coll;
    private Optional<Integer> index ;
    private Ball ball ;
    private Pad pad;
    private Level l;
    //private Surprise surprise;

    public Move (Level l, Ball ball, Pad p){
        coll = new Collision(l);
        this.ball = ball;
        this.pad = p;
        this.l=l;
        //this.surprise = new Surprise(l);
    }

    public void nextBall(long dt){ 
        coll.CollideWithEdges(this.ball, SizeCalculation.getWorldSize().getX() , SizeCalculation.getWorldSize().getY());
        index = coll.collideWithBrick(this.ball);
        if(index.isPresent()){
            this.l.getRound().remove(index.get());
        }
        coll.CollideWithPad(this.ball, this.pad);
        var newPos = new Pair<Double,Double> (this.ball.getPos().getX() +this.ball.getPhysics().getDir().getDirection().getX() * 3,
                                                 this.ball.getPos().getY() + this.ball.getPhysics().getDir().getDirection().getY() * 3);
        ball.setPos(newPos);
        this.checkSurprise();
    }

    private void checkSurprise(){
        Iterator<Ball> it = this.l.getRound().getSurprise().iterator();
        while(it.hasNext()) {
            Ball next=it.next();
            if(next.getPos().getY()>=SizeCalculation.getWorldSize().getX()) {
                it.remove();
            }
            else if(coll.CollideWithPad(next, this.pad)) {
                //this.surprise.chooseSurprise();
                it.remove();
            }
            else {
                next.setPos(new Pair<Double,Double> (next.getPos().getX(),next.getPos().getY() + 2));
            }
        }
    }

    public Optional<Integer> indexBrick () {
        return index;
    }

    
    public void update(long dt) {
        this.nextBall(dt);
    }

    public int getScore(){
        return this.coll.getScore();
    }

}
