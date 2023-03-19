package it.unibo.game.app.api;
import java.util.*;

import it.unibo.game.Pair;

public interface Model{
    
    void setController(AppController c);

    Map<Pair<Integer,Integer>, Integer> getBrickList();

    void chooseLevel(int numLevel);

    Pair<Integer,Integer> getBrickDimension();

    Pair<Integer,Integer> getBall();

    Pair<Integer,Integer> getPad();

    void changePos(Pair<Integer,Integer> pos);

    boolean nextRound();

    int getPadWight();

    int getPadHeight();

    double getRBall();

    int getRow(int x);

    Pair<Integer,Integer> getWorldDim();

}