package it.unibo.game.app.view.jswing.implementation;

import java.awt.GridLayout;

public class Victory extends AbstractView{

    public Victory(UIControllerImpl uiCtrl) {
        super(uiCtrl);
        this.titleLabel.setText("YOU WIN");   
        buttonsPanel.setLayout(new GridLayout(3,1,0,1));
        this.buttonsPanel.add(saveBtn);     
        this.buttonsPanel.add(menuBtn);
        this.buttonsPanel.add(quitBtn);
    }
        
}
