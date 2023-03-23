package it.unibo.game.app.model;

public class Score {
    private static final int ONE_COLLISION_POINTS = 5;
    private int points ;
    private int  score ;

    public Score(){
        resetPoints();
        this.score = 0;
    }

    public Integer getScore (){
        return this.score;
    }

    public void increaseScore(){
        score = score + points;
        points = points * 2;
    }
    
    public void resetPoints (){
        this.points = ONE_COLLISION_POINTS;
    }
}
