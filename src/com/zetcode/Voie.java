package com.zetcode;

import java.util.ArrayList;


/**
 * Class managing channels of moving obstacles
 * get an ordinate, boolean direction variables
 */
public class Voie extends ArrayList<Vroum> {
    public int x=0;
    public int y;
    float top;
    float bottom;
    public boolean leftDirection = false;
    public boolean rightDirection = false;
    boolean downmouv;
    int vitesse = 3;
    int im ;
    int id = 0;

    /**
     * Loading of images to a particular channel to make infinite background
     */


    /**
     * Random initialization of direction of moving obstacles in the channel
     */
    public void Sens(){
        double nb;
        nb=Math.random();
        if (nb<0.5) {
            leftDirection = true;
            rightDirection = false;
        }
        else {

            leftDirection=false;
            rightDirection=true;
        }

    }

    /**
     * Moving of channels downward when the Ewok pass above middle screen
     */
    public void move() {
        vitesse = 3;
        if (downmouv) {
            y += vitesse;
        } else {
            vitesse = 0;

        }
        top = y;
        bottom = y + 41;
    }
}