package it.unibo.game.app.model;
/*questa classe deve essere estesa da 
 * la classe che rappresenta i mattoni come ostacoli e 
 * mattoni di gioco
 * 
 */
import it.unibo.game.app.api.BrickType;
import java.awt.*;

public class Brick extends GameObj {
    /*cazzi della chiara */
    private BrickType type;
    private int brickWidth;
    private int brickHight;
    private Color color;
    
    public Brick (BrickType type, int width, int hight, Color color) {
        this.type = type;
        this.brickWidth = width;
        this.brickHight = hight;
        this.color = color;
    }

    public BrickType getType() {
        return this.type;
    }

    public int getBrickH () {
        return this.brickHight;
    }

    public int getBrickW () {
        return this.brickWidth;
    }

    public Color getBrickColor () {
        return this.color;
    }

}
