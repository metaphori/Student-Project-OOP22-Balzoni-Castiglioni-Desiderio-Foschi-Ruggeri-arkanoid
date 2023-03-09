package it.unibo.game.app.model;

import it.unibo.game.app.api.BoundingBox;

public class Collision {
    private Level level;

    public Collision(Level lev, Ball b ){
        this.level = lev;
    
    }
    public boolean isCollideWithBorder(Ball b){
        //da finire
        return false;
    }

    public boolean isCollideWithBrick(Ball b){
        var ballBox = new BoundingBoxImpl(b);
        for (NormalBrick obj : level.getRound().getBrick()) {
            var box = new BoundingBoxImpl(obj);
            if(ballBox.collideWith(box)){
                return true;
            }
        }
        return false;
    }
}
