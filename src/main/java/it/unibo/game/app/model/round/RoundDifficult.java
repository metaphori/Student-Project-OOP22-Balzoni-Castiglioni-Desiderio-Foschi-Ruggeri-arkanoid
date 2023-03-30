package it.unibo.game.app.model.round;


import it.unibo.game.Pair;
import it.unibo.game.app.api.Brick;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.model.DimensionImpl;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.brick.NormalBrick;
import it.unibo.game.app.model.brick.Obstacle;

public class RoundDifficult extends AbstractRound {

    private int obstacles;

    public RoundDifficult(int numB, int numS, SizeCalculation size, int obstacles) {
        super(numB, numS, size);
        this.obstacles=obstacles;
        setPosBrick();
    }

    protected void setPosBrick() {
        // TODO Auto-generated method stub
        int num=0;
        int lines;
        for(Double i=getSizeCalc().getStart().getX(); super.brick.size()<(this.obstacles+this.getNumBrick()+this.getNumSur());i=i+getSizeCalc().getBrickDim().getX()){
            num++;
            lines=0;
            for(double j=SizeCalculation.getWorldSize().getY()/2-(num)*(getSizeCalc().getBrickDim().getY()/2)-10; lines<num; j=j+getSizeCalc().getBrickDim().getY()){
                Brick b = new NormalBrick(BrickType.NORMAL, new DimensionImpl(getSizeCalc().getBrickDim().getX(),getSizeCalc().getBrickDim().getY()),new Pair<>(j,i),1);
                super.brick.add(b);
                lines++;
            }
        }
        setPosObstacles();
        setSurprise();
    }

    private void setSurprise(){
        int num=0;
        while(num<getNumSur()){
            if(setBrickSurprise()) {
                ++num;
            }
        }
    }

    private void setPosObstacles(){
        int height = (int)Math.sqrt((double)(2*(this.obstacles+this.getNumBrick()+this.getNumSur())));
        int first=brick.size()-height;
        int last=brick.size()-1;
        int num=0;
        while(num<(obstacles/2)){
            replace(first++);
            replace(last--);
            ++num;
        }
    }

    private void replace(int val){
        Brick oldB = brick.get(val);
        Brick newB = new Obstacle(BrickType.OBSTACLE, new DimensionImpl(oldB.getBrickH(),oldB.getBrickW()),oldB.getPos());
        brick.set(val,newB);
    }
    
}