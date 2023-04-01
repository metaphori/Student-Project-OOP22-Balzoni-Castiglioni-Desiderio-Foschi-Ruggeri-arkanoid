package it.unibo.game.app.view.jswing.implementation;

import java.util.*;
import java.util.List;

import it.unibo.game.Pair;
import it.unibo.game.app.api.AppController;
import it.unibo.game.app.view.jswing.api.*;

import javax.swing.*;
import java.awt.*;

public class UIControllerImpl implements UIController {

  private final static int LONGER_SIDE = 3;
  private final static int SMALLER_SIDE = 2;
  private JFrame window;
  private AppController AppController;
  private final CardLayout layout = new CardLayout();
  private JPanel deck;
  private final Map<PAGES, JPanel> views = new HashMap<>();

  public void set(AppController control) {
    this.AppController = control;

    var screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    /* make dimension like old 4/3 monitor */
    Dimension minDim = screenSize.width > screenSize.height
        ? new Dimension(screenSize.height / SMALLER_SIDE, screenSize.width / LONGER_SIDE)
        : new Dimension(screenSize.height / LONGER_SIDE, screenSize.width / SMALLER_SIDE);
    /* run jframe on EDT */
    SwingUtilities.invokeLater(() -> {
      window = new JFrame("Arkanoid");
      this.window.setMinimumSize(minDim);
      this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.window.setVisible(true);
      this.window.requestFocusInWindow();
    });

    this.deck = new JPanel(layout);
    views.putAll(
        Map.of(PAGES.GAME, new GameViewImpl(this), PAGES.START_MENU, new StartMenu(this),
            PAGES.PAUSE_MENU, new PauseMenu(this), PAGES.TOP_5, new LeaderBoardView(this),
            PAGES.VICTORY, new Victory(this), PAGES.GAME_OVER, new GameOver(this)));

    views.entrySet().stream().forEach(x -> deck.add(x.getValue(), x.getKey().getName()));
    window.add(deck, BorderLayout.CENTER);
    initialView();
  }

  private void chargeView(PAGES p) {
    layout.show(deck, p.getName());
    window.setTitle(p.getName());
    views.get(p).requestFocusInWindow();
    if (p.equals(PAGES.GAME)) {
      AppController.play();
    }
  }

  @Override
  public void initialView() {
    chargeView(PAGES.START_MENU);
  }

  @Override
  public void pauseMenu() {
    chargeView(PAGES.PAUSE_MENU);
    AppController.onPause();
  }

  @Override
  public void gameView() {
    chargeView(PAGES.GAME);

  }

  @Override
  public void leaderBoardView() {
    chargeView(PAGES.TOP_5);
  }

  public Map<Pair<Double, Double>, Optional<Integer>> getList() {
    return AppController.getBrickList();
  }

  @Override
  public void level(int numLevel) {
    AppController.chooseLevel(numLevel);
  }

  public Pair<Double, Double> getDimension() {
    return AppController.getWorldDimension();
  }

  public Pair<Double, Double> getDimensionBrick() {
    return AppController.getBrickDimension();
  }

  @Override
  public List<Pair<Double, Double>> getBall() {
    return AppController.getBall();
  }

  @Override
  public Pair<Double, Double> getPadPos() {
    return AppController.getPad();
  }

  public Double getPadWight() {
    return AppController.getPadWight();
  }

  public Double getPadHeight() {
    return AppController.getPadHeight();
  }

  public Double getRBall() {
    return AppController.getRBall();
  }

  @Override
  public void rPaint() {
    this.window.repaint();
  }

  /*
   * @Override public void setController(AppController observer) { controller =
   * observer; }
   */

  @Override
  public void gameOver() {
    chargeView(PAGES.GAME_OVER);
    AppController.onPause();
  }

  @Override
  public void victory() {
    chargeView(PAGES.VICTORY);
  }

  public Double getRowC(Double x) {
    return this.AppController.getRow(x);
  }

  public List<Pair<String, Integer>> getBestFive() {
    return this.AppController.getBestFive();
  }

  public void movePadRight() {
    AppController.mvPadR();
  }

  public void movePadLeft() {
    AppController.mvPadL();
  }

  @Override
  public Pair<Double, Double> windowDim() {
    return new Pair<Double, Double>(Integer.valueOf(this.window.getWidth()).doubleValue(),
        Integer.valueOf(this.window.getHeight()).doubleValue());
  }

  @Override
  public List<Pair<Double, Double>> getSurprise() {
    return this.AppController.getSurprise();
  }

  // @Override
  // public List<Pair<Double, Double>> getExtraBalls(){
  // return this.AppController.getNewBalls();
  // }

  @Override
  public int getScore() {
    // TODO Auto-generated method stub
    return this.AppController.getScore();
  }

  @Override
  public int getLife() {
    // TODO Auto-generated method stub
    return this.AppController.getLife();
  }

  public void updatePoints(String name, String passWord) {
    this.AppController.updatePoints(name, passWord);
  }
}
