package it.unibo.game.app.model;

import java.util.*;
import java.util.stream.Collectors;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BrickType;

public class RoundDifficult extends AbstractRound {

    private int obstacles;
    private List<Obstacle> obs;
    private int startY; //dimensione del frame orizzontale

    public RoundDifficult(int jump, int numB, int numS, SizeCalculation size, int obstacles) {
        super(jump, numB, numS, size);
        this.obstacles=obstacles;
        super.brick = new ArrayList<>();
        obs =new ArrayList<>();
        //TODO Auto-generated constructor stub
        setPosBrick();
    }

    protected void setPosBrick() {
        // TODO Auto-generated method stub
        int num=0;
        int lines;
        for(int i=getSizeCalc().getStart().getX(); super.brick.size()<(this.obstacles+this.getNumBrick()+this.getNumSur());i=i+getSizeCalc().getBrickDim().getX()){
            num++;
            lines=0;
            for(int j=getSizeCalc().getWorldSize().getY()/2-(num)*(getSizeCalc().getBrickDim().getY()/2)-10; lines<num; j=j+getSizeCalc().getBrickDim().getY()){
                NormalBrick b = new NormalBrick(BrickType.NORMAL, getSizeCalc().getBrickDim().getY(), getSizeCalc().getBrickDim().getX(),1);
                b.setPos(new Pair<>(j,i));
                super.brick.add(b);
                lines++;
            }
        }
        //setPosObstacles();
    }

    private void setPosObstacles(){
        int num=0;
        Random r = new Random();
        while(num < this.obstacles) {
            int i = r.nextInt(super.brick.size());
            if(!super.brick.get(i).getType().equals(BrickType.OBSTACLE)){
                Obstacle o = new Obstacle(BrickType.OBSTACLE, getSizeCalc().getBrickDim().getY(), getSizeCalc().getBrickDim().getX());
                obs.add(o);
                super.brick.remove(i);
                num++;
            }
        }
    }
    
}