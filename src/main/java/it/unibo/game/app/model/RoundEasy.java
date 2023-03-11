package it.unibo.game.app.model;

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
        this.endY = size.getFrameSize().getY();
        this.endX = size.getStop().getX();
    }

    @Override
    public void setPosBrick() {
        for(int i = startX; i < endX; i = i + this.getSizeCalc().getBrickDim().getX()) {
            for(int j = startY; j < endY; j = j + this.getSizeCalc().getBrickDim().getY()) {
                this.getBrick().add(new NormalBrick(BrickType.NORMAL, j, i, 1));
            }
        }
        while (this.numSurpriseBrick <= this.getNumSur()) {
            if (this.setBrickSurprise()) {
                this.numSurpriseBrick++;
            }
        }
    }
    
}
