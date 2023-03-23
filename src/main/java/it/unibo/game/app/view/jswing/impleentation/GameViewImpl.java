package it.unibo.game.app.view.jswing.impleentation;

import java.util.Map;
import java.util.Random;

import javax.swing.*;
import it.unibo.game.Pair;
import it.unibo.game.app.model.ball.Ball;
import it.unibo.game.app.view.jswing.api.GameView;
import it.unibo.game.app.view.jswing.api.UIController;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class GameViewImpl extends JPanel implements KeyListener, ActionListener, GameView {

    private UIController observer;
    private boolean play = true;

    public GameViewImpl(UIController control) {
        setFocusable(true);
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        this.observer = control;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Determina la dimensione del pannello
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, panelWidth, panelHeight);

        // delta di trasformazione
        double deltaH = ((double) panelHeight / observer.getDimension().getX());
        double deltaW = ((double) panelWidth / observer.getDimension().getY());

        observer.getList().entrySet().stream().forEach(x -> {
            g2d.setColor(x.getValue().isEmpty() ? Color.BLACK
                : x.getValue().get() == 2 ? Color.RED
                : x.getKey().getY() == observer.getRowC(0d) ? Color.RED
                : x.getKey().getY() == observer.getRowC(1d) ? Color.BLUE
                : x.getKey().getY() == observer.getRowC(2d) ? Color.YELLOW
                : x.getKey().getY() == observer.getRowC(3d) ? Color.MAGENTA
                : x.getKey().getY() == observer.getRowC(4d) ? Color.ORANGE
                : x.getKey().getY() == observer.getRowC(5d)
                    ? Color.CYAN
                    : Color.GREEN);
            // g2d.draw(new Rectangle2D.Double(x.getKey().getX(),x.getKey().getY(),
            // observer.getDimensionBrick().getY(), observer.getDimensionBrick().getX()));
            var rec = new Rectangle2D.Double(x.getKey().getX(),  x.getKey().getY(),
            observer.getDimensionBrick().getY(), observer.getDimensionBrick().getX());
            g2d.fill(rec);
            g2d.setColor(Color.BLACK);
            g2d.draw(rec);
        });

        g2d.setColor(Color.GREEN);
        g2d.fill(new Ellipse2D.Double(observer.getBall().getX(), observer.getBall().getY(),
                observer.getRBall(), observer.getRBall()));

        observer.getSurprise().stream().forEach(x->{
            g2d.setColor(Color.RED);
            g2d.fill(new Ellipse2D.Double(x.getPos().getX() * deltaH, x.getPos().getY() * deltaW,
                x.getR()* deltaW,x.getR() * deltaH));
        });

        g2d.setColor(Color.BLACK);
        g2d.fill(new Rectangle2D.Double(observer.getPadPos().getX(), observer.getPadPos().getY() ,
                observer.getPadWight() , observer.getPadHeight()));
        
        g2d.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
            observer.movePadRight();
        }
        if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
            observer.movePadLeft();
        }
    }


    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'keyReleased'");
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void drawBall(Pair<Integer, Integer> pos, Integer radius, Graphics g) {
        g.setColor(Color.WHITE);
        g.drawOval(pos.getX() - radius, pos.getY() - radius, radius * 2, radius * 2);
    }

    @Override
    public void drawPad(Pair<Integer, Integer> pos, Pair<Integer, Integer> dimPad, Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(pos.getX(), pos.getY(), dimPad.getX(), dimPad.getY());
        g.drawRect(pos.getX(), pos.getY(), dimPad.getX(), dimPad.getY());
    }
}
