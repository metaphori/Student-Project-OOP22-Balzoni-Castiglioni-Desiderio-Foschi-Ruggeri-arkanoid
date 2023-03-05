package it.unibo.game.app.api;

import it.unibo.game.Pair;

public interface GameObject {
    /*
     * game object deve implementare tutti i metodi degli oggetti
     * di gioco considerando che siano statici
     */
    void setPos(Pair<Integer, Integer> pos);

    Pair<Integer, Integer> getPos();

    BoundingBox getBoundingBox();
}
