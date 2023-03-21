package it.unibo.game.app.model.dynamic;

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
    public Move (Level l, Ball ball, Pad p){
        coll = new Collision(l);
        this.ball = ball;
        this.pad = p;
    }
    public void nextBall(long dt){ 
        coll.CollideWithEdges(this.ball, SizeCalculation.getWorldSize().getX() , SizeCalculation.getWorldSize().getY());
        //index = coll.collideWithBrick(this.ball);
        //coll.CollideWithPad(this.ball, this.pad);
        var newPos = new Pair<Double,Double> (this.ball.getPos().getX() +this.ball.getPhysics().getDir().getDirection().getX(),
                                                 this.ball.getPos().getY() + this.ball.getPhysics().getDir().getDirection().getY());
        ball.setPos(newPos);
    }

    public Optional<Integer> indexBrick () {
        return index;
    }

    
    public void update(long dt) {
        this.nextBall(dt);
    }

}
