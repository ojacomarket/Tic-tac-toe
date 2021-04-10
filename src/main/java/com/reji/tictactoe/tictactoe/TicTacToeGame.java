package com.reji.tictactoe.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
        for (JButton button : BUTTONS_ARRAY) {
            if (actionEvent.getSource() == button) {
                if (isPlayerOneTurn) {
                    if (button.getText().equals("")) {
                        button.setForeground(new Color(255, 0, 0));
                        button.setText("X");
                        isPlayerOneTurn = false;
                        TEXT_FIELD.setText("O turn");
                        winningCombos();
                    }
                } else {
                    if (button.getText().equals("")) {
                        button.setForeground(new Color(0, 0, 255));
                        button.setText("O");
                        isPlayerOneTurn = true;
                        TEXT_FIELD.setText("X turn");
                        winningCombos();
                    }
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
    public void winningCombos () {

        // X--X--X
        // *--*--*
        // *--*--*
        if (BUTTONS_ARRAY[0].getText().equals("X")
                && BUTTONS_ARRAY[1].getText().equals("X")
                && BUTTONS_ARRAY[2].getText().equals("X")) {
            winsOnX(0,1,2);
        }
        // X--*--*
        // X--*--*
        // X--*--*
        if (BUTTONS_ARRAY[0].getText().equals("X")
                && BUTTONS_ARRAY[3].getText().equals("X")
                && BUTTONS_ARRAY[6].getText().equals("X")) {
            winsOnX(0,3,6);
        }
        // X--*--*
        // *--X--*
        // *--*--X

        if (BUTTONS_ARRAY[0].getText().equals("X")
                && BUTTONS_ARRAY[4].getText().equals("X")
                && BUTTONS_ARRAY[8].getText().equals("X")) {
            winsOnX(0,4,8);
        }
        // *--X--*
        // *--X--*
        // *--X--*
        if (BUTTONS_ARRAY[1].getText().equals("X")
                && BUTTONS_ARRAY[4].getText().equals("X")
                && BUTTONS_ARRAY[7].getText().equals("X")) {
            winsOnX(1,4,7);
        }
        // *--*--X
        // *--*--X
        // *--*--X
        if (BUTTONS_ARRAY[2].getText().equals("X")
                && BUTTONS_ARRAY[5].getText().equals("X")
                && BUTTONS_ARRAY[8].getText().equals("X")) {
            winsOnX(2,5,8);
        }
        // *--*--X
        // *--X--*
        // X--*--*
        if (BUTTONS_ARRAY[2].getText().equals("X")
                && BUTTONS_ARRAY[4].getText().equals("X")
                && BUTTONS_ARRAY[6].getText().equals("X")) {
            winsOnX(2,4,6);
        }
        // *--*--*
        // X--X--X
        // *--*--*
        if (BUTTONS_ARRAY[3].getText().equals("X")
                && BUTTONS_ARRAY[4].getText().equals("X")
                && BUTTONS_ARRAY[5].getText().equals("X")) {
            winsOnX(3,4,5);
        }
        // *--*--*
        // *--*--*
        // X--X--X
        if (BUTTONS_ARRAY[6].getText().equals("X")
                && BUTTONS_ARRAY[7].getText().equals("X")
                && BUTTONS_ARRAY[8].getText().equals("X")) {
            winsOnX(3,6,8);
        }

        /////////////////////////////////////////////////////

        // Y--Y--Y
        // *--*--*
        // *--*--*
        if (BUTTONS_ARRAY[0].getText().equals("Y")
                && BUTTONS_ARRAY[1].getText().equals("Y")
                && BUTTONS_ARRAY[2].getText().equals("Y")) {
            winsOnO(0,1,2);
        }
        // Y--*--*
        // Y--*--*
        // Y--*--*
        if (BUTTONS_ARRAY[0].getText().equals("Y")
                && BUTTONS_ARRAY[3].getText().equals("Y")
                && BUTTONS_ARRAY[6].getText().equals("Y")) {
            winsOnO(0,3,6);
        }
        // Y--*--*
        // *--Y--*
        // *--*--Y

        if (BUTTONS_ARRAY[0].getText().equals("Y")
                && BUTTONS_ARRAY[4].getText().equals("Y")
                && BUTTONS_ARRAY[8].getText().equals("Y")) {
            winsOnO(0,4,8);
        }
        // *--Y--*
        // *--Y--*
        // *--Y--*
        if (BUTTONS_ARRAY[1].getText().equals("Y")
                && BUTTONS_ARRAY[4].getText().equals("Y")
                && BUTTONS_ARRAY[7].getText().equals("Y")) {
            winsOnO(1,4,7);
        }
        // *--*--Y
        // *--*--Y
        // *--*--Y
        if (BUTTONS_ARRAY[2].getText().equals("Y")
                && BUTTONS_ARRAY[5].getText().equals("Y")
                && BUTTONS_ARRAY[8].getText().equals("Y")) {
            winsOnO(2,5,8);
        }
        // *--*--Y
        // *--Y--*
        // Y--*--*
        if (BUTTONS_ARRAY[2].getText().equals("Y")
                && BUTTONS_ARRAY[4].getText().equals("Y")
                && BUTTONS_ARRAY[6].getText().equals("Y")) {
            winsOnO(2,4,6);
        }
        // *--*--*
        // Y--Y--Y
        // *--*--*
        if (BUTTONS_ARRAY[3].getText().equals("Y")
                && BUTTONS_ARRAY[4].getText().equals("Y")
                && BUTTONS_ARRAY[5].getText().equals("Y")) {
            winsOnO(3,4,5);
        }
        // *--*--*
        // *--*--*
        // Y--Y--Y
        if (BUTTONS_ARRAY[6].getText().equals("Y")
                && BUTTONS_ARRAY[7].getText().equals("Y")
                && BUTTONS_ARRAY[8].getText().equals("Y")) {
            winsOnO(3,6,8);
        }
    }
    public void winsOnX (int button1, int button2, int button3) {
        BUTTONS_ARRAY[button1].setBackground(Color.RED);
        BUTTONS_ARRAY[button2].setBackground(Color.RED);
        BUTTONS_ARRAY[button3].setBackground(Color.RED);
        for (JButton button : BUTTONS_ARRAY) {
            button.setEnabled(false);
        }
        TEXT_FIELD.setText("X won!");
    }

    public void winsOnO(int button1, int button2, int button3) {
        BUTTONS_ARRAY[button1].setBackground(Color.RED);
        BUTTONS_ARRAY[button2].setBackground(Color.RED);
        BUTTONS_ARRAY[button3].setBackground(Color.RED);

        for (JButton button : BUTTONS_ARRAY) {
            button.setEnabled(false);
        }
        TEXT_FIELD.setText("O won!");

    }
}
