package com.reji.tictactoe.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.function.Consumer;

import static java.awt.Font.PLAIN;

public interface TicTacToeButtons extends ActionListener {

    /**
     * Method used to build JPanel with proper buttons, practical use - only with Grid Layout.
     *
     * @param initButtons - Consumer, adding buttons to JButton[]
     * @param action      - Event over buttons
     * @param buttons     - Array of buttons
     */
    default void build(Consumer<JButton> initButtons, ActionListener action, JButton[] buttons) {

        for (int buttonNr = 0; buttonNr < 9; buttonNr++) {
            initButtons
                    .andThen(button -> button.addActionListener(action))
                    .andThen(button -> button.setFocusable(false))
                    .andThen(button -> button.setBackground(new Color(226, 225, 225)))
                    .andThen(button -> button.setFont(new Font("Dialog", PLAIN, 80)))
                    .accept(buttons[buttonNr] = new JButton());
        }
    }

    /**
     * Method used to reset Tic Tac Toe Game's buttons, while displaying dialog popup message.
     *
     * @param buttonsOnGridLayout - JButton objects, that are placed within JPanel's GridLayout.
     */
    default void flush(JButton[] buttonsOnGridLayout) {

        int confirmation = JOptionPane.showConfirmDialog(new JOptionPane(), "Would you like to play again?", "Game over.",
                JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            for (JButton button : buttonsOnGridLayout) {
                button.setText("");
                button.setEnabled(true);
                button.setBackground(new Color(226, 225, 225));
            }
        } else System.exit(0);
    }

    /**
     * Method used to randomly decide on the beginning and the end of the game, who's turn.
     *
     * @param randomNum - random number created with new Random()
     * @param text      - JLabel text field
     * @return - is player one turn?
     */
    default boolean whosTurn(Random randomNum, JLabel text) {

        if (randomNum.nextInt(2) == 1) {
            text.setText("X turn");
            return true;
        } else {
            text.setText("O turn");
            return false;
        }
    }
}
