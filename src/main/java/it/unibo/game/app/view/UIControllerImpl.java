package it.unibo.game.app.view;

import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import it.unibo.game.app.api.UIController;

public class UIControllerImpl implements UIController {
    JFrame frame = new JFrame("Arkanoid");
    Map<PAGES, JPanel> views = new HashMap<>(
            Map.of(
                    PAGES.GAME, new JPanel(),
                    PAGES.START_MENU, new StartMenu(),
                    PAGES.PAUSE_MENU, new JPanel(),
                    PAGES.TOP_10, new JPanel()
    ));


    public UIControllerImpl() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    @Override
    public void chargeView(PAGES p) {
        this.frame.setContentPane(views.get(p));
    }

    @Override
    public void initialView() {
        // TODO Auto-generated method stub
        chargeView(PAGES.START_MENU);
    }

}
