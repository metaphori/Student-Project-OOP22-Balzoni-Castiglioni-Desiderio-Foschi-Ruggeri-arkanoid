package it.unibo.game.app.model.dynamic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.Surprise;
import it.unibo.game.app.model.ball.Ball;
import it.unibo.game.app.model.pad.Pad;

public class Move {
    private Collision coll;
    private Optional<Integer> index ;
    private List<Ball> balls = new ArrayList<>();
    private Pad pad;
    private Level l;
    private Surprise surprise;

    public Move (Level l, Ball ball, Pad p){
        coll = new Collision(l);
        this.balls= List.of(ball);
        this.pad = p;
        this.l=l;
        this.surprise = new Surprise(l);
    }

    public void nextBall(long dt, Ball ball){ 
        coll.CollideWithEdges(ball, SizeCalculation.getWorldSize().getX() , SizeCalculation.getWorldSize().getY());
        index = coll.collideWithBrick(ball);
        if(index.isPresent()){
            if(this.l.getRound().getBrick().get(index.get()).getType().equals(BrickType.SURPRISE)) {
                this.l.setLastSurpriseBrick(this.l.getRound().getBrick().get(index.get()), index.get()); 
            }
            this.l.getRound().remove(index.get());
        }
        if(coll.CollideWithPad(ball, this.pad)){
            this.l.getScore().resetPoints();
        }
        var newPos = new Pair<Double,Double> (ball.getPos().getX() +ball.getPhysics().getDir().getDirection().getX() * 3,
                                                 ball.getPos().getY() + ball.getPhysics().getDir().getDirection().getY() * 3);
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
                this.surprise.chooseSurprise();
                //this.surprise.bonus();
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

        for(var ball : this.balls){
            nextBall(dt, ball);
        }
    }
    public void setExtraBalls(){
        this.balls.addAll(l.getRound().getExtraBalls());
    }
    public int getScore(){
        return this.coll.getScore();
    }

}
