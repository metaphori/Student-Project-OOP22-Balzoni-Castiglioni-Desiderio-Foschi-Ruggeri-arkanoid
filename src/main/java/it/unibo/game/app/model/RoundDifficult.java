package it.unibo.game.app.model;

import java.util.*;
import java.util.stream.Collectors;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BrickType;

public class RoundDifficult extends AbstractRound {

    private int obstacles;
    private List<Obstacle> list;
    private List<NormalBrick> blocks;

    public RoundDifficult(int jump, int numB, int numS, int bH, int bW, int obstacles) {
        super(jump, numB, numS, bH, bW);
        this.obstacles=obstacles;
        //TODO Auto-generated constructor stub
    }

    @Override
    public void setPosBrick() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPosBrick'");
    }

    
    
}