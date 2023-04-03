package it.unibo.game.app.view.jswing.implementation;

import java.awt.GridLayout;

/**
 * Implements the panel for GameOver view.
 */
public class GameOver extends AbstractView {

  /**
   * Constructor of the class.
   * 
   * @param uiCtrl is the controller that will change the views
   */
  public GameOver(final UIControllerImpl uiCtrl) {
    super(uiCtrl);
    this.getTitle().setText("GAME OVER");
    this.getButtonsPanel().add(this.getSaveBtn());
    this.getButtonsPanel().add(this.getMenuBtn());
    this.getButtonsPanel().add(this.getQuitBtn());
  }
}
