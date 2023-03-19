package it.unibo.game.app.model.dynamic;

import java.util.Optional;

import it.unibo.game.app.api.Level;
import it.unibo.game.app.api.BoundingBox.Corner;
import it.unibo.game.app.api.BoundingBox.Side;
import it.unibo.game.app.model.ball.*;
import it.unibo.game.app.model.brick.NormalBrick;
import it.unibo.game.app.model.pad.Pad;
import it.unibo.game.app.model.BoundingBoxImpl;
import it.unibo.game.app.model.*;

public class Collision {
    private Level level;
    private Score score = new Score();

    public Collision(Level lev){
        this.level = lev;
    }
    public void CollideWithEdges(Ball b, Double double1, Double double2){
        var ballBox = new BoundingBoxImpl(b);
        if(ballBox.getBox().get(Corner.LEFT_DOWN).getY() == 0 ||ballBox.getBox().get(Corner.RIGHT_DOWN).getY() == double2-1){
            b.getPhysics().changeDirection(Side.LEFT_RIGHT);
        }else if(ballBox.getBox().get(Corner.LEFT_UP).getX()==0 ){
            b.getPhysics().changeDirection(Side.UP_DOWN);
        }
    }

    public Optional<Integer> collideWithBrick(Ball b){
        var ballBox = new BoundingBoxImpl(b);
        for (NormalBrick obj : level.getRound().getBrick()) {
            var box = new BoundingBoxImpl(obj);
            if(ballBox.collideWith(box).isPresent()){
                this.score.increaseScore();
                b.getPhysics().changeDirection(ballBox.collideWith(box).get());
                return Optional.of(level.getRound().getBrick().indexOf(obj));
            }
        }
        return Optional.empty();
    }

    public void CollideWithPad (Ball b, Pad p){
        var ballBox = new BoundingBoxImpl(b);
        var padBox = new BoundingBoxImpl(p);
        if(ballBox.collideWith(padBox).isPresent()) {
            this.score.resetPoints();
            b.getPhysics().changeDirection(Side.UP_DOWN);
        
        }
    }
}
