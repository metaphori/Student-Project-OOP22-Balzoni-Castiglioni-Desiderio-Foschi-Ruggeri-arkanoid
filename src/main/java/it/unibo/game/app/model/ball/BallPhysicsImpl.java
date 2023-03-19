package it.unibo.game.app.model.ball;



import it.unibo.game.Pair;
import it.unibo.game.app.api.Physics;
import it.unibo.game.app.api.Direction;
import it.unibo.game.app.api.BoundingBox.Side;

public class BallPhysicsImpl implements Physics {
   
    private Direction d ;

    @Override
    public void changeDirection(Side side){
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
    }

    public Direction getDir(){
        return this.d;
    }
    
 
}
