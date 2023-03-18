package it.unibo.game.app.model;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BrickType;

public class RoundEasy extends AbstractRound {

    private int startX;
    private int startY; 
    private int endX;
    private int endY;
    private int numSurpriseBrick = 0;

    public RoundEasy(int jump, int numB, int numS, SizeCalculation size) {
        super(jump, numB, numS, size);
        this.startY = size.getStart().getY() ;
        this.startX = size.getStart().getX();
        this.endY = size.getWorldSize().getY();
        this.endX = size.getStop().getX();
        this.setPosBrick();
    }

    @Override
    public void setPosBrick() {
        for(int i = startX; i < endX; i = i + this.getSizeCalc().getBrickDim().getX()) {
            for(int j = startY; j < endY; j = j + this.getSizeCalc().getBrickDim().getY()) {
                NormalBrick brick = new NormalBrick(BrickType.NORMAL, getSizeCalc().getBrickDim().getY(), getSizeCalc().getBrickDim().getX(),1);
                brick.setPos(new Pair<>(j,i));
                super.brick.add(brick);
            }
        }
        while (this.numSurpriseBrick < this.getNumSur()) {
            if (this.setBrickSurprise()) {
                this.numSurpriseBrick++;
            }
        }
    }
    
}
