package it.unibo.game.app.view;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameOver extends JPanel{
    
    private UIControllerImpl uiControllerImpl;

    public GameOver(UIControllerImpl uiCtrl) {
        this.uiControllerImpl = uiCtrl;
        JLabel gameOver = new JLabel("GAME OVER");
        JButton tryAgain = new CustomBtn(30,"Try Again");
        JButton quit = new CustomBtn(30,"Quit");
        JButton menu = new CustomBtn(30,"Start Menù");
        JPanel title = new JPanel();
        JPanel buttons = new JPanel();

        this.setLayout(new BorderLayout());
        buttons.setLayout(new GridLayout(3,1,0,1));
        gameOver.setFont(new Font("Serif",  Font.BOLD, 60));
        gameOver.setForeground(Color.WHITE);

        title.add(gameOver);
        buttons.add(tryAgain);
        buttons.add(menu);
        buttons.add(quit);
        title.setBackground(Color.BLACK);
        buttons.setBackground(Color.BLACK);
        this.setBackground(Color.BLACK);

        this.add(title, BorderLayout.NORTH);
        this.add(buttons, BorderLayout.SOUTH);

    }
}
