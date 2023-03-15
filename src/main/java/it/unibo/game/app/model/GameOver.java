package it.unibo.game.app.model;

import it.unibo.game.app.api.Round;

public class GameOver {
    
    protected Round round;

    public GameOver(Round round) {
        this.round = round;
    } 
    public boolean hasMissedBall() {
        return (this.round.getPosBall().getX() > this.round.getPosPad().getX()) ? true : false;
    }
    public boolean isRoundFinished() {
        return (this.round.getBrick().size() >= 1) ? false : true;
    }
}
