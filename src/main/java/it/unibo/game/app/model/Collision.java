package it.unibo.game.app.model;

public class Collision {
    private Level level;

    public Collision(Level lev){
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

    public boolean isCollideWithPad (Ball b, Pad p){
        var ballBox = new BoundingBoxImpl(b);
        var padBox = new BoundingBoxImpl(p);

        return ballBox.collideWith(padBox);
    }
}
