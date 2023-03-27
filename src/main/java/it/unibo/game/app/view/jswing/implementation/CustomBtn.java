package it.unibo.game.app.view.jswing.implementation;

import javax.swing.*;
import java.awt.*;


public class CustomBtn extends JButton{
    
    private Font btnFont;

    public CustomBtn(int size, String text){
        setText(text);
        btnFont = new Font("arial", Font.BOLD, size);
        setFont(btnFont);
        setBackground(Color.WHITE);
    }
}
