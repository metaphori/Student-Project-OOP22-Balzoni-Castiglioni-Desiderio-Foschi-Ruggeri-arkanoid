package it.unibo.game.app.model.round;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.model.DimensionImpl;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.brick.NormalBrick;

public class RoundEasy extends AbstractRound {

    private Double startX;
    private Double startY; 
    private Double endX;
    private Double endY;
    private int numSurpriseBrick = 0;

    public RoundEasy(int numB, int numS, SizeCalculation size) {
        super(numB, numS, size);
        this.startY = size.getStart().getY() + (this.getSizeCalc().getBrickDim().getY() / 2) - 5;
        this.startX = size.getStart().getX();
        this.endY = SizeCalculation.getWorldSize().getY() - (3 *(this.getSizeCalc().getBrickDim().getY() / 2));
        this.endX = size.getStop().getX();
        this.setPosBrick();
    }

    @Override
    public void setPosBrick() {
        for(Double i = startX; i < endX; i = i + this.getSizeCalc().getBrickDim().getX()) {
            for(Double j = startY; j < endY; j = j + this.getSizeCalc().getBrickDim().getY()) {
							NormalBrick brick = new NormalBrick(BrickType.NORMAL, new DimensionImpl(getSizeCalc().getBrickDim().getX(),getSizeCalc().getBrickDim().getY()),new Pair<>(j,i),1);
							brick.setPos(new Pair<>(j,i));
                super.addBrick(brick);
            }
        }
        while (this.numSurpriseBrick < this.getNumSur()) {
            if (this.setBrickSurprise()) {
                this.numSurpriseBrick++;
            }
        }
    }
    
}
