package it.unibo.game.app.model;

import java.util.Map;
import java.util.stream.Collectors;

import it.unibo.game.Pair;
import it.unibo.game.app.api.AppController;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.api.Model;

public class ModelImpl implements Model{

    private AppController control;
    private Level level;

    @Override
    public void setController(AppController c) {
        // TODO Auto-generated method stub
        this.control=c;
        this.level=new FirstLevel(this.control.getFrameDimension());
    }

    @Override
    public Map<Pair<Integer, Integer>, Integer> getBrickList() {
        // TODO Auto-generated method stub
        return this.level.getRound().getBrick().stream().collect(
                            Collectors.toMap(b -> b.getPos(), b -> b.getRes()));
    }

    @Override
    public void chooseLevel(int numLevel) {
        // TODO Auto-generated method stub
        switch(numLevel) {
            case 1:
                this.level = new FirstLevel(control.getFrameDimension());
                break;
            case 2:
                this.level = new SecondLevel(control.getFrameDimension());
                break;
            case 3:
                this.level = new ThirdLevel(control.getFrameDimension());
                break;
        }
    }

    @Override
    public Pair<Integer, Integer> getBrickDimension() {
        // TODO Auto-generated method stub
        return this.level.getRound().getSizeCalc().getBrickDim();
    }

    @Override
    public Pair<Integer, Integer> getBall() {
        // TODO Auto-generated method stub
        return this.level.getRound().getPosBall();
    }

    @Override
    public Pair<Integer, Integer> getPad() {
        // TODO Auto-generated method stub
        return this.level.getRound().getPosPad();
    }

    @Override
    public void changePos(Pair<Integer, Integer> pos) {
        // TODO Auto-generated method stub
        this.level.getRound().setPosPad(pos);
    }

    @Override
    public int getPadWight() {
        // TODO Auto-generated method stub
        return this.level.getRound().getPad().getWidth();
    }

    @Override
    public int getPadHeight() {
        // TODO Auto-generated method stub
        return this.level.getRound().getPad().getHight();
    }

    @Override
    public double getRBall() {
        // TODO Auto-generated method stub
        return this.level.getRound().getBall().getR();
    }

    @Override
    public int getRow(int x) {
        // TODO Auto-generated method stub
        return this.level.getRound().getSizeCalc().getRowCordinate(x);
    }

    @Override
    public boolean nextRound() {
        // TODO Auto-generated method stub
        if(this.level.checkRound() && this.level.getNumRoundPassed()<=2) {
            if(this.level.getNumRoundPassed() == 1) {
                this.level.setSecondRound();
            } else if(this.level.getNumRoundPassed() == 2) {
                this.level.setThirdRound();
            }
            return true;
        } else {
            return false;
        }
    }
    
}