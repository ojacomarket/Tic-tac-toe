package com.reji.tictactoe.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public interface TicTacToeWinner extends TicTacToeButtons, TicTacToeCombinations {

    /**
     * Method looks for each possible winning combination and if found, then display proper message
     *
     * @param text     - displayable text to user
     * @param buttons  - JButton[]
     * @param randomNr - random number, generated with new Random()
     */
    default void winningCombos(JLabel text, JButton[] buttons, Random randomNr) {

        if (!Arrays.equals(combos(buttons, "X"), new int[]{0, 0, 0})) {
            winsOnX(combos(buttons, "X"), buttons, text);
        } else if (!Arrays.equals(combos(buttons, "O"), new int[]{0, 0, 0})) {
            winsOnO(combos(buttons, "O"), buttons, text);
        } else {
            if (Arrays.stream(buttons).noneMatch(button -> button.getText().isEmpty())) {
                for (JButton button : buttons) {
                    button.setEnabled(false);
                }
                text.setText("Draw!");
                flush(buttons);
                whosTurn(randomNr, text);
            }
        }
    }

    /**
     * Method acts as a utility to winningCombos method, which fires when condition on X is met.
     *
     * @param ints    - combinations that user has already made
     * @param buttons - JButton[]
     * @param text    - displayable text to user
     */
    default void winsOnX(int[] ints, JButton[] buttons, JLabel text) {

        for (int i = 0; i < ints.length; i++) {
            buttons[ints[i]].setBackground(Color.RED);
            buttons[ints[i]].setEnabled(false);
        }
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
        text.setText("X won!");
        flush(buttons);
        text.setText("O turn!");
    }

    /**
     * Method acts as a utility to winningCombos method, which fires when condition on Y is met.
     *
     * @param ints    - combinations that user has already made
     * @param buttons - JButton[]
     * @param text    - displayable text to user
     */
    default void winsOnO(int[] ints, JButton[] buttons, JLabel text) {

        for (int i = 0; i < ints.length; i++) {
            buttons[ints[i]].setBackground(Color.BLUE);
        }
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
        text.setText("O won!");
        flush(buttons);
        text.setText("X turn!");
    }
}
