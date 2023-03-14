package it.unibo.game.app.view.jswing.impleentation;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*Implements a common JPanel for Pause, GameOver and Victory */
/* 
 * Just change the titleLabel text
 * this.titleLabel.setText("");
*/
public abstract class AbstractView extends JPanel{
    protected UIControllerImpl uiControllerImpl;
    protected JLabel titleLabel;

    public AbstractView(UIControllerImpl uiCtrl) {
        this.uiControllerImpl = uiCtrl;
        titleLabel = new JLabel("Title");
        JButton quitBtn = new CustomBtn(30,"Quit");
        JButton menuBtn = new CustomBtn(30,"Start Menù");
        JPanel titlePanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        this.setLayout(new BorderLayout());
        buttonsPanel.setLayout(new GridLayout(2,1,0,1));
        titleLabel.setFont(new Font("Serif",  Font.BOLD, 60));
        titleLabel.setForeground(Color.WHITE);

        titlePanel.add(titleLabel);
        buttonsPanel.add(menuBtn);
        buttonsPanel.add(quitBtn);

        titlePanel.setBackground(Color.BLACK);
        buttonsPanel.setBackground(Color.BLACK);
        this.setBackground(Color.BLACK);

        this.add(titlePanel, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.SOUTH);

        menuBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }

        });
        quitBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
    }
    
}
