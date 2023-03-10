package it.unibo.game.app.model;

public class GameOver {
    
    protected AbstractRound round;

    public GameOver(AbstractRound round) {
        this.round = round;
    } 
    public boolean hasMissedBall() {
        return (this.round.getPosBall().getX() > this.round.getPosPad().getX()) ? true : false;
    }
    public boolean isRoundFinished() {
        return (this.round.getBrick().size() >= 1) ? false : true;
    }
}
