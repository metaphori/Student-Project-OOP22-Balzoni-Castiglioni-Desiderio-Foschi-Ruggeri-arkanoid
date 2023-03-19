package it.unibo.game.app.model.brick;
/*questa classe deve essere estesa da 
 * la classe che rappresenta i mattoni come ostacoli e 
 * mattoni di gioco
 * 
 */
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.model.GameObjectImpl;

public abstract class AbstractBrick extends GameObjectImpl {
    
    private BrickType type;
    private Double brickWidth;
    private Double brickHight;
    
    public AbstractBrick (BrickType type, Double double1, Double double2) {
        this.type = type;
        this.brickWidth = double1;
        this.brickHight = double2;
    }

    public BrickType getType() {
        return this.type;
    }

    public void changeType(BrickType type) {
        this.type = type;
    }

    public Double getBrickH () {
        return this.brickHight;
    }

    public Double getBrickW () {
        return this.brickWidth;
    }

    public abstract boolean isDestroyable();

    public abstract void hit();

}
