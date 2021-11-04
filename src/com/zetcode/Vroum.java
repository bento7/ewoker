package com.zetcode;

import java.awt.Image;


/**
 * Manage the behaviour of moving elements inside channels
 * Inheritance from Element
 * Instance variables
 *
 */
public class Vroum extends Element {
    public Image head;
    float left;
    float right;
    float top;
    float bottom;
    float direction;
    boolean leftDirection;
    boolean rightDirection;
    int id = 0;



    /**
     * Method managing movement of Vroum objects in Channels
     * Boolean direction variable to control movement
     */

    public void move() {
        if (leftDirection) {
            x -= vitesse;
        }

        if (rightDirection) {
            x += vitesse;
        }

        if (upDirection) {
            y -= vitesse;
        }

        if (downDirection) {
            y += vitesse;
        }
        left =x;
        right = x + 125;
        top = y;
        bottom = y + 45;
    }
}