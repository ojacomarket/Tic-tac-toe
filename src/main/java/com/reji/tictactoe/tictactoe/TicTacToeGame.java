package com.reji.tictactoe.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.function.Consumer;

import static java.awt.BorderLayout.NORTH;
import static java.awt.Font.BOLD;
import static javax.swing.JLabel.CENTER;

public class TicTacToeGame implements ActionListener {
    private final JFrame GAME_FIELD = new JFrame();
    private final JPanel TITLE_PANEL = new JPanel();
    private final JPanel BUTTONS_PANEL = new JPanel();
    private final JLabel TEXT_FIELD = new JLabel();
    private final JButton[] BUTTONS_ARRAY = new JButton[9];
    private final Random generator = new Random();
    private boolean isPlayerOneTurn;
    private final Consumer<JButton> initButtons = BUTTONS_PANEL::add;

    public TicTacToeGame() {
        initGameField();
    }

    private void initGameField() {
        // Init Game Field main window
        GAME_FIELD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GAME_FIELD.setSize(400, 400);
        GAME_FIELD.getContentPane().setBackground(new Color(153, 255, 153));
        GAME_FIELD.setLayout(new BorderLayout());
        GAME_FIELD.setResizable(false);
        GAME_FIELD.setVisible(true);

        // Init Text Field within Game Field window
        TEXT_FIELD.setBackground(new Color(51, 255, 51));
        TEXT_FIELD.setForeground(new Color(47, 49, 63));
        TEXT_FIELD.setFont(new Font("Roboto", BOLD, 40));
        TEXT_FIELD.setHorizontalAlignment(CENTER);
        TEXT_FIELD.setText("Tic Tac Toe");
        TEXT_FIELD.setOpaque(true);

        // Init title component of Game Field
        TITLE_PANEL.setLayout(new BorderLayout());
        TITLE_PANEL.setBounds(0, 0, GAME_FIELD.getWidth(), 100);

        // Init button panel (container for buttons)
        BUTTONS_PANEL.setLayout(new GridLayout(3, 3));
        BUTTONS_PANEL.setBackground(new Color(0, 0, 0));

        initButtons();
        /*for(int buttonNr = 0; buttonNr < 9; buttonNr++) {
            BUTTONS_ARRAY[buttonNr] = new JButton();
            BUTTONS_PANEL.add(BUTTONS_ARRAY[buttonNr]);
            BUTTONS_ARRAY[buttonNr].setFont(new Font("MV Boli", BOLD, 120));
            BUTTONS_ARRAY[buttonNr].setFocusable(false);
            BUTTONS_ARRAY[buttonNr].addActionListener(this);

        }*/

        // Add TEXT field to TITLE panel
        TITLE_PANEL.add(TEXT_FIELD);

        // Add TITLE panel to GAME FIELD and stick to the top of view
        GAME_FIELD.add(TITLE_PANEL, NORTH);
        GAME_FIELD.add(BUTTONS_PANEL);
        whosTurn();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for (int buttonNr = 0; buttonNr < BUTTONS_ARRAY.length; buttonNr++) {
            if (actionEvent.getSource() == BUTTONS_ARRAY[buttonNr]) {
                if(isPlayerOneTurn) {

                }

            }
        }
    }

    public void initButtons() {
        for (int buttonNr = 0; buttonNr < 9; buttonNr++) {
            initButtons
                    .andThen(button -> button.addActionListener(this))
                    .andThen(button -> button.setFocusable(false))
                    .andThen(button -> button.setFont(new Font("MV Boli", BOLD, 40)))
                    .accept(BUTTONS_ARRAY[buttonNr] = new JButton());
        }
    }

    public void whosTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException sysInterrupt) {
            sysInterrupt.printStackTrace();
        }
        if (generator.nextInt(2) == 1) {
            isPlayerOneTurn = true;
            TEXT_FIELD.setText("X turn");
        } else {
            isPlayerOneTurn = false;
            TEXT_FIELD.setText("O turn");
        }
    }
}
