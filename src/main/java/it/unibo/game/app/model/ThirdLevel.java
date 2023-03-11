package it.unibo.game.app.model;

public class ThirdLevel extends Level {

    private AbstractRound round;

    @Override
    protected void setFirstRound() {
        // TODO Auto-generated method stub
        this.round=new RoundDifficult(1,22,4,50,25,2);
    }

    @Override
    protected void setSecondRound() {
        // TODO Auto-generated method stub
        this.round=new RoundDifficult(1,22,8,50,25,6);
    }

    @Override
    protected void setThirdRound() {
        // TODO Auto-generated method stub
        this.round=new RoundDifficult(1,26,10,50,25,9);
    }

    
    
}