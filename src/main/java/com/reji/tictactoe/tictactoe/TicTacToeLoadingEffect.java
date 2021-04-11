package com.reji.tictactoe.tictactoe;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;

public interface TicTacToeLoadingEffect {

    /**
     * Method for fancy loading effect before game initializes.
     *
     * @param window - JFrame object
     */
    default void loading(JFrame window) {

        JProgressBar progress = new JProgressBar();
        window.add(progress);
        progress.setValue(100);
        progress.setStringPainted(true);
        progress.setString("Loading...");
        progress.setFont(new Font("Verdana", BOLD, 40));
        progress.setForeground(new Color(25, 69, 90));
        progress.setSize(window.getWidth(), window.getHeight());
        int count = 200;
        while (count > 0) {
            progress.setValue(count);
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            count--;
        }
        window.remove(progress);
    }
}
