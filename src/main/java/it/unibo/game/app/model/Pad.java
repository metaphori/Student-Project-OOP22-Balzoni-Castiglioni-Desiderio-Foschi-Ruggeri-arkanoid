package it.unibo.game.app.model;

import it.unibo.game.app.api.MovingObject;

public class Pad extends GameObjectImpl implements MovingObject {

    private int width;
    private int hight;
    /*le dimensioni sono modificabili per rendere resizable la dinestra
     * 
     */
    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Pad(int width, int hight) {
        this.width = width;
        this.hight = hight;
    }

}
