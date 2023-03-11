package it.unibo.game.app.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.unibo.game.Pair;
import it.unibo.game.app.api.AppController;
import it.unibo.game.app.api.UIController;
import it.unibo.game.app.model.FirstLevel;
import it.unibo.game.app.model.Level; /*Forse */
import it.unibo.game.app.model.NormalBrick;
import it.unibo.game.app.model.SecondLevel;

public class ControllerImpl implements AppController{
    private UIController uiContr;
    private Level l;

    public ControllerImpl (UIController uiC) {
        this.uiContr = uiC;
    }
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quit'");
    }

    @Override
    public void addView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addView'");
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
                this.l = new SecondLevel(uiContr.getDimension());
                break;
            case 3:
                this.l = new ThirdLevel();
                break;
        }
    }
    public Pair<Integer,Integer> getFrameDimension() {
       return this.uiContr.getDimension();
    }
    
    public Pair<Integer,Integer> getBrickDimension() {
        return l.getRound().getSizeCalc().getBrickDim();
    }
}
