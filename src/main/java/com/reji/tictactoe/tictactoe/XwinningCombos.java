package com.reji.tictactoe.tictactoe;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class XwinningCombos {

    static int[] xwins (JButton[] BUTTONS_ARRAY) {
        // X--X--X
        // *--*--*
        // *--*--*
        if (BUTTONS_ARRAY[0].getText().equals("X")
                && BUTTONS_ARRAY[1].getText().equals("X")
                && BUTTONS_ARRAY[2].getText().equals("X")) {
            return new int[] {0, 1, 2};
        }
        // X--*--*
        // X--*--*
        // X--*--*
        else if (BUTTONS_ARRAY[0].getText().equals("X")
                && BUTTONS_ARRAY[3].getText().equals("X")
                && BUTTONS_ARRAY[6].getText().equals("X")) {
            return new int[] {0, 3, 6};
        }
        // X--*--*
        // *--X--*
        // *--*--X

        else if (BUTTONS_ARRAY[0].getText().equals("X")
                && BUTTONS_ARRAY[4].getText().equals("X")
                && BUTTONS_ARRAY[8].getText().equals("X")) {
            return new int[] {0, 4, 8};
        }
        // *--X--*
        // *--X--*
        // *--X--*
        else if (BUTTONS_ARRAY[1].getText().equals("X")
                && BUTTONS_ARRAY[4].getText().equals("X")
                && BUTTONS_ARRAY[7].getText().equals("X")) {
            return new int[] {1, 4, 7};
        }
        // *--*--X
        // *--*--X
        // *--*--X
        else if (BUTTONS_ARRAY[2].getText().equals("X")
                && BUTTONS_ARRAY[5].getText().equals("X")
                && BUTTONS_ARRAY[8].getText().equals("X")) {
            return new int[] {2, 5, 8};
        }
        // *--*--X
        // *--X--*
        // X--*--*
        else if (BUTTONS_ARRAY[2].getText().equals("X")
                && BUTTONS_ARRAY[4].getText().equals("X")
                && BUTTONS_ARRAY[6].getText().equals("X")) {
            return new int[] {2, 4, 6};
        }
        // *--*--*
        // X--X--X
        // *--*--*
        else if (BUTTONS_ARRAY[3].getText().equals("X")
                && BUTTONS_ARRAY[4].getText().equals("X")
                && BUTTONS_ARRAY[5].getText().equals("X")) {
            return new int[] {3, 4, 5};
        }
        // *--*--*
        // *--*--*
        // X--X--X
        else if (BUTTONS_ARRAY[6].getText().equals("X")
                && BUTTONS_ARRAY[7].getText().equals("X")
                && BUTTONS_ARRAY[8].getText().equals("X")) {
            return new int[] {6, 7, 8};
        }
        else {
            return new int [] {0,0,0};
        }
    }

}
