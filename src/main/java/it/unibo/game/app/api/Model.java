package it.unibo.game.app.api;
import java.util.*;

import it.unibo.game.Pair;

public interface Model{
    
    void setController(AppController c);

    Map<Pair<Double,Double>, Optional<Integer>> getBrickList();

    void chooseLevel(int numLevel);

    Pair<Double,Double> getBrickDimension();

    Pair<Double,Double> getBall();

    Pair<Double,Double> getPad();
    
    void setPadPos(Pair<Double, Double> pos);

    boolean nextRound();

    Double getPadWight();

    Double getPadHeight();

    Double getRBall();

    Double getRow(Double x);

    Pair<Double,Double> getWorldDim();

    void update(long dt);

    List<Pair<String,Integer>> getBestFive();

    boolean isPresent(String name);

    boolean checkRound();

    boolean updateLife();

    boolean isLevelFinished();

    void restoreInitialPosition();

}