package it.unibo.game.app.api;

import java.util.List;

import it.unibo.game.Pair;
import it.unibo.game.app.model.*;

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