package com.reji.tictactoe.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.awt.BorderLayout.NORTH;
import static java.awt.Font.BOLD;
import static javax.swing.JLabel.CENTER;

public class TicTacToeGame implements ActionListener {
    private final JFrame GAME_FIELD = new JFrame();
    private final JPanel TITLE_PANEL = new JPanel();
    private final JPanel BUTTONS_PANEL = new JPanel();
    private final JLabel TEXT_FIELD = new JLabel();
    private final List<JButton>  BUTTONS_ITSELF = new ArrayList<>();
    private final Random generator = new Random();
    private boolean isPlayerOneTurn;

    public TicTacToeGame () {
        initGameField();
    }
    private void initGameField () {
        // Init Game Field main window
        GAME_FIELD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GAME_FIELD.setSize(400,400);
        GAME_FIELD.getContentPane().setBackground(new Color(153,255,153));
        GAME_FIELD.setLayout(new BorderLayout());
        GAME_FIELD.setVisible(true);

        // Init Text Field within Game Field window
        TEXT_FIELD.setBackground(new Color (51,255,51));
        TEXT_FIELD.setForeground(new Color(47,49,63));
        TEXT_FIELD.setFont(new Font("Roboto", BOLD, 40));
        TEXT_FIELD.setHorizontalAlignment(CENTER);
        TEXT_FIELD.setText("Tic Tac Toe");
        TEXT_FIELD.setOpaque(true);

        // Init title component of Game Field
        TITLE_PANEL.setLayout(new BorderLayout());
        TITLE_PANEL.setBounds(0,0,GAME_FIELD.getWidth(),100);

        // Add TEXT field to TITLE panel
        TITLE_PANEL.add(TEXT_FIELD);

        // Add TITLE panel to GAME FIELD and stick to the top of view
        GAME_FIELD.add(TITLE_PANEL, NORTH);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
