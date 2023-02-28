package it.unibo.game.app.model;

import it.unibo.game.Pair;
import it.unibo.game.app.api.GameObject;
/*questa classe deve essere estesa da 
 * la classe che rappresenta i mattoni come ostacoli e 
 * mattoni di gioco
 * 
 */
public abstract class AbstractBrick implements GameObject {
    private Pair<Double, Double> pos;

    public Pair<Double, Double> getPos() {
        return pos;
    }

    public void setPos(Pair<Double, Double> pos) {
        this.pos = pos;
    }
    /*define if the brick is obstacle */
    public abstract boolean isObstacle();
    /*implements only for brick */
    public abstract boolean isDestroyed();
    /*implements only for brick */
    public abstract void hit();
}
