package it.unibo.game.app.view;

import java.util.*;
import it.unibo.game.Pair;
import javax.swing.*;
import java.awt.*;
import java.util.List;


import it.unibo.game.app.api.AppController;
import it.unibo.game.app.api.GameObject;
import it.unibo.game.app.api.UIController;
import it.unibo.game.app.controller.ControllerImpl;
import it.unibo.game.app.model.*;

public class UIControllerImpl implements UIController {
    JFrame window = new JFrame("Arkanoid");
    private AppController controller = new ControllerImpl(this);
    //aggiunto
    private JPanel dek = new JPanel();
    private CardLayout layout = new CardLayout();

    
    Map<PAGES, JPanel> views = new HashMap<>(
            Map.of(
                    PAGES.GAME, new GameView(this),
                    PAGES.START_MENU, new StartMenu(this),
                    PAGES.PAUSE_MENU, new JPanel(),
                    PAGES.TOP_10, new JPanel()
    ));


    public UIControllerImpl() {
        //aggiunto
        this.dek = new JPanel(layout);
        views.entrySet().stream().forEach(x->dek.add(x.getValue(),x.getKey().getName()));
        window.add(dek,BorderLayout.CENTER);
        //fino qui

        var screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        /*creo una finestra minima 2/3 dello schermo */
        this.window.setMinimumSize(new Dimension((int)screenSize.getHeight()/2,(int)screenSize.getWidth()/3));
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
        
        //fatto io
        initialView();
    }

    private void chargeView(PAGES p) {
        //this.window.setContentPane(views.get(p));
        layout.show(dek, p.getName());
        window.setTitle(p.getName());
    }

    @Override
    public void initialView() {
        // TODO Auto-generated method stub
        chargeView(PAGES.START_MENU);
    }

    @Override
    public void pauseMenu() {
        chargeView(PAGES.PAUSE_MENU);
    }

    @Override
    public void gameView() {
        chargeView(PAGES.GAME);
    }

    @Override
    public void leaderBoardView() {
        chargeView(PAGES.TOP_10);
    }

    public  Map<Pair<Integer,Integer>, Integer> getList() {
        return controller.getBrickList(); 
    } 

    @Override
    public void level(int numLevel) {
        controller.chooseLevel(numLevel);
    }

    public Pair<Integer, Integer> getDimension() {
        return new Pair<Integer,Integer>(window.getWidth(), window.getHeight());
    }

    public Pair<Integer,Integer> getDimensionBrick() {
        return controller.getBrickDimension();
    }

    @Override
    public Pair<Integer,Integer> getBall() {
        return controller.getBall();
    }

    @Override
    public Pair<Integer,Integer> getPad() {
        return controller.getPad();
    }

    //aggiunto
    public void changePosPad(Pair<Integer,Integer> pos){
        controller.changePos(pos);
    }

    public int getPadWight(){
        return controller.getPadWight();
    }

    public int getPadHeight(){
        return controller.getPadHeight();
    }

    public double getRBall(){
        return controller.getRBall();
    }

    @Override
    public void rPaint() {
        this.window.repaint();
    }
    
}
