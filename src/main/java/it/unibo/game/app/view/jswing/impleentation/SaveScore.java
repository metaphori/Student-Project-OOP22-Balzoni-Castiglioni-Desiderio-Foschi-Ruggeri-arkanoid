package it.unibo.game.app.view.jswing.impleentation;

import javax.swing.*;

import it.unibo.game.Pair;
import it.unibo.game.app.view.jswing.api.UIController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SaveScore extends JDialog{

    private JPanel panel = new JPanel(new GridBagLayout());
    private JTextField name = new JTextField(20);
    private JTextField password = new JTextField(20);
    private List<Pair<JLabel,JTextField>> fields= new ArrayList<>(List.of(new Pair<>(new JLabel("Insert name: "),this.name),
                                                     new Pair<>(new JLabel("Insert password: "),this.password)));
    private JButton button = new JButton("OK");

    public SaveScore(UIController control){
        this.init(control);
        this.add(panel);
        this.setSize(400,150);
        this.setBounds(300,300,400,150);
        this.setVisible(true);
    }

    private void init(UIController control){
        GridBagConstraints cnst = new GridBagConstraints();
        cnst.insets=new Insets(3,3,3,3);
        cnst.fill=GridBagConstraints.CENTER;

        for(cnst.gridy=0, cnst.gridx=0; cnst.gridy<2; cnst.gridx=0, cnst.gridy++){
            panel.add(fields.get(cnst.gridy).getX(),cnst);
            cnst.gridx++;
            panel.add(fields.get(cnst.gridy).getY(),cnst);
        }
        
        button.addActionListener(e->{
            if(name.getText().length()!=0 && password.getText().length()!=0){
                control.updatePoints(name.getText(),password.getText());
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Please insert name and password");
            }
        });
        cnst.gridx++;
        panel.add(button,cnst);
    }
}