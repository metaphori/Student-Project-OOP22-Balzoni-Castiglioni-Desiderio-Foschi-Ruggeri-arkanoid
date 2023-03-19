package it.unibo.game.app.model.pad;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Physics;
import it.unibo.game.app.model.GameObjectImpl;
import it.unibo.game.app.api.MovingObject;

public class Pad extends GameObjectImpl implements MovingObject {

    private double width;
    private double hight;
    /*le dimensioni sono modificabili per rendere resizable la dinestra
     * 
     */

    //fatto io
    public Pad(Pair<Double,Double> fSize){
        super.setPos(new Pair<>(fSize.getY()/2-width/2,fSize.getX()-100));
        //ho impostato due valori di w e h di prova
        this.width=fSize.getY()/4;
        this.hight=fSize.getX()/60;
    }


    public Double getHight() {
        return hight;
    }

    public void setHight(Double hight) {
        this.hight = hight;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Pad(Double width, Double hight) {
        this.width = width;
        this.hight = hight;
    }


    @Override
    public Physics getPhysics() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPhysics'");
    }

}
