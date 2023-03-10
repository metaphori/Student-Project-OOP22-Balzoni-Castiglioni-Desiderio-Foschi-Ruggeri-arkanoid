package it.unibo.game.app.model;


import java.util.Random;

import it.unibo.game.app.api.BrickType;

public class RoundMedium extends AbstractRound {

    private int countBrick = 0;
    private int numHard;
    private int numSur = 0;
    private int numH = 0;
    private int startY;
    private int startX;
    private int stopY;
    private int stopX; 


    public RoundMedium(int jump, int numB, int numS, int numHard, SizeCalculation sizeC ) {
        super(jump, numB, numS, sizeC);
        this.numHard = numHard;  
        this.startY = sizeC.getStart().getY() + (this.getSizeCalc().getBrickDim().getY() / 2); /*Modificata l'inizio per lasciare spazio dal muro ai blocchi */
        this.startX = sizeC.getStart().getX();
        this.stopY = sizeC.getFrameSize().getY() - (3 * (this.getSizeCalc().getBrickDim().getY() / 2)); /*Modificata la fine per lasciare lo spazio tra il muro e i blocchi */
        this.stopX = sizeC.getStop().getX();
    }

    public boolean setBrickHard () {
        Random random = new Random();
        NormalBrick brickH;
        int idx = random.nextInt(this.getBrick().size());
        
        if (this.getBrick().get(idx).getType() == BrickType.NORMAL && this.getBrick().get(idx).getRes() == 1 ) { 
            brickH = new NormalBrick(BrickType.NORMAL, this.getBrick().get(idx).getBrickW(), this.getBrick().get(idx).getBrickH() , 2);
            this.getBrick().remove(idx);
            this.getBrick().add(idx, brickH);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void setPosBrick() { /*Posiziona i blocchi tutti di tipo normal poi verranno modificati dalla funzione setBrickHard e setBrickSurprise */
        for (int i = this.startX; i < this.stopX; i = i + this.getSizeCalc().getBrickDim().getX()) {
            for (int j = this.startY; j <= this.stopY; j = j + this.getSizeCalc().getBrickDim().getY()) {
                if (countBrick != this.getJump()) {
                    this.getBrick().add(new NormalBrick(BrickType.NORMAL, this.getSizeCalc().getBrickDim().getY(), this.getSizeCalc().getBrickDim().getX(), 1));
                    countBrick++;
                } else {
                    countBrick = 0;
                }
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
