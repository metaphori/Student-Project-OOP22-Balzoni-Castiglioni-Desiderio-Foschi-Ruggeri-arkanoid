package it.unibo.game.app.view.jswing.impleentation;

public class Victory extends AbstractView{

    public Victory(UIControllerImpl uiCtrl) {
        super(uiCtrl);
        this.titleLabel.setText("YOU WIN");        
        this.buttonsPanel.add(menuBtn);
        this.buttonsPanel.add(quitBtn);
    }
        
}
