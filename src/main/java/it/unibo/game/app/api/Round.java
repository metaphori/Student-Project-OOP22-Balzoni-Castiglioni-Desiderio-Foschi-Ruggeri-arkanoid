package it.unibo.game.app.api;

import java.util.List;

import it.unibo.game.Pair;
import it.unibo.game.app.model.*;
import it.unibo.game.app.model.ball.Ball;
import it.unibo.game.app.model.brick.NormalBrick;
import it.unibo.game.app.model.pad.Pad;

public interface Round{

    int getJump ();

    SizeCalculation getSizeCalc();

    int getNumBrick ();

    int getNumSur ();

    List<NormalBrick> getBrick ();

    void setPosBall (Pair<Integer,Integer> pos);

    void setPosPad (Pair<Integer,Integer> pos);

    Pair<Integer,Integer> getPosBall();

    Pair<Integer,Integer> getPosPad();

    Pad getPad();

    Ball getBall();

}