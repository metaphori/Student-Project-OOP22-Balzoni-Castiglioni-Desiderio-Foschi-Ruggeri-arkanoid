package it.unibo.game.app.view.jswing.implementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unibo.game.app.view.jswing.api.UIController;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle.Control;

import it.unibo.game.Pair;

public class LeaderBoardView extends JPanel implements ActionListener {

	private static final String COLOR = "#293132";
	private List<Pair<String, Integer>> best = new ArrayList<>();
	private List<JTextArea> tx = new ArrayList<>();
	private static final int MAX = 5;
	private UIController control;

	public LeaderBoardView(UIController control) {
		this.control = control;
		this.best = control.getBestFive();
		this.setLayout(new GridLayout(7, 1, 15, 15));
		this.setBorder(BorderFactory.createEmptyBorder(50, 25, 50, 25));
		this.setBackground(Color.decode(COLOR));

		JTextArea title = new JTextArea("BEST FIVE: ");
		title.setFont(new Font("myFont", Font.ITALIC, (int) (this.control.windowDim().getY() / 16)));
		title.setBackground(Color.decode(COLOR));
		title.setForeground(Color.YELLOW);
		this.add(title);

		for (int i = 0; i < MAX; i++) {
			JTextArea text = new JTextArea();
			text.setFont(new Font("myFont", Font.ITALIC, 25));
			text.setBackground(Color.decode(COLOR));
			text.setForeground(Color.WHITE);
			this.tx.add(text);
			this.add(text);
		}

		this.best.forEach(x -> {
			int indx = this.best.indexOf(x);
			this.tx.get(indx)
					.setText(Integer.toString(indx + 1) + "°     " + x.getX() + "    pt:" + Integer.toString(x.getY()));
		});

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton jb = new JButton("back");
		jb.addActionListener(e -> control.initialView());
		panel.add(jb);
		panel.setBackground(Color.decode(COLOR));
		this.add(panel);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.best = this.control.getBestFive();
		this.best.forEach(x -> {
			int indx = this.best.indexOf(x);
			this.tx.get(indx)
					.setText(Integer.toString(indx + 1) + "°     " + x.getX() + "    pt:" + Integer.toString(x.getY()));
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.revalidate();
		this.repaint();
	}
}