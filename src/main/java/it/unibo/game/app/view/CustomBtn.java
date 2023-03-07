package it.unibo.game.app.view;

import javax.swing.*;
import java.awt.*;


public class CustomBtn extends JButton{
    private JButton btn = new JButton();
    private Font btnFont;

    public CustomBtn(int size, String text){
        this.btn.setText(text);
        this.btnFont = new Font("arial", Font.BOLD, size);
        this.btn.setFont(btnFont);
        this.btn.setBackground(Color.WHITE);
    }
}
