package it.unibo.game.app.api;
import java.util.*;

import it.unibo.game.Pair;
import it.unibo.game.app.model.ball.Ball;

public interface Model{
    
    void setController(AppController c);

    Map<Pair<Double,Double>, Optional<Integer>> getBrickList();

    void chooseLevel(int numLevel);

    Pair<Double,Double> getBrickDimension();

    Pair<Double,Double> getBall();

    Pair<Double,Double> getPad();
    
    void setPadPos(Pair<Double, Double> pos);

    void nextRound();

    Double getPadWight();

    Double getPadHeight();

    Double getRBall();

    void updatePoints(String name, String passWord);

    Double getRow(Double x);

    Pair<Double,Double> getWorldDim();

    void update(long dt);

    int getScore();

    List<MovingObject> getSurprise();

    List<Pair<String,Integer>> getBestFive();

    boolean checkRound();

    boolean updateLife();

    //boolean isLevelFinished();

    int getLife();

    void restoreInitialPosition();

    //List<Ball> getExtraBalls();

}