package it.unibo.game.app.view;

import javax.swing.*;

import it.unibo.game.app.api.UIController;
import java.awt.*;
import java.awt.event.ActionListener;


public class StartMenu extends JPanel{
        private UIController uiControllerImpl ;
        private static final int  EASY_LEVEL = 1;
        private static final int  MEDIUM_LEVEL = 2;
        private static final int  HARD_LEVEL = 3;

    public StartMenu(UIControllerImpl ui){
        this.uiControllerImpl = ui;
        JButton easy = new CustomBtn(30,"EASY");
        JButton medium = new CustomBtn(30,"MEDIUM");
        JButton hard = new CustomBtn(30,"HARD");
        JButton top5 = new CustomBtn(30,"CLASSIFICA");
        JLabel title = new JLabel("ARKANOID");
        JPanel buttonContainer = new JPanel();
      
        buttonContainer.setLayout(new GridBagLayout());

        final Color blue = new Color(0000255);
        this.setBackground(blue);
        buttonContainer.setBackground(blue);

        //problemi con il font, gli altri non lo vedono
        Font f = new Font("ar destine",  Font.BOLD, 60);
        title.setFont(f);
        title.setForeground(Color.WHITE);
        

        this.setLayout(new BorderLayout());


        this.add(title, BorderLayout.NORTH);
        this.add(buttonContainer, BorderLayout.CENTER);
        buttonContainer.add(easy);
        buttonContainer.add(medium);
        buttonContainer.add(hard);
        buttonContainer.add(top5);

        
        top5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                uiControllerImpl.leaderBoardView();
            }
            
        });

       
        easy.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                uiControllerImpl.level(EASY_LEVEL);
            }
            
        });

        medium.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                uiControllerImpl.level(MEDIUM_LEVEL);
                uiControllerImpl.gameView();
            }
            
        });

        hard.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                uiControllerImpl.level(HARD_LEVEL);
                //aggiunto io
                uiControllerImpl.gameView();
                //fino qui
            }
            
        });

        
    }
   
}
