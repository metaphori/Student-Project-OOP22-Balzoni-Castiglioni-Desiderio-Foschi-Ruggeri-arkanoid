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
        return (this.round.getPosBall().getY() > this.round.getPosPad().getY()) ? true : false;
    }
    public boolean isRoundFinished() {
        return (this.round.getBrick().size() >= 1 || !remainsOnlyObstacles()) ? false : true;
    }
    public boolean remainsOnlyObstacles() {
        for (Brick element : this.round.getBrick()) {
            if(!element.getType().equals(BrickType.OBSTACLE)) {
                return false;
            }
        }
        return true;
    }
}
