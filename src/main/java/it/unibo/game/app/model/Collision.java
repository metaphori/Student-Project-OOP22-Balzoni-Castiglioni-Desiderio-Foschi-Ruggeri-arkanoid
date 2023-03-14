package it.unibo.game.app.model;

import java.util.Optional;

import javax.print.attribute.standard.Sides;

import it.unibo.game.app.api.BoundingBox.Corner;
import it.unibo.game.app.api.BoundingBox.Side;
//devi trovare il modo per comunicare dov'è avvenuta la collisione
public class Collision {
    private AbstractLevel level;
    private BallPhysics physics;

    public Collision(AbstractLevel lev, BallPhysics physics){
        this.level = lev;
        this.physics = physics;
    
    }
    public void CollideWithEdges(Ball b, int height, int width){
        var ballBox = new BoundingBoxImpl(b);
        this.physics = new BallPhysics(b.getDir());
        if(ballBox.getBox().get(Corner.LEFT_DOWN).getY() == 0 ||ballBox.getBox().get(Corner.RIGHT_DOWN).getY() == width-1){
            physics.changeDirection(Side.LEFT_RIGHT);
        }else if(ballBox.getBox().get(Corner.LEFT_UP).getX()==0 ){
            physics.changeDirection(Side.UP_DOWN);
        }

    public Optional<Integer> isCollideWithBrick(Ball b){
        var ballBox = new BoundingBoxImpl(b);
        for (NormalBrick obj : level.getRound().getBrick()) {
            var box = new BoundingBoxImpl(obj);
            if(ballBox.collideWith(box).isPresent()){
                physics.changeDirection(ballBox.collideWith(box).get());
                return Optional.of(level.getRound().getBrick().indexOf(obj));
            }
        }
        return Optional.empty();
    }

    public boolean isCollideWithPad (Ball b, Pad p){
        var ballBox = new BoundingBoxImpl(b);
        var padBox = new BoundingBoxImpl(p);
        if(ballBox.collideWith(padBox).isPresent()) {
            physics.changeDirection(Side.UP_DOWN);
            return true;
        }
        return false;
    }
}
