package it.unibo.game.app.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.unibo.game.Pair;
import it.unibo.game.app.api.AppController;
import it.unibo.game.app.model.Level; /*Forse */
import it.unibo.game.app.model.NormalBrick;

public class ControllerImpl implements AppController{

    private Level l;
    public ControllerImpl (Level level) {
        this.l = level;
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

    protected Map<Pair<Integer,Integer>, Integer> getBrickList () {
        return l.getRound().getBrick().stream().collect(
                            Collectors.toMap(b -> b.getPos(), b -> b.getRes()));

    }
    
}
