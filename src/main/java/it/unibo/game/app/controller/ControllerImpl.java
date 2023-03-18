package it.unibo.game.app.controller;

import java.util.Map;
import java.util.stream.Collectors;
import it.unibo.game.Pair;
import it.unibo.game.app.api.AppController;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.api.Model;
import it.unibo.game.app.model.FirstLevel;
import it.unibo.game.app.model.ModelImpl;
import it.unibo.game.app.model.AbstractLevel; /*Forse */
import it.unibo.game.app.model.SecondLevel;
import it.unibo.game.app.model.ThirdLevel;
import it.unibo.game.app.view.jswing.api.UIController;
import it.unibo.game.app.view.jswing.impleentation.UIControllerImpl;

public class ControllerImpl implements AppController{

    private UIController uiContr;
    private Model model;

    @Override
    public void play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onPause'");
    }

    @Override
    public void quit() {
        System.exit(0);
    }

    @Override
    public void setView() {
        this.uiContr = new UIControllerImpl();
        uiContr.setController(this);
    }

    @Override
    public void setModel(){
        this.model=new ModelImpl();
        this.model.setController(this);
    }

    @Override
    public Map<Pair<Integer,Integer>, Integer> getBrickList() {
        return this.model.getBrickList();

    } 

    @Override
    public void chooseLevel(int numLevel) {
        this.model.chooseLevel(numLevel);
    }
    
    @Override
    public Pair<Integer,Integer> getFrameDimension() {
       return this.uiContr.getDimension();
    }
    
    @Override
    public Pair<Integer,Integer> getBrickDimension() {
        return this.model.getBrickDimension();
    }

    @Override
    public Pair<Integer,Integer> getBall() {
        // TODO Auto-generated method stub
        return this.model.getBall();
    }

    @Override
    public Pair<Integer,Integer> getPad() {
        // TODO Auto-generated method stub
        return this.model.getPad();
    }

    @Override
    public void changePos(Pair<Integer,Integer> pos){
        this.model.changePos(pos);
    }

    @Override
    public int getPadWight(){
        return this.model.getPadWight();
    }

    @Override
    public int getPadHeight(){
        return this.model.getPadHeight();
    }

    @Override
    public double getRBall(){
        return this.model.getRBall();
    }

    @Override
    public void rPaint() {
        this.uiContr.rPaint();
    }

    @Override
    public void nextRound() {
        if(!this.model.nextRound()) {
            uiContr.victory();
        }
    }

    @Override
    public int getRow(int x) {
        return this.model.getRow(x);
    }
}
