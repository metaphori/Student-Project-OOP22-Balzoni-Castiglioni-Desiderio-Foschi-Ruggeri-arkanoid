package it.unibo.game.app.model;

import java.util.Optional;

import it.unibo.game.app.api.Direction;
import it.unibo.game.app.api.BoundingBox.Side;

public class BallPhysics {
    
    private Direction d ;

    public BallPhysics (Direction dir){
        this.d = dir;
    }
    public Direction changeDirection(Side side){
        if(side == Side.UP_DOWN){
            if(this.d.isDirectionUp()){
                this.d.setDirectionDown();
            }else{
                this.d.setDirectionUp();
            }
        }else if(side == Side.LEFT_RIGHT){
            if(this.d.isDirectionLeft()){
                this.d.setDirectionRight();
            }else{
                this.d.setDirectionLeft();
            }
        }
        return this.d;
    }
 
}
