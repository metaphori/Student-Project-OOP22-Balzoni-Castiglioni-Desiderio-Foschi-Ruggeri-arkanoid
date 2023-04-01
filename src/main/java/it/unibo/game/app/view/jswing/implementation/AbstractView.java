package it.unibo.game.app.view.jswing.implementation;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.game.app.view.jswing.api.UIController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Implements a common JPanel for Pause, GameOver and Victory.
 */
public abstract class AbstractView extends JPanel {
  private UIController observer;
  private JLabel titleLabel;
  private JPanel buttonsPanel;
  private JButton quitBtn;
  private JButton menuBtn;
  private JButton saveBtn;
  private final int sizeBtn = 30;
  private final int sizeTitle = 60;

  /**
   * constructor of the class.
   * 
   * @param uiCtrl is the controller that will change the views
   */
  public AbstractView(final UIControllerImpl uiCtrl) {
    this.observer = uiCtrl;
    this.titleLabel = new JLabel();
    this.saveBtn = new CustomBtn(sizeBtn, "Save");
    this.menuBtn = new CustomBtn(sizeBtn, "Start Menu");
    this.quitBtn = new CustomBtn(sizeBtn, "Quit");

    JPanel titlePanel = new JPanel();
    buttonsPanel = new JPanel();

    this.setLayout(new BorderLayout());
    buttonsPanel.setLayout(new GridLayout(2, 1, 0, 1));
    titleLabel.setFont(new Font("Serif", Font.BOLD, sizeTitle));
    titleLabel.setForeground(Color.WHITE);

    titlePanel.add(titleLabel);

    titlePanel.setBackground(Color.BLACK);
    buttonsPanel.setBackground(Color.BLACK);
    this.setBackground(Color.BLACK);

    this.add(titlePanel, BorderLayout.NORTH);
    this.add(buttonsPanel, BorderLayout.SOUTH);

    this.menuBtn.addActionListener(new ActionListener() {

      /**
       * {@inheritDoc}
       */
      @Override
      public void actionPerformed(final ActionEvent e) {
        // TODO Auto-generated method stub
        observer.initialView();
      }

    });
    this.quitBtn.addActionListener(new ActionListener() {

      /**
       * {@inheritDoc}
       */
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.exit(0);
      }

    });

    this.saveBtn.addActionListener(new ActionListener() {

      /**
       * {@inheritDoc}
       */
      @Override
      public void actionPerformed(final ActionEvent arg0) {
        new SaveScore(observer);
      }

    });
  }

  /**
   * {@inheritDoc}
   */
  protected JLabel getTitle() {
    return this.titleLabel;
  }

  /**
   * {@inheritDoc}
   */
  protected JButton getSaveBtn() {
    return this.saveBtn;
  }

  /**
   * {@inheritDoc}
   */
  protected JButton getQuitBtn() {
    return this.quitBtn;
  }

  /**
   * {@inheritDoc}
   */
  protected JButton getMenuBtn() {
    return this.menuBtn;
  }

  /**
   * {@inheritDoc}
   */
  protected JPanel getButtonsPanel() {
    return this.buttonsPanel;
  }

  /**
   * {@inheritDoc}
   */
  protected int getSizeBtn() {
    return this.sizeBtn;
  }
}
