package it.unibo.game.app.view.jswing.implementation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PauseMenu extends AbstractView {

  private JButton resumeBtn; 

  public PauseMenu(UIControllerImpl uiCtrl) {

    super(uiCtrl);
    this.getTitle().setText("PAUSE");
    this.getButtonsPanel().setLayout(new GridLayout(3, 1, 0, 1));
    resumeBtn = new CustomBtn(this.getSizeBtn(), "Resume");
    //this.setBtn(resumeBtn, "Resume");,
    this.getButtonsPanel().add(resumeBtn);
    this.getButtonsPanel().add(this.getMenuBtn());
    this.getButtonsPanel().add(this.getQuitBtn());

    resumeBtn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        uiCtrl.gameView();
      }

    });
  }
}
