package com.reji.tictactoe.tictactoe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame implements ActionListener {
    private final JFrame GAME_FIELD = new JFrame();
    private final JPanel GAME_PANEL = new JPanel();
    private final JPanel BUTTONS_PANEL = new JPanel();
    private final JLabel TEXT_FIELD = new JLabel();
    private final List<JButton>  BUTTONS_ITSELF = new ArrayList<>();
    private boolean isPlayerOneTurn = true;
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
