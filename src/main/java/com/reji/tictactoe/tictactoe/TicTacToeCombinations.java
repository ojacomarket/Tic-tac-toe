package com.reji.tictactoe.tictactoe;

import javax.swing.*;

public interface TicTacToeCombinations {

    /**
     * Method that will handle all possible situations of a game.
     *
     * @param BUTTONS_ARRAY - JButton[]
     * @param XorO          - pass String for X or for O
     * @return - array of int values, that represent combination on grid
     */
    default int[] combos(JButton[] BUTTONS_ARRAY, String XorO) {

        // X--X--X
        // *--*--*
        // *--*--*
        if (BUTTONS_ARRAY[0].getText().equals(XorO)
                && BUTTONS_ARRAY[1].getText().equals(XorO)
                && BUTTONS_ARRAY[2].getText().equals(XorO)) {
            return new int[]{0, 1, 2};
        }
        // X--*--*
        // X--*--*
        // X--*--*
        else if (BUTTONS_ARRAY[0].getText().equals(XorO)
                && BUTTONS_ARRAY[3].getText().equals(XorO)
                && BUTTONS_ARRAY[6].getText().equals(XorO)) {
            return new int[]{0, 3, 6};
        }
        // X--*--*
        // *--X--*
        // *--*--X

        else if (BUTTONS_ARRAY[0].getText().equals(XorO)
                && BUTTONS_ARRAY[4].getText().equals(XorO)
                && BUTTONS_ARRAY[8].getText().equals(XorO)) {
            return new int[]{0, 4, 8};
        }
        // *--X--*
        // *--X--*
        // *--X--*
        else if (BUTTONS_ARRAY[1].getText().equals(XorO)
                && BUTTONS_ARRAY[4].getText().equals(XorO)
                && BUTTONS_ARRAY[7].getText().equals(XorO)) {
            return new int[]{1, 4, 7};
        }
        // *--*--X
        // *--*--X
        // *--*--X
        else if (BUTTONS_ARRAY[2].getText().equals(XorO)
                && BUTTONS_ARRAY[5].getText().equals(XorO)
                && BUTTONS_ARRAY[8].getText().equals(XorO)) {
            return new int[]{2, 5, 8};
        }
        // *--*--X
        // *--X--*
        // X--*--*
        else if (BUTTONS_ARRAY[2].getText().equals(XorO)
                && BUTTONS_ARRAY[4].getText().equals(XorO)
                && BUTTONS_ARRAY[6].getText().equals(XorO)) {
            return new int[]{2, 4, 6};
        }
        // *--*--*
        // X--X--X
        // *--*--*
        else if (BUTTONS_ARRAY[3].getText().equals(XorO)
                && BUTTONS_ARRAY[4].getText().equals(XorO)
                && BUTTONS_ARRAY[5].getText().equals(XorO)) {
            return new int[]{3, 4, 5};
        }
        // *--*--*
        // *--*--*
        // X--X--X
        else if (BUTTONS_ARRAY[6].getText().equals(XorO)
                && BUTTONS_ARRAY[7].getText().equals(XorO)
                && BUTTONS_ARRAY[8].getText().equals(XorO)) {
            return new int[]{6, 7, 8};
        } else {
            return new int[]{0, 0, 0};
        }
    }
}
