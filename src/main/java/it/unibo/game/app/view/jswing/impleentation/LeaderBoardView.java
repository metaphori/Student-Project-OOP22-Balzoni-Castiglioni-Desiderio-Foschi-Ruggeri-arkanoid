package it.unibo.game.app.view.jswing.impleentation;

import javax.swing.*;
import java.awt.*;

import it.unibo.game.app.view.jswing.api.UIController;
import java.util.List;
import it.unibo.game.Pair;

public class LeaderBoardView extends JPanel{

    private static final String COLOR="#293132";
    private List<Pair<String,Integer>> best = List.of(new Pair<>("Chiara",30),
                                                    new Pair<>("Edoardo",30),
                                                    new Pair<>("Margherita",30),
                                                    new Pair<>("Simone",30),
                                                    new Pair<>("Virginia",30));

    public LeaderBoardView(UIController control){
        this.setLayout(new GridLayout(7,1,15,15));
        this.setBorder(BorderFactory.createEmptyBorder(50, 25, 50, 25));
        this.setBackground(Color.decode(COLOR));

        JTextArea title = new JTextArea("BEST FIVE: ");
        title.setFont(new Font("myFont",Font.ITALIC,35));
        title.setBackground(Color.decode(COLOR));
        title.setForeground(Color.YELLOW);
        this.add(title);

        best.forEach(x->{
            JTextArea tx = new JTextArea(Integer.toString(best.indexOf(x)+1)+"°     "+x.getX()+"    pt:"+Integer.toString(x.getY()));
            tx.setFont(new Font("myFont",Font.ITALIC,25));
            tx.setBackground(Color.decode(COLOR));
            tx.setForeground(Color.WHITE);
            this.add(tx);
        });

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton jb = new JButton("back");
        jb.addActionListener(e->control.initialView());
        panel.add(jb);
        panel.setBackground(Color.decode(COLOR));
        this.add(panel);

    }
}