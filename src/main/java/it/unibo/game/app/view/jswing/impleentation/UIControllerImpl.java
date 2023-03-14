package it.unibo.game.app.view.jswing.impleentation;

import java.util.*;
import it.unibo.game.Pair;
import it.unibo.game.app.api.AppController;
import it.unibo.game.app.view.jswing.api.*;

import javax.swing.*;
import java.awt.*;

public class UIControllerImpl implements UIController  {
    JFrame window = new JFrame("Arkanoid");
    private AppController controller ;
    //aggiunto
    private JPanel deck = new JPanel();
    private CardLayout layout = new CardLayout();

    
    Map<PAGES, JPanel> views = new HashMap<>(
            Map.of(
                    PAGES.GAME, new GameViewImpl(this),
                    PAGES.START_MENU, new StartMenu(this),
                    PAGES.PAUSE_MENU, new PauseMenu(this),
                    PAGES.TOP_5, new LeaderBoardView(this),
                    PAGES.VICTORY, new Victory(this),
                    PAGES.GAME_OVER, new GameOver(this)
    ));


    public UIControllerImpl() {
        //aggiunto
        this.deck = new JPanel(layout);
        views.entrySet().stream().forEach(x->deck.add(x.getValue(),x.getKey().getName()));
        window.add(deck,BorderLayout.CENTER);
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
        layout.show(deck, p.getName());
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
        chargeView(PAGES.TOP_5);
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

    @Override
    public void setController(AppController observer) {
        controller = observer;
    }

    @Override
    public void gameOver() {
        chargeView(PAGES.GAME_OVER);
    }

    @Override
    public void victory() {
      chargeView(PAGES.VICTORY);
    }
    
}
