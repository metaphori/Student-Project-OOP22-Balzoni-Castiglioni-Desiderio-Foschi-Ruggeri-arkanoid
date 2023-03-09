package it.unibo.game.app.model;

public class BallPhysics {
    
    private Direction d = new Direction();

    public void changeDirectionVertical(){
        if(this.d.isDirectionUp()){
            this.d.setDirectionDown();
        }else{
            this.d.setDirectionUp();
        }
    }

    public void changeDirectionHorizontal(){
        if(this.d.isDirectionLeft()){
            this.d.setDirectionRight();
        }else{
            this.d.setDirectionLeft();
        }
    }
}
