package it.unibo.game.app.api;

import java.util.Map;

import it.unibo.game.Pair;

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

    void addView();

    Map<Pair<Integer, Integer>, Integer> getBrickList();

    void chooseLevel(int numLevel);

    Pair<Integer,Integer> getBrickDimension();
}
