package it.unibo.game.app.api;

public interface AppView {
    
    /*permette di conoscere il controller 
     * per chiamare i metodi necessari
     */
    void setController(AppController observer);

    /*avvia il motore di interfaccia grafica scelto */
    void start();

    
}
