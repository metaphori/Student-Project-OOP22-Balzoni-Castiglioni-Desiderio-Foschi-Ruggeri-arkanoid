package it.unibo.game.app.view;

import javax.swing.*;
import java.awt.*;


public class StartMenu extends JPanel{
        
    public StartMenu(){
        JButton easy = new JButton("EASY");
        JButton medium = new JButton("MEDIUM");
        JButton hard = new JButton("HARD");
        JButton top5 = new JButton("CLASSIFICA");
        JLabel title = new JLabel("ARKANOID");
        
      

        Color blue = new Color(0000255);
        this.setBackground(blue);

        Font f = new Font("ar destine",  Font.BOLD, 50);
        title.setFont(f);
        title.setForeground(Color.WHITE);

        Font bottonFont = new Font("arial", Font.ROMAN_BASELINE, 30);
        easy.setFont(bottonFont);
        medium.setFont(bottonFont);
        hard.setFont(bottonFont);
        top5.setFont(bottonFont);

        this.setLayout(new GridBagLayout());

        this.add(title);
        

        
    }
}
