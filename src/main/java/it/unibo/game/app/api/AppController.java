package it.unibo.game.app.api;

import java.util.*;

import it.unibo.game.Pair;
import it.unibo.game.app.model.*;

public interface AppController {
    
    /*chiama il metodo della view che mostra la  
     * situazione di gioco
    */

    void play();

    /*richiamato dalla view per mettere
    in pausa il gioco
     */
    void onPause();

    /*termina l'applicazione */
    void quit();

    void setView();

    Map<Pair<Integer, Integer>, Integer> getBrickList();

    void chooseLevel(int numLevel);

    Pair<Integer,Integer> getBrickDimension();
    public void nextRound();

    //aggiunti io
    Pair<Integer,Integer> getBall();
    Pair<Integer,Integer> getPad();
    void changePos(Pair<Integer,Integer> pos);
    int getPadWight();
    int getPadHeight();
    double getRBall();
    void rPaint();
}
