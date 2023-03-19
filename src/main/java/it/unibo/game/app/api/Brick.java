package it.unibo.game.app.api;

public interface Brick{
    
    BrickType getType();

    void changeType(BrickType type);

    Double getBrickH ();

    Double getBrickW ();

    boolean isDestroyable();

    void hit();
}