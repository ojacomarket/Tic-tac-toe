package com.reji.tictactoe.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.awt.BorderLayout.NORTH;
import static java.awt.Font.BOLD;
import static javax.swing.JLabel.CENTER;

public class TicTacToeGame extends Thread implements
        ActionListener,
        TicTacToeButtons,
        TicTacToeLoadingEffect,
        TicTacToeCombinations,
        TicTacToeWinner {

    private final JFrame GAME_FIELD = new JFrame("Tic Tac Toe");
    private final JPanel TITLE_PANEL = new JPanel();
    private final JPanel BUTTONS_PANEL = new JPanel();
    private final JLabel TEXT_FIELD = new JLabel();
    private final JButton[] BUTTONS_ARRAY = new JButton[9];
    private final Random generator = new Random();
    private Boolean isPlayerOneTurn = null;

    public TicTacToeGame() {

        initGameField();
    }

    private void initGameField() {

        // Init main window
        GAME_FIELD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GAME_FIELD.setSize(400, 400);
        GAME_FIELD.getContentPane().setBackground(new Color(153, 255, 153));
        GAME_FIELD.setLayout(new BorderLayout());
        GAME_FIELD.setResizable(false);
        GAME_FIELD.setVisible(true);
        GAME_FIELD.setLocationRelativeTo(null);

        // Add loading effect
        loading(GAME_FIELD);

        // Init text styles
        TEXT_FIELD.setBackground(new Color(204, 255, 255));
        TEXT_FIELD.setForeground(new Color(47, 49, 63));
        TEXT_FIELD.setFont(new Font("Roboto", BOLD, 40));
        TEXT_FIELD.setHorizontalAlignment(CENTER);
        TEXT_FIELD.setOpaque(true);

        // Init component, that will display who's turn and who has won
        TITLE_PANEL.setLayout(new BorderLayout());
        TITLE_PANEL.setBounds(0, 0, GAME_FIELD.getWidth(), 100);

        // Init buttons container
        BUTTONS_PANEL.setLayout(new GridLayout(3, 3, 0, 0));
        build(BUTTONS_PANEL::add, this, BUTTONS_ARRAY);

        // Add text styles to component
        TITLE_PANEL.add(TEXT_FIELD);

        // Add remain component into main window
        GAME_FIELD.add(TITLE_PANEL, NORTH);
        GAME_FIELD.add(BUTTONS_PANEL);

        //Print who's turn
        isPlayerOneTurn = whosTurn(generator, TEXT_FIELD);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        for (JButton button : BUTTONS_ARRAY) {
            if (actionEvent.getSource() == button) {
                if (isPlayerOneTurn) {
                    if (button.getText().equals("")) {
                        button.setForeground(new Color(255, 0, 0));
                        button.setText("X");
                        isPlayerOneTurn = false;
                        TEXT_FIELD.setText("O turn");
                        winningCombos(TEXT_FIELD, BUTTONS_ARRAY, generator);
                    }
                } else {
                    if (button.getText().equals("")) {
                        button.setForeground(new Color(0, 0, 255));
                        button.setText("O");
                        isPlayerOneTurn = true;
                        TEXT_FIELD.setText("X turn");
                        winningCombos(TEXT_FIELD, BUTTONS_ARRAY, generator);
                    }
                }
            }
        }
    }
}
