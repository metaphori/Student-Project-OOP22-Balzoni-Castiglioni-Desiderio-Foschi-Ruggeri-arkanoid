package it.unibo.game.app.api;

public interface Score {
    Integer getScore ();
    void increaseScore();
    void resetPoints ();
    void enableBonus(Boolean bool);
}
