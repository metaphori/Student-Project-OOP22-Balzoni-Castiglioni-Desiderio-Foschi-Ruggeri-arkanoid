package it.unibo.game.app.model;

import it.unibo.game.app.api.Score;

public class ScoreImpl implements Score {
    private static final int ONE_COLLISION_POINTS = 1;
    private int points ;
    private int  score ;
    private int bonus = 1 ;

    public ScoreImpl(){
        resetPoints();
        this.score = 0;
    }

    public Integer getScore (){
        return this.score;
    }

    public void increaseScore(){
        this.score = (this.score + this.points)*this.bonus;
        this.points = this.points * 2;
    }
    
    public void resetPoints (){
        this.points = ONE_COLLISION_POINTS;
    }

    public void enableBonus(Boolean bool){
        this.bonus = (bool==true) ? 2 : 1;
    } 
}
