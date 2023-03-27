package it.unibo.game.app.view.jswing.implementation;

import javax.swing.*;

import it.unibo.game.app.view.jswing.api.UIController;

import java.awt.*;
import java.awt.event.ActionListener;


public class StartMenu extends JPanel{
        private UIController uiControllerImpl ;
        private static final int  EASY_LEVEL = 1;
        private static final int  MEDIUM_LEVEL = 2;
        private static final int  HARD_LEVEL = 3;

    public StartMenu(UIControllerImpl ui){
        this.uiControllerImpl = ui;
        JButton easy = new CustomBtn(25,"EASY");
        JButton medium = new CustomBtn(25,"MEDIUM");
        JButton hard = new CustomBtn(25,"HARD");
        JButton top5 = new CustomBtn(25,"CLASSIFICA");
        JLabel title = new JLabel("ARKANOID");
        JPanel buttonContainer = new JPanel();
      
        buttonContainer.setLayout(new GridLayout(4, 1, 15, 15));

        this.setBackground(Color.BLACK);
        buttonContainer.setBackground(Color.BLACK);

    
        Font f = new Font("Serif",  Font.BOLD, 60);
        title.setFont(f);
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        this.setLayout(new GridLayout(2, 1, 15, 15));
        this.setBorder(BorderFactory.createEmptyBorder(50, 25, 25, 50));


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
                uiControllerImpl.gameView();
            }
            
        });

        medium.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                uiControllerImpl.level(MEDIUM_LEVEL);
                //aggiunta da chiara
                uiControllerImpl.gameView();
                //fino a qui
            }
            
        });

        hard.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                uiControllerImpl.level(HARD_LEVEL);
                //aggiunto da virgi
                uiControllerImpl.gameView();
                //fino qui
            }
            
        });

        
    }
   
}
