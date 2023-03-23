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

    void setModel();

    Map<Pair<Double, Double>, Optional<Integer>> getBrickList();

    void chooseLevel(int numLevel);

    Pair<Double, Double> getBrickDimension();

    Pair<Double, Double> getWorldDimension();

    void nextRound();

    Pair<Double, Double> getBall();

    Pair<Double, Double> getPad();
    void changePadPos(Pair<Double, Double> newPos);
    
    Double getPadWight();
    
    Double getPadHeight();

    Double getRBall();

    void rPaint();
    
    Double getRow(Double x);
    
    List<Pair<String,Integer>> getBestFive();

    boolean isPresent(String name);

    void setGameEngine();

    void update(long dt);

    void setGameOver();

    boolean updateLife();

    void restoreBall();

    void mvPadR();

    void mvPadL();

}
