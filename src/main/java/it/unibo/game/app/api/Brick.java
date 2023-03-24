package it.unibo.game.app.api;
import java.util.*;

public interface Brick extends GameObject{
    
    BrickType getType();

    void changeType(BrickType type);

    Double getBrickH ();

    Double getBrickW ();

    Optional<Integer> getRes();

    boolean isDestroyed();

    void hit();

    void increaseRes(int res);
}