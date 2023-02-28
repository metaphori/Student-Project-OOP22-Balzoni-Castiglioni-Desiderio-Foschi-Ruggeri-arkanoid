package it.unibo.game.app.api;

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
}
