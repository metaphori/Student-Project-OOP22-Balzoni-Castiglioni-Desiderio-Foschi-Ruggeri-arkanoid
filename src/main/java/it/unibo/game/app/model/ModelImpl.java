package it.unibo.game.app.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import it.unibo.game.Pair;
import it.unibo.game.app.api.AppController;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.model.leaderb.LeaderBoard;
import it.unibo.game.app.model.leaderb.LeaderBoardImpl;
import it.unibo.game.app.model.levels.*;
import it.unibo.game.app.api.Model;

public class ModelImpl implements Model{

    private AppController control;
    private Level level;
    private LeaderBoard board = new LeaderBoardImpl();

    @Override
    public void setController(AppController c) {
        // TODO Auto-generated method stub
        this.control=c;
        this.level=new FirstLevel(this.control.getWorldDimension());
    }

    @Override
    public Map<Pair<Double,Double>, Optional<Integer>> getBrickList() {
        // TODO Auto-generated method stub
        // return this.level.getRound().getBrick().stream().collect(
        //                     Collectors.toMap(b -> b.getPos(), b -> b.getRes()));
        return this.level.getRound().getBrick().stream().collect(Collectors.toMap(b->b.getPos(), b->b.getRes()));
    }

    @Override
    public void chooseLevel(int numLevel) {
        // TODO Auto-generated method stub
        switch(numLevel) {
            case 1:
                this.level = new FirstLevel(control.getWorldDimension());
                break;
            case 2:
                this.level = new SecondLevel(control.getWorldDimension());
                break;
            case 3:
                this.level = new ThirdLevel(control.getWorldDimension());
                break;
        }
    }

    @Override
    public Pair<Double,Double> getBrickDimension() {
        // TODO Auto-generated method stub
        return this.level.getRound().getSizeCalc().getBrickDim();
    }

    @Override
    public Pair<Double,Double> getBall() {
        // TODO Auto-generated method stub
        return this.level.getRound().getPosBall();
    }

    @Override
    public Pair<Double, Double> getPad() {
        // TODO Auto-generated method stub
        return this.level.getRound().getPosPad();
    }

    @Override
    public void changePos(Pair<Double,Double> pos) {
        // TODO Auto-generated method stub
        this.level.getRound().setPosPad(pos);
    }

    @Override
    public Double getPadWight() {
        // TODO Auto-generated method stub
        return this.level.getRound().getPad().getWidth();
    }

    @Override
    public Double getPadHeight() {
        // TODO Auto-generated method stub
        return this.level.getRound().getPad().getHight();
    }

    @Override
    public Double getRBall() {
        // TODO Auto-generated method stub
        return this.level.getRound().getBall().getR();
    }

    @Override
    public Double getRow(Double x) {
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

    @Override
    public Pair<Double, Double> getWorldDim() {
        return SizeCalculation.getWorldSize();
    }

    public boolean isPresent(String name){
        return board.isPresent(name);
    }

    public List<Pair<String,Integer>> getBestFive(){
        return board.getBestFive();
    }
    
}