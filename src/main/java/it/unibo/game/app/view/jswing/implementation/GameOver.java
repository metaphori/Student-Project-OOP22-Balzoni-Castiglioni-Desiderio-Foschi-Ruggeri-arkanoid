package it.unibo.game.app.view.jswing.implementation;

import java.awt.GridLayout;

public class GameOver extends AbstractView {

  public GameOver(UIControllerImpl uiCtrl) {
    super(uiCtrl);
    this.getTitle().setText("GAME OVER");
    getButtonsPanel().setLayout(new GridLayout(3, 1, 0, 1));
    this.getButtonsPanel().setLayout(new GridLayout(3, 1, 0, 1));
    this.getButtonsPanel().add(this.getSaveBtn());
    this.getButtonsPanel().add(this.getMenuBtn());
    this.getButtonsPanel().add(this.getQuitBtn());
  }
}
