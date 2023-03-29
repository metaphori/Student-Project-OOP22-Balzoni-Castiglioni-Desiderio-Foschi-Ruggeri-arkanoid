package it.unibo.game.app.model.dynamic;

import it.unibo.game.app.api.Speed;

public class SpeedImpl implements Speed {
    
    private double x;
    private double y;

    public SpeedImpl(final double x, final double y){
        this.x=x;
        this.y=y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public Speed sum(Speed v){
        return new SpeedImpl(this.x+v.getX(), this.y+v.getY());
    }

    public Speed mul(double num){
        return new SpeedImpl(this.x*num, this.y*num);
    }

		public String toString(){
			return "["+this.x+","+this.y+"]";
		}

}