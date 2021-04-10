package com.reji.tictactoe.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToeGame implements ActionListener {
    private final JFrame GAME_FIELD = new JFrame();
    private final JPanel GAME_PANEL = new JPanel();
    private final JPanel BUTTONS_PANEL = new JPanel();
    private final JLabel TEXT_FIELD = new JLabel();
    private final List<JButton>  BUTTONS_ITSELF = new ArrayList<>();
    private final Random generator = new Random();
    private boolean isPlayerOneTurn;

    public TicTacToeGame () {

    }
    private void initGameField () {
        GAME_FIELD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GAME_FIELD.setSize(800,800);
        GAME_FIELD.getContentPane().setBackground(new Color(153,255,153));
        GAME_FIELD.setLayout(new BorderLayout());
        GAME_FIELD.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
