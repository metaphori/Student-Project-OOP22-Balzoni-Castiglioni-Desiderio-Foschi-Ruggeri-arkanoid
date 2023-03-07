package it.unibo.game.app.view;

import javax.swing.*;
import java.awt.*;


public class StartMenu extends JPanel{
        
    public StartMenu(){
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

        
    }
   
}
