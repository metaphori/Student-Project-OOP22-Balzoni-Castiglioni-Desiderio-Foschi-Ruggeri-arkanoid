package it.unibo.game.app.model.levels;

import it.unibo.game.Pair;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.round.*;

public class ThirdLevel extends AbstractLevel {

    private Pair<Double, Double> worldSize;

    public ThirdLevel(Pair<Double, Double> pair){
        this.worldSize=pair;
        this.setFirstRound();
    }

    @Override
    public void setFirstRound() {
        // TODO Auto-generated method stub
        super.currentRound=new RoundDifficult(1,6,2,new SizeCalculation(4,5,0),2);
    }

    @Override
    public void setSecondRound() {
        // TODO Auto-generated method stub
        this.currentRound=new RoundDifficult(1,13,4,new SizeCalculation(6,7,0),4);
    }

    @Override
    public void setThirdRound() {
        // TODO Auto-generated method stub
        this.currentRound=new RoundDifficult(1,16,6,new SizeCalculation(7,8,0),6);
    }

    
    
}