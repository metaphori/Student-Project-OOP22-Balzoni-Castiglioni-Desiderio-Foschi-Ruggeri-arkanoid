package it.unibo.game.app.view;

import javax.swing.*;

import it.unibo.game.app.api.UIController;
public class UIControllerImpl implements UIController{
    JFrame frame = new JFrame("Arkanoid");

    public UIControllerImpl (){
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    @Override
    public void chargeView(PAGES p) {
        switch (p){
            case GAME:
                break;
            case PAUSE_MENU:
                break;
            case START_MENU:{
                this.frame.add(new StartMenu());
            }
                break;
            case TOP_10:
                break;
            default:
                break;
        };
     }
    
}
