package it.unibo.game.app.model;

import java.util.Optional;

import it.unibo.game.Pair;
import it.unibo.game.app.api.GameObject;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.api.MovingObject;

public class Move {
    private Collision coll;
    private Optional<Integer> index ;
    private Ball ball ;
    private Pad pad;
    public Move (Level l, Ball ball, Pad p){
        coll = new Collision(l);
        this.ball = ball;
        this.pad = pad;
    }
    public void nextBall(){ 
        coll.CollideWithEdges(this.ball, SizeCalculation.getFrameSize().getX() , SizeCalculation.getFrameSize().getY());
        index = coll.collideWithBrick(this.ball);
        coll.CollideWithPad(this.ball, this.pad);
        var newPos = new Pair<Integer, Integer> (this.ball.getPos().getX() +this.ball.getPhysics().getDir().getDirection().getX(),
                                                 this.ball.getPos().getY() + this.ball.getPhysics().getDir().getDirection().getY());
        ball.setPos(newPos);
    }

    public Optional<Integer> indexBrick () {
        return index;
    }

    /*lo fa edo */
    public void nextPad(){

    }
}
