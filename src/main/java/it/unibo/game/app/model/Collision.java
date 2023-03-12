package it.unibo.game.app.model;

import java.util.Optional;

import it.unibo.game.app.api.BoundingBox.Corner;
import it.unibo.game.app.api.BoundingBox.Side;
//devi trovare il modo per comunicare dov'è avvenuta la collisione
public class Collision {
    private Level level;
    private BallPhysics physics;

    public Collision(Level lev, BallPhysics physics){
        this.level = lev;
        this.physics = physics;
    
    }
    public Optional<Side> isCollideWithEdges(Ball b, int height, int width){
        var ballBox = new BoundingBoxImpl(b);
        if(ballBox.getBox().get(Corner.LEFT_DOWN).getY() == 0 ||ballBox.getBox().get(Corner.RIGHT_DOWN).getY() == width-1){
            return Optional.of(Side.LEFT_RIGHT);
        }else if(ballBox.getBox().get(Corner.LEFT_UP).getX()==0 /* || ballBox.getBox().get(Corner.RIGHT_DOWN).getX() == height-1 */){
            return Optional.of(Side.UP_DOWN);
        }
        //}  non so se va gestito nel game over
        return Optional.empty();
    }

    public boolean isCollideWithBrick(Ball b){
        var ballBox = new BoundingBoxImpl(b);
        for (NormalBrick obj : level.getRound().getBrick()) {
            var box = new BoundingBoxImpl(obj);
            if(ballBox.collideWith(box)){
                return true;
            }
        }
        return false;
    }

    public boolean isCollideWithPad (Ball b, Pad p){
        var ballBox = new BoundingBoxImpl(b);
        var padBox = new BoundingBoxImpl(p);

        return ballBox.collideWith(padBox);
    }
}
