package com.reji.tictactoe.tictactoe;

import javax.swing.*;

public class YwinningCombos {

    static int[] ywins(JButton[] BUTTONS_ARRAY) {
        if (BUTTONS_ARRAY[0].getText().equals("O")
                && BUTTONS_ARRAY[1].getText().equals("O")
                && BUTTONS_ARRAY[2].getText().equals("O")) {
            return new int[]{0, 1, 2};
        }
        // Y--*--*
        // Y--*--*
        // Y--*--*
        if (BUTTONS_ARRAY[0].getText().equals("O")
                && BUTTONS_ARRAY[3].getText().equals("O")
                && BUTTONS_ARRAY[6].getText().equals("O")) {
            return new int[]{0, 3, 6};
        }
        // Y--*--*
        // *--Y--*
        // *--*--Y

        if (BUTTONS_ARRAY[0].getText().equals("O")
                && BUTTONS_ARRAY[4].getText().equals("O")
                && BUTTONS_ARRAY[8].getText().equals("O")) {
            return new int[]{0, 4, 8};
        }
        // *--Y--*
        // *--Y--*
        // *--Y--*
        if (BUTTONS_ARRAY[1].getText().equals("O")
                && BUTTONS_ARRAY[4].getText().equals("O")
                && BUTTONS_ARRAY[7].getText().equals("O")) {
            return new int[]{1, 4, 7};
        }
        // *--*--Y
        // *--*--Y
        // *--*--Y
        if (BUTTONS_ARRAY[2].getText().equals("O")
                && BUTTONS_ARRAY[5].getText().equals("O")
                && BUTTONS_ARRAY[8].getText().equals("O")) {
            return new int[]{2, 5, 8};
        }
        // *--*--Y
        // *--Y--*
        // Y--*--*
        if (BUTTONS_ARRAY[2].getText().equals("O")
                && BUTTONS_ARRAY[4].getText().equals("O")
                && BUTTONS_ARRAY[6].getText().equals("O")) {
            return new int[]{2, 4, 6};
        }
        // *--*--*
        // Y--Y--Y
        // *--*--*
        if (BUTTONS_ARRAY[3].getText().equals("O")
                && BUTTONS_ARRAY[4].getText().equals("O")
                && BUTTONS_ARRAY[5].getText().equals("O")) {
            return new int[]{3, 4, 5};
        }
        // *--*--*
        // *--*--*
        // Y--Y--Y
        if (BUTTONS_ARRAY[6].getText().equals("O")
                && BUTTONS_ARRAY[7].getText().equals("O")
                && BUTTONS_ARRAY[8].getText().equals("O")) {
            return new int[]{6, 7, 8};
        }
        else {
            return new int[]{0, 0, 0};
        }
    }
}
