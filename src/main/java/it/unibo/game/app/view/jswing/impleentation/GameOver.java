package it.unibo.game.app.view.jswing.impleentation;

public class GameOver extends AbstractView{

    public GameOver(UIControllerImpl uiCtrl) {
        super(uiCtrl);
        this.titleLabel.setText("GAME OVER");
    }
}
