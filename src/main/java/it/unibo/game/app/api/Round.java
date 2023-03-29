package it.unibo.game.app.api;

import java.util.List;

import it.unibo.game.Pair;
import it.unibo.game.app.model.*;
import it.unibo.game.app.model.ball.Ball;
import it.unibo.game.app.model.pad.Pad;

public interface Round{

    int getJump ();

    SizeCalculation getSizeCalc();

    int getNumBrick ();

    int getNumSur ();

    List<Brick> getBrick ();

    void setPosBall (Pair<Double,Double> pos);

    void setPosPad (Pair<Double,Double> pos);

    List<MovingObject> getSurprise();

    Pair<Double,Double> getPosBall();

    Pair<Double,Double> getPosPad();

    MovingObject getPad();

    MovingObject getBall();

    void remove(int index);

    Pair<Double, Double> getBallInitialPosition();

    List<Ball> getExtraBalls ();

    void addBalls(List<Ball> b);

}