package it.unibo.game.app.model;

import java.util.Optional;

import it.unibo.game.app.api.BoundingBox.Side;

public class BallPhysics {
    
    private Direction d = new Direction();

    public Direction changeDirection(Optional<Side> side){
        if(side == Optional.of(Side.UP_DOWN)){
            if(this.d.isDirectionUp()){
                this.d.setDirectionDown();
            }else{
                this.d.setDirectionUp();
            }
        }else if(side == Optional.of(Side.LEFT_RIGHT)){
            if(this.d.isDirectionLeft()){
                this.d.setDirectionRight();
            }else{
                this.d.setDirectionLeft();
            }
        }
        return this.d;
    }
 
}
