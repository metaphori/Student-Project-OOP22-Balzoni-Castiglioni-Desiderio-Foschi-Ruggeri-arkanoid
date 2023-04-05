package it.unibo.game.app.view.jswing.implementation;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class CustomBtn extends JButton {

	private Font btnFont;

	public CustomBtn(int size, String text) {
		setText(text);
		btnFont = new Font("arial", Font.BOLD, size);
		setFont(btnFont);
		setBackground(Color.WHITE);
	}
}
