package it.unibo.game.app.model;

import it.unibo.game.app.api.BrickType;

public class RoundEasy extends AbstractRound {

    private int startX;
    private int startY; 
    private int endX;
    private int endY;
    private int numSurpriseBrick = 0;

    public RoundEasy(int jump, int numB, int numS, int bH, int bW) {
        super(jump, numB, numS, bH, bW);
    }

    @Override
    public void setPosBrick() {
        for(int i = startX; i < endX; i = i + brickH) {
            for(int j = startY; j < endY; j = j + this.getJump() + brickW) {
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
