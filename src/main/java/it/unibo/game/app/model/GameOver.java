package it.unibo.game.app.model;

public class GameOver {
    
    protected AbstractRound round;

    public GameOver(AbstractRound round) {
        this.round = round;
    } 
    public boolean hasMissedBall() {
        if(this.round.getPosBall().getX() > this.round.getPosPad().getX()) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isRoundFinished() {
        if(this.round.getBrick().size() >= 1) {
            return false;
        }
        else {
            return true;
        }
    }
}
