package it.unibo.game.app.view.jswing.impleentation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
public class PauseMenu extends AbstractView{

    
    public PauseMenu(UIControllerImpl uiCtrl) {
        
        super(uiCtrl);
        this.titleLabel.setText("PAUSE");
        buttonsPanel.setLayout(new GridLayout(3,1,0,1));
        JButton resumeBtn = new CustomBtn(30, "Resume");
        buttonsPanel.add(resumeBtn);
        buttonsPanel.add(menuBtn);
        buttonsPanel.add(quitBtn);

        resumeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                uiCtrl.gameView();
            }
            
        });
    }
}
