package it.unibo.game.app.model.round;

import it.unibo.game.app.api.Brick;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.Round;

public class GameOver {
    
    protected Round round;

    public GameOver(Round round) {
        this.round = round;
    } 
    public boolean hasMissedBall() {
        for (var ball : this.round.getBalls()) {
          if(!(ball.getPos().getY() > this.round.getPosPad().getY())){
            return false;
          }
        }
        return true;
    }
    public boolean isRoundFinished() {
        return (this.round.getBrick().size() < 1 || remainsOnlyObstacles()) ? true : false;
    }
    public boolean remainsOnlyObstacles() {
        for (Brick element : this.round.getBrick()) {
            if(element.getType() != BrickType.OBSTACLE) {
                return false;
            }
        }
        return true;
    }
}
