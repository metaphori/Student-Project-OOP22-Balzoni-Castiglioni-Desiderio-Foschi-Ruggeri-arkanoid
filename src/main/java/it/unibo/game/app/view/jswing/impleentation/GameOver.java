package it.unibo.game.app.view.jswing.impleentation;

public class GameOver extends AbstractView{

    public GameOver(UIControllerImpl uiController) {
        super(uiController);
        this.titleLabel.setText("GAME OVER");
    }
}
