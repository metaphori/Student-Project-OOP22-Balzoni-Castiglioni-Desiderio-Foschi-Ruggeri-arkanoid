package it.unibo.game.app.model;

import java.awt.Color;
import java.util.Random;

import it.unibo.game.app.api.BrickType;

public class RoundMedium extends AbstractRound {

    private int numHard;
    private int startY; /*Dove far partire i blocchi. Bisogna farla a variabile perchè dipende dalla misura della finestra*/
    private int startX;
    private int numSur = 0;
    private int numH = 0;


    public RoundMedium(int jump, int numB, int numS, int numHard, int bH, int bW ) {
        super(jump, numB, numS, bH, bW);
        this.numHard = numHard;  
    }

    public boolean setBrickHard () {
        Random random = new Random();
        GameObjectImpl brickH;
        int idx = random.nextInt(this.getBrick().size());
        
        if (this.getBrick().get(idx).getType() == BrickType.NORMAL && this.getBrick().get(idx).getBrickColor() != Color.gray) {
            brickH = new NormalBrick(BrickType.NORMAL, this.getBrick().get(idx).getBrickW(), this.getBrick().get(idx).getBrickH() , Color.gray, 2);
            this.getBrick().remove(idx);
            this.getBrick().add(idx, (Brick)brickH);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void setPosBrick() { /*Posiziona i blocchi tutti di tipo normal poi verranno modificati dalla funzione setBrickHard e setBrickSurprise */
        for (int i = startY; i <= 300; i = i + step + brickH) {
            for (int j = startX; j <= 660; j = j + step + brickW) {

            }
        }

        /*Dopo che ho assegnato la pos a tutti i blocchi e il colore assegno i blocchi surprise in modo random*/
        while (numSur <= this.getNumSur()) {
            if (this.setBrickSurprise()) {
                numSur++;
            }
        }
        /*Dopo che ho assegnato la pos a tutti i blocchi e il colore assegno i blocchi grigi in modo random*/
        while (numH <= this.numHard) {
            if (this.setBrickHard()) {
                numH++;
            }
        }
    }
    

}
