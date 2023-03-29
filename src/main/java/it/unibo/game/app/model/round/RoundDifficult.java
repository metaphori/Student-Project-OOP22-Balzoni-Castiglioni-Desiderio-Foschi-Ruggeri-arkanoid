package it.unibo.game.app.model.round;


import it.unibo.game.Pair;
import it.unibo.game.app.api.Brick;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.model.SizeCalculation;
import it.unibo.game.app.model.brick.NormalBrick;
import it.unibo.game.app.model.brick.Obstacle;

public class RoundDifficult extends AbstractRound {

    private int obstacles;

    public RoundDifficult(int jump, int numB, int numS, SizeCalculation size, int obstacles) {
        super(jump, numB, numS, size);
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
                Brick b = new NormalBrick(BrickType.NORMAL, getSizeCalc().getBrickDim().getY(), getSizeCalc().getBrickDim().getX(),1);
                b.setPos(new Pair<>(j,i));
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
        Brick newB = new Obstacle(BrickType.OBSTACLE, oldB.getBrickW(), oldB.getBrickH());
        newB.setPos(oldB.getPos());
        brick.set(val,newB);
    }
    
}