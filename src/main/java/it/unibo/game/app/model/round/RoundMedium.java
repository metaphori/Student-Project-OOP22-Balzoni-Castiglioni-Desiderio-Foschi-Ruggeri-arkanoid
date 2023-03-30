package it.unibo.game.app.model.round;


import java.util.Random;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.model.DimensionImpl;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.brick.NormalBrick;

public class RoundMedium extends AbstractRound {

    private int countBrick = 0;
    private int numHard;
    private int numSur = 0;
    private int numH = 0;
    private Double startY;
    private Double startX;
    private Double stopY;
    private Double stopX; 
		private int jump;


    public RoundMedium(int jump, int numB, int numS, int numHard, SizeCalculation sizeC ) {
        super(numB, numS, sizeC);
				this.jump = jump;
        this.numHard = numHard;  
        this.startY = sizeC.getStart().getY() + (this.getSizeCalc().getBrickDim().getY() / 2) - 5; /*Modificata l'inizio per lasciare spazio dal muro ai blocchi */
        this.startX = sizeC.getStart().getX();
        this.stopY = SizeCalculation.getWorldSize().getY() - (3 * (this.getSizeCalc().getBrickDim().getY() / 2)); /*Modificata la fine per lasciare lo spazio tra il muro e i blocchi */
        this.stopX = sizeC.getStop().getX();
        this.setPosBrick();
    }

    private boolean setBrickHard () {
        Random random = new Random();
        int idx = random.nextInt(this.getBrick().size());
        
        if (this.getBrick().get(idx).getType() == BrickType.NORMAL && this.getBrick().get(idx).getRes().get() == 1 ) { 
            this.getBrick().get(idx).increaseRes(this.getBrick().get(idx).getRes().get());
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void setPosBrick() { /*Posiziona i blocchi tutti di tipo normal poi verranno modificati dalla funzione setBrickHard e setBrickSurprise */
        for (Double i = this.startX; i < this.stopX; i = i + this.getSizeCalc().getBrickDim().getX()) {
            countBrick = 0;
            for (Double j = this.startY; j <= this.stopY; j = j + this.getSizeCalc().getBrickDim().getY()) {
                if (countBrick != this.jump) {
                    NormalBrick b = new NormalBrick(BrickType.NORMAL, new DimensionImpl(this.getSizeCalc().getBrickDim().getX(),this.getSizeCalc().getBrickDim().getY()), new Pair<>(j, i) , 1);
                    b.setPos(new Pair<Double,Double>(j, i));
                    super.brick.add(b);
                    countBrick++;
                } else {
                    countBrick = 0;
                }
            }
        }

        /*Dopo che ho assegnato la pos a tutti i blocchi e il colore assegno i blocchi surprise in modo random*/
        while (numSur < this.getNumSur()) {
            if (this.setBrickSurprise()) {
                numSur++;
            }
        }
        /*Dopo che ho assegnato la pos a tutti i blocchi e il colore assegno i blocchi grigi in modo random*/
        while (numH < this.numHard) {
            if (this.setBrickHard()) {
                numH++;
            }
        }
    }
    

}
