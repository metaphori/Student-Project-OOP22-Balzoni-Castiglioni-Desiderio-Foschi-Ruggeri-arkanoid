package it.unibo.game.app.view;

import java.util.HashMap;
import java.util.Map;
import it.unibo.game.Pair;
import javax.swing.*;
import java.awt.*;

import it.unibo.game.app.api.UIController;

public class UIControllerImpl implements UIController {
    JFrame window = new JFrame("Arkanoid");
    
    Map<PAGES, JPanel> views = new HashMap<>(
            Map.of(
                    PAGES.GAME, new JPanel(),
                    PAGES.START_MENU, new StartMenu(),
                    PAGES.PAUSE_MENU, new JPanel(),
                    PAGES.TOP_10, new JPanel()
    ));


    public UIControllerImpl() {
        var screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        /*creo una finestra minima 2/3 dello schermo */
        this.window.setMinimumSize(new Dimension((int)screenSize.getHeight()/2,(int)screenSize.getWidth()/3));
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
    }

    private void chargeView(PAGES p) {
        this.window.setContentPane(views.get(p));
    }

    @Override
    public void initialView() {
        // TODO Auto-generated method stub
        chargeView(PAGES.START_MENU);
    }

    @Override
    public void pauseMenu() {
        chargeView(PAGES.START_MENU);
    }

    @Override
    public void gameView() {
        chargeView(PAGES.GAME);
    }

    @Override
    public void leaderBoardView() {
        chargeView(PAGES.TOP_10);
    }

    protected  Map<Pair<Integer,Integer>, Integer>> getList() {
        /*return controller.getBrickList() */
    }
    
}
