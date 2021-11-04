package com.zetcode;


/**
 * Class manage the Ewok's behaviour
 * Loading of Ewok's image
 * Movement of the Ewok with direction boolean variables
 */
public class Frog extends Element{
    public int score =0;

    /**
     * Method managing movement of Vroum objects in Channels
     * Boolean direction variable to control movement
     */

    public void move() {

        if (downmouv){
            y += downspeed  ;
        }
        if (mover == 1) {
            x+= vitesse;
        }
        if (mover == 2){
            x-= vitesse;
        }
        if (leftDirection) {
            x -= 50;
            leftDirection = false;
        }

        if (rightDirection) {
            x += 50;
            rightDirection = false;
        }

        if (upDirection) {
            y -= 50;
            upDirection = false;
        }

        if (downDirection) {
            y += 50;
            downDirection = false;
        }
    }

}
