package it.unibo.game.app.controller;

import java.util.Map;
import java.util.stream.Collectors;
import it.unibo.game.Pair;
import it.unibo.game.app.api.AppController;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.api.Model;
import it.unibo.game.app.model.ModelImpl;
import it.unibo.game.app.model.SizeCalculation;
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
    public Map<Pair<Double, Double>, Integer> getBrickList() {
        return this.model.getBrickList();

    } 

    @Override
    public void chooseLevel(int numLevel) {
        this.model.chooseLevel(numLevel);
    }
    
    @Override
    //non va bene deve prendere le informazioni da SizeCaplulator
    public Pair<Double, Double> getWorldDimension() {
       return SizeCalculation.getWorldSize();
    }
    
    @Override
    public Pair<Double, Double> getBrickDimension() {
        return this.model.getBrickDimension();
    }

    @Override
    public Pair<Double, Double> getBall() {
        // TODO Auto-generated method stub
        return this.model.getBall();
    }

    @Override
    public Pair<Double, Double> getPad() {
        // TODO Auto-generated method stub
        return this.model.getPad();
    }

    @Override
    public void changePos(Pair<Double, Double> pos){
        this.model.changePos(pos);
    }

    @Override
    public Double getPadWight(){
        return this.model.getPadWight();
    }

    @Override
    public Double getPadHeight(){
        return this.model.getPadHeight();
    }

    @Override
    public Double getRBall(){
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
    public Double getRow(Double x) {
        return this.model.getRow(x);
    }
}
