package it.unibo.game.app.model.levels;

import it.unibo.game.Pair;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.round.*;

public class ThirdLevel extends AbstractLevel {

    private static final int NORMAL1=6;
    private static final int SURPRISE1=2;
    private static final int OBSTACLE1=2;

    private static final int NORMAL2=13;
    private static final int SURPRISE2=4;
    private static final int OBSTACLE2=4;

    private static final int NORMAL3=16;
    private static final int SURPRISE3=6;
    private static final int OBSTACLE3=6;

    public ThirdLevel(){
        super.levelId=3;
        this.setFirstRound();
    }

    @Override
    public void setFirstRound() {
        // TODO Auto-generated method stub
        super.currentRound=new RoundDifficult(1,NORMAL1,SURPRISE1,new SizeCalculation(4,5,0),OBSTACLE1);
    }

    @Override
    public void setSecondRound() {
        // TODO Auto-generated method stub
        this.currentRound=new RoundDifficult(1,NORMAL2,SURPRISE2,new SizeCalculation(6,7,0),OBSTACLE2);
    }

    @Override
    public void setThirdRound() {
        // TODO Auto-generated method stub
        this.currentRound=new RoundDifficult(1,NORMAL3,SURPRISE3,new SizeCalculation(7,8,0),OBSTACLE3);
    }

    
    
}