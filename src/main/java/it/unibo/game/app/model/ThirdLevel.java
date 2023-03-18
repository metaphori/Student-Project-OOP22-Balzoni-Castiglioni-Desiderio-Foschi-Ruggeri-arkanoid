package it.unibo.game.app.model;

import it.unibo.game.Pair;

public class ThirdLevel extends AbstractLevel {

    private Pair<Integer,Integer> fSize;

    public ThirdLevel(Pair<Integer,Integer> fSize){
        this.fSize=fSize;
        this.setFirstRound();
    }

    @Override
    public void setFirstRound() {
        // TODO Auto-generated method stub
        super.currentRound=new RoundDifficult(1,6,2,new SizeCalculation(fSize.getX(),fSize.getY(),4,5,0),2);
    }

    @Override
    public void setSecondRound() {
        // TODO Auto-generated method stub
        this.currentRound=new RoundDifficult(1,13,4,new SizeCalculation(fSize.getX(),fSize.getY(),6,7,0),4);
    }

    @Override
    public void setThirdRound() {
        // TODO Auto-generated method stub
        this.currentRound=new RoundDifficult(1,16,6,new SizeCalculation(fSize.getX(),fSize.getY(),7,8,0),6);
    }

    
    
}