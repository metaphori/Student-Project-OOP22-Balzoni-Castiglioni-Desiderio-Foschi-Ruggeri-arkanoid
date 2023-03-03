package it.unibo.game.app.model;

public class RoundMedium extends AbstractRound {

    private int numHard;

    public RoundMedium(int jump, int numB, int numS, int numH ) {
        super(jump, numB, numS);
        this.numHard = numH;  
    }

    @Override
    public void setPosBrick() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPosBrick'");
    }
    
}
