package it.unibo.game.app.model;
import it.unibo.game.app.api.BoundingBox;
/*questa classe deve essere estesa da 
 * la classe che rappresenta i mattoni come ostacoli e 
 * mattoni di gioco
 * 
 */
import it.unibo.game.app.api.BrickType;

public class Brick extends AbstractGameObj {
    /*cazzi della chiara */
    private BrickType type;

    public BrickType getType() {
        return type;
    }
    @Override
    public BoundingBox getBoundingBox() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoundingBox'");
    }
}
