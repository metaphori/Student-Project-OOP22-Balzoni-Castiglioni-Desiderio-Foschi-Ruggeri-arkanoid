package it.unibo.game.app.model;



import it.unibo.game.app.api.BallPhysics;
import it.unibo.game.app.api.Direction;
import it.unibo.game.app.api.BoundingBox.Side;

public class BallPhysicsImpl implements BallPhysics {
    
    private Direction d ;

    public BallPhysicsImpl(Direction dir){
        this.d = dir;
    }
    @Override
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
