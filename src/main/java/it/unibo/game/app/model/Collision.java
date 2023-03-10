package it.unibo.game.app.model;

import it.unibo.game.app.api.BoundingBox.Corner;
//devi trovare il modo per comunicare dov'è avvenuta la collisione
public class Collision {
    private Level level;

    public Collision(Level lev){
        this.level = lev;
    
    }
    public boolean isCollideWithEdges(Ball b, int height, int width){
        var ballBox = new BoundingBoxImpl(b);
        if(ballBox.getBox().get(Corner.LEFT_DOWN).getY() == 0){
            return true;
        }else if(ballBox.getBox().get(Corner.LEFT_UP).getX()==0){
            return true;
        }else if(ballBox.getBox().get(Corner.RIGHT_DOWN).getY() == width-1){
            return true;
        }//else if(ballBox.getBox().get(Corner.RIGHT_DOWN).getX() == height-1){
           // return true;
        //}  non so se va gestito nel game over
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
