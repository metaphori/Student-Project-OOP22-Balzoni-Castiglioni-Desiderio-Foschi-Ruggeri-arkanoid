package it.unibo.game.app.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import it.unibo.game.Pair;
import it.unibo.game.app.api.AppController;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.api.Model;
import it.unibo.game.app.model.ModelImpl;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.ball.Ball;
import it.unibo.game.app.view.jswing.api.UIController;
import it.unibo.game.app.view.jswing.impleentation.UIControllerImpl;

public class ControllerImpl implements AppController{

    private UIController uiContr;
    private Model model;
    private GameEngine gameEngine;

    @Override
    public void play() {
        this.gameEngine.resume();
    }

    @Override
    public void onPause() {
        this.gameEngine.pause();
    }

    @Override
    public void quit() {
        System.exit(0);
    }

    @Override
    public void setView() {
        this.uiContr = new UIControllerImpl();
        this.uiContr.set(this);
        //uiContr.setController(this);
    }

    @Override
    public void setModel(){
        this.model=new ModelImpl();
        this.model.setController(this);
    }

    @Override
    public void chooseLevel(int numLevel) {
        this.model.chooseLevel(numLevel);
    }
    
    @Override
    public Pair<Double, Double> getWorldDimension() {
       return SizeCalculation.getWorldSize();
    }
    /*-------------------------------------------------------------------- */
    /*metodi da utili alla gui */
    @Override
    public Map<Pair<Double, Double>, Optional<Integer>> getBrickList() {
        return this.model.getBrickList();
    } 
    @Override
    public Pair<Double, Double> getBrickDimension() {
        return this.model.getBrickDimension();
    }

    @Override
    public Pair<Double, Double> getBall() {
        return this.model.getBall();
    }

    @Override
    public Pair<Double, Double> getPad() {
        return this.model.getPad();
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

    /*-------------------------------------------- */
    @Override
    public void rPaint() {
        this.uiContr.rPaint();
    }

    @Override
    public void nextRound() {
        if(this.model.nextRound() && this.model.isLevelFinished()) {
            uiContr.victory();
        }
    }

    @Override
    public void changePadPos(Pair<Double, Double> pos){
        this.model.setPadPos(pos);
    }

    @Override
    public Double getRow(Double x) {
        return this.model.getRow(x);
    }

    public List<Ball> getSurprise(){
        return this.model.getSurprise();
    }

    @Override
    public void setGameEngine() {
        this.gameEngine = new GameEngine(this);
    }

    public void update(long dt) {
        this.model.update(dt);
    }

    public boolean isPresent(String name){
        return this.model.isPresent(name);
    }

    public List<Pair<String,Integer>> getBestFive(){
        return this.model.getBestFive();
    }

    @Override
    public void setGameOver() {
        this.uiContr.gameOver();
    }

    @Override
    public boolean updateLife() {
       return this.model.updateLife();
    }

    @Override
    public void restoreBall() {
        this.model.restoreInitialPosition();
    }

    
}
