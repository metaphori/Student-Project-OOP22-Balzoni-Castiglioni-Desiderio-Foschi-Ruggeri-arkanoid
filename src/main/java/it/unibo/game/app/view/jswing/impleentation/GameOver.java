package it.unibo.game.app.view.jswing.impleentation;

import java.awt.GridLayout;

public class GameOver extends AbstractView{

    public GameOver(UIControllerImpl uiCtrl) {
        super(uiCtrl);
        this.titleLabel.setText("GAME OVER");
        buttonsPanel.setLayout(new GridLayout(3,1,0,1));
        this.buttonsPanel.add(saveBtn);
        this.buttonsPanel.add(menuBtn);
        this.buttonsPanel.add(quitBtn);
    }
}
