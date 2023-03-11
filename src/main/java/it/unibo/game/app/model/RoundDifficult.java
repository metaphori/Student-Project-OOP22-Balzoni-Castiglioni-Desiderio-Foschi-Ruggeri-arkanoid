package it.unibo.game.app.model;

import java.util.*;
import java.util.stream.Collectors;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BrickType;

public class RoundDifficult extends AbstractRound {

    private int obstacles;
    private List<Obstacle> obs;
    private List<NormalBrick> blocks;
    private int startY; //dimensione del frame orizzontale

    public RoundDifficult(int jump, int numB, int numS, int bH, int bW, int obstacles) {
        super(jump, numB, numS, bH, bW);
        this.obstacles=obstacles;
        //TODO Auto-generated constructor stub
    }

    @Override
    public void setPosBrick() {
        // TODO Auto-generated method stub
        int num=0;
        int lines;
        for(int i=20; blocks.size()<(this.obstacles+this.getNumBrick()+this.getNumSur());i=i+getJump()+brickH){
            num++;
            lines=0;
            for(int j=startY/2-(num-1)*(brickW/2); lines<num; j=j+getJump()+brickW){
                NormalBrick brick = new NormalBrick(BrickType.NORMAL, brickW, brickH,1);
                blocks.add(brick);
                lines++;
            }
        }
        setPosObstacles();
    }

    private void setPosObstacles(){
        int num=0;
        Random r = new Random();
        while(num < this.obstacles) {
            int i = r.nextInt(blocks.size());
            if(!blocks.get(i).getType().equals(BrickType.OBSTACLE)){
                Obstacle o = new Obstacle(BrickType.OBSTACLE, brickW, brickH);
                obs.add(o);
                blocks.remove(i);
                num++;
            }
        }
    }
    
}