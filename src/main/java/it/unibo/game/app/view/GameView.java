package it.unibo.game.app.view;

import java.util.Map;
import java.util.Random;

import javax.swing.*;
import it.unibo.game.Pair;
import it.unibo.game.app.api.UIController;

import java.awt.*;
import java.awt.event.*;


public class GameView extends JPanel implements KeyListener,ActionListener{

    private UIController observer;
    private Timer timer;
    private static final int delay=8;
    private boolean play=true;

    public GameView(UIController control){
        setFocusable(true);
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        this.observer=control;
        this.timer = new Timer(delay,this);
        timer.start();
    }

    public void paint(Graphics g){

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, observer.getDimension().getX(), observer.getDimension().getY());

        
       observer.getList().entrySet().stream().forEach(x->{
            g.setColor(x.getValue()==2 ? Color.GRAY : Color.RED);
            g.fillRect(x.getKey().getX(),x.getKey().getY(), observer.getDimensionBrick().getY(), observer.getDimensionBrick().getX());
            g.setColor(Color.BLACK);
            g.drawRect(x.getKey().getX(),x.getKey().getY(), observer.getDimensionBrick().getY(), observer.getDimensionBrick().getX());
        }); 
        
        
        g.setColor(Color.GREEN);
        g.fillOval(observer.getBall().getX(), observer.getBall().getY(), (int)observer.getRBall(),(int)observer.getRBall());

        g.setColor(Color.YELLOW);
        g.fillRect(observer.getPad().getX(), observer.getPad().getY(), observer.getPadWight(), observer.getPadHeight());
        g.dispose();
    } 

   /* public void paint(Graphics g) {
        Pair<Integer,Integer> pos;
        int res; 
        Random random = new Random();
        int casualNum;

        for (var elem : observer.getList().entrySet()){
            pos = elem.getKey();
            res = elem.getValue();
            if (res != 2) {
                casualNum = random.nextInt(5);
                switch (casualNum) {
                    case 0: g.setColor(Color.BLUE);
                        break;
                    case 1: g.setColor(Color.GREEN);
                        break;
                    case 2: g.setColor(Color.MAGENTA);
                        break; 
                    case 3: g.setColor(Color.ORANGE);
                        break;  
                    case 4: g.setColor(Color.RED);
                        break;   
                    case 5: g.setColor(Color.CYAN);
                        break;      
                    default:
                        break;
                }
            } else {
                g.setColor(Color.LIGHT_GRAY);
            }
            g.fillRect(pos.getY(), pos.getX(), observer.getDimensionBrick().getY(), observer.getDimensionBrick().getX());
            g.setColor(Color.BLACK);
            g.drawRect(pos.getY(), pos.getX(), observer.getDimensionBrick().getY(),observer.getDimensionBrick().getX());
        } */
    


    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        timer.start();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        int x=observer.getPad().getX();
        int y=observer.getPad().getY();
        if(arg0.getKeyCode() == KeyEvent.VK_RIGHT){
            if(x>=observer.getDimension().getX()-observer.getPadWight()) {
                observer.changePosPad(new Pair<>(observer.getDimension().getX()-observer.getPadWight(), y));
            } else {
                moveRight();
            }
        }
        if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
            if(x<=0){
                observer.changePosPad(new Pair<>(0,y));
            } else {
                moveLeft();
            }
        }
    }

    private void moveLeft() {
        play=true;
        if(observer.getPad().getX()-20>=0){
            observer.changePosPad(new Pair<>(observer.getPad().getX()-20,observer.getPad().getY()));
        } else {
            observer.changePosPad(new Pair<>(0,observer.getPad().getY()));
        }
    }

    private void moveRight() {
        play=true;
        if(observer.getPad().getX()+20>=observer.getDimension().getX()-observer.getPadWight()){
            observer.changePosPad(new Pair<>(observer.getDimension().getX()-observer.getPadWight(),observer.getPad().getY()));
        } else {
            observer.changePosPad(new Pair<>(observer.getPad().getX()+20,observer.getPad().getY()));
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }  

    public void drawBall(Pair<Integer, Integer> pos, Integer radius, Graphics g ){
        g.setColor(Color.WHITE);
        g.drawOval(pos.getX()-radius, pos.getY()-radius, radius*2, radius*2);
    }

    public void drawPad(Pair<Integer, Integer> pos,Pair<Integer, Integer> dimPad,  Graphics g ){
        g.setColor(Color.GRAY);
        g.fillRect(pos.getX(),pos.getY(), dimPad.getX(), dimPad.getY());
        g.drawRect(pos.getX(),pos.getY(), dimPad.getX(), dimPad.getY());
    }
}
