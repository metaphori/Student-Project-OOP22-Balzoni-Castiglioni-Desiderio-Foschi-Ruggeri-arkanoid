package it.unibo.game.app.view.jswing.impleentation;

import java.util.*;
import java.util.List;

import it.unibo.game.Pair;
import it.unibo.game.app.api.AppController;
import it.unibo.game.app.model.ball.Ball;
import it.unibo.game.app.view.jswing.api.*;

import javax.swing.*;
import java.awt.*;

public class UIControllerImpl implements UIController  {
    JFrame window = new JFrame("Arkanoid");
    private AppController controller ;
    private CardLayout layout = new CardLayout();
    private JPanel deck;
    private JMenuBar navBar = new JMenuBar();
    private JMenu options = new JMenu("options");
    private final JMenuItem menu = new JMenuItem(PAGES.START_MENU.toString());
    private final JMenuItem pause = new JMenuItem(PAGES.PAUSE_MENU.toString());
    private final JMenuItem leadrBoard = new JMenuItem(PAGES.TOP_5.toString());
    private Map<PAGES, JPanel> views = new HashMap<>();

    public void set(AppController control){
        this.controller=control;

        options.add(menu);
        options.add(pause);
        options.add(leadrBoard);
        navBar.add(options);

        menu.addActionListener(e-> initialView());
        pause.addActionListener(e-> pauseMenu());
        leadrBoard.addActionListener(e-> leaderBoardView());

        var screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.window.setMinimumSize(new Dimension(screenSize.height/2,screenSize.width/3));
        this.window.setJMenuBar(navBar);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
        this.window.requestFocusInWindow();

        this.deck = new JPanel(layout);
        views.putAll(Map.of(
            PAGES.GAME, new GameViewImpl(this),
            PAGES.START_MENU, new StartMenu(this),
            PAGES.PAUSE_MENU, new PauseMenu(this),
            PAGES.TOP_5, new LeaderBoardView(this),
            PAGES.VICTORY, new Victory(this),
            PAGES.GAME_OVER, new GameOver(this)
        ));
        views.entrySet().stream().forEach(x->deck.add(x.getValue(),x.getKey().getName()));
        window.add(deck,BorderLayout.CENTER);
        initialView();
    }


    /*public UIControllerImpl() {
        
        options.add(menu);
        options.add(pause);
        options.add(leadrBoard);
        navBar.add(options);

        menu.addActionListener(e-> initialView());
        pause.addActionListener(e-> pauseMenu());
        leadrBoard.addActionListener(e-> leaderBoardView());

        this.deck = new JPanel(layout);
        views.entrySet().stream().forEach(x->deck.add(x.getValue(),x.getKey().getName()));
        window.add(deck,BorderLayout.CENTER);
        

        var screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.window.setMinimumSize(new Dimension(screenSize.height/2,screenSize.width/3));
        this.window.setJMenuBar(navBar);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
        this.window.requestFocusInWindow();
        initialView();
    } */

    private void chargeView(PAGES p) {
        layout.show(deck, p.getName());
        window.setTitle(p.getName());
        views.get(p).requestFocusInWindow();
    }

    @Override
    public void initialView() {
        chargeView(PAGES.START_MENU);
    }

    @Override
    public void pauseMenu() {
        chargeView(PAGES.PAUSE_MENU);
        controller.onPause();
    }

    @Override
    public void gameView() {
        chargeView(PAGES.GAME);
        controller.play();
    }

    @Override
    public void leaderBoardView() {
        chargeView(PAGES.TOP_5);
    }

    public  Map<Pair<Double, Double>, Optional<Integer>> getList() {
        return controller.getBrickList(); 
    } 

    @Override
    public void level(int numLevel) {
        controller.chooseLevel(numLevel);
    }

    public Pair<Double, Double> getDimension() {
        return controller.getWorldDimension();
    }

    public Pair<Double, Double> getDimensionBrick() {
        return controller.getBrickDimension();
    }

    @Override
    public Pair<Double, Double> getBall() {
        return controller.getBall();
    }

    @Override
    public Pair<Double, Double> getPadPos() {
        return controller.getPad();
    }


    public Double getPadWight(){
        return controller.getPadWight();
    }

    public Double getPadHeight(){
        return controller.getPadHeight();
    }

    public Double getRBall(){
        return controller.getRBall();
    }

    @Override
    public void rPaint() {
        this.window.repaint();
    }

    /*@Override
    public void setController(AppController observer) {
        controller = observer;
    } */

    @Override
    public void gameOver() {
        chargeView(PAGES.GAME_OVER);
        controller.onPause();
    }

    @Override
    public void victory() {
      chargeView(PAGES.VICTORY);
    }
    
    public Double getRowC(Double x) {
        return this.controller.getRow(x);
    }

    public List<Pair<String,Integer>> getBestFive(){
        return this.controller.getBestFive();
    }
    
    public void movePadRight() {
        controller.mvPadR();
    }

    public void movePadLeft() {
        controller.mvPadL();
    }


    @Override
    public Pair<Double, Double> windowDim() {
        return new Pair<Double,Double>(
            Integer.valueOf(this.window.getWidth()).doubleValue(),
            Integer.valueOf(this.window.getHeight()).doubleValue());
    }


    @Override
    public List<Ball> getSurprise() {
        // TODO Auto-generated method stub
        return this.controller.getSurprise();
    }


    @Override
    public int getScore() {
        // TODO Auto-generated method stub
        return this.controller.getScore();
    }

    public void updatePoints(String name, String passWord){
        this.controller.updatePoints(name,passWord);
    }
    
}
