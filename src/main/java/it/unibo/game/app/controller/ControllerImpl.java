package it.unibo.game.app.controller;

import java.util.Map;
import java.util.stream.Collectors;
import it.unibo.game.Pair;
import it.unibo.game.app.api.AppController;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.model.FirstLevel;
import it.unibo.game.app.model.AbstractLevel; /*Forse */
import it.unibo.game.app.model.SecondLevel;
import it.unibo.game.app.model.ThirdLevel;
import it.unibo.game.app.view.jswing.api.UIController;
import it.unibo.game.app.view.jswing.impleentation.UIControllerImpl;

public class ControllerImpl implements AppController{
    private UIController uiContr;
    private Level l;

    // public ControllerImpl (UIController uiC) {
    //     this.uiContr = uiC;
    // }
    public ControllerImpl () {
    }
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

    public Map<Pair<Integer,Integer>, Integer> getBrickList() {
        return l.getRound().getBrick().stream().collect(
                            Collectors.toMap(b -> b.getPos(), b -> b.getRes()));

    } 

    public void chooseLevel(int numLevel) {
        switch(numLevel) {
            case 1:
                this.l = new FirstLevel(uiContr.getDimension());
                break;
            case 2:
                this.l = new SecondLevel(uiContr.getDimension(), 0);
                break;
            case 3:
                this.l = new ThirdLevel(uiContr.getDimension());
                break;
        }
    }
    
    public Pair<Integer,Integer> getFrameDimension() {
       return this.uiContr.getDimension();
    }
    
    public Pair<Integer,Integer> getBrickDimension() {
        return l.getRound().getSizeCalc().getBrickDim();
    }
    @Override
    public Pair<Integer,Integer> getBall() {
        // TODO Auto-generated method stub
        return l.getRound().getPosBall();
    }
    @Override
    public Pair<Integer,Integer> getPad() {
        // TODO Auto-generated method stub
        return l.getRound().getPosPad();
    }

    //aggiunto
    public void changePos(Pair<Integer,Integer> pos){
        l.getRound().setPosPad(pos);
    }

    public int getPadWight(){
        return l.getRound().getPad().getWidth();
    }

    public int getPadHeight(){
        return l.getRound().getPad().getHight();
    }

    public double getRBall(){
        return l.getRound().getBall().getR();
    }

    public void rPaint() {
        this.uiContr.rPaint();
    }
}
