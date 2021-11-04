package com.zetcode;

import javax.swing.Timer;
import java.util.*;


/**
 * Class manages everything for the gameplay
 * Integration of every element
 * Check every collision possible
 * Update position of every element each 40 ms
 */
public class Board {
    //extends JPanel implements ActionListener {
    public int nbfrog;

    int bl =0;

    public Frog frog = new Frog();
    public Frog frog2= new Frog();

    public int B_WIDTH = 1425;
    public int B_HEIGHT = 712;


    Voie voie = new Voie();
    Voie voie2 = new Voie();
    Voie voie3 = new Voie();
    Voie voie4 = new Voie();
    Voie voie5 = new Voie();
    Voie voie6 = new Voie();
    Voie voie7 = new Voie();

    Vroum vroum1 = new Vroum();
    Vroum vroum2 = new Vroum();
    Vroum vroum3 = new Vroum();
    Vroum vroum4 = new Vroum();
    Vroum vroum5 = new Vroum();
    Vroum vroum6 = new Vroum();
    Vroum vroum7 = new Vroum();
    Vroum vroum8 = new Vroum();
    Vroum vroum9 = new Vroum();
    Vroum vroum10 = new Vroum();
    Vroum vroum11 = new Vroum();
    Vroum vroum12 = new Vroum();
    Vroum vroum13 = new Vroum();
    Vroum vroum14 = new Vroum();
    Vroum vroum15 = new Vroum();
    Vroum vroum16 = new Vroum();
    Vroum vroum17 = new Vroum();
    Vroum vroum18 = new Vroum();
    Vroum vroum19 = new Vroum();
    Vroum vroum20 = new Vroum();
    Vroum vroum21 = new Vroum();

    public Reseau reseau = new Reseau();

    public boolean inGame = true;
    public boolean win = false;



    /**
     * Initialization of each element on game window
     * Random initialization of Vroum Objects
     * Organization by Channels
     */
    public void initGame() {


        voie.im = 1;
        voie2.im = 2;
        voie3.im = 3;
        voie3.id =1;
        voie4.im = 4;
        voie5.im=5;
        voie6.im=6;
        voie6.id = 1;
        voie7.im=7;

        if (nbfrog == 1 || nbfrog == 0){
            frog.x= B_WIDTH/2;
            frog.y = B_HEIGHT-100;
        } else {
            frog.x= B_WIDTH/3;
            frog.y = B_HEIGHT-100;
            frog2.y = B_HEIGHT -100;
            frog2.x = 2*B_WIDTH/3;
        }





        voie.add(vroum1);
        voie.add(vroum2);
        voie.add(vroum3);

        voie2.add(vroum4);
        voie2.add(vroum5);
        voie2.add(vroum6);

        voie3.add(vroum7);
        voie3.add(vroum8);
        voie3.add(vroum9);

        voie4.add(vroum10);
        voie4.add(vroum11);
        voie4.add(vroum12);


        voie5.add(vroum13);
        voie5.add(vroum14);
        voie5.add(vroum15);


        voie6.add(vroum16);
        voie6.add(vroum17);
        voie6.add(vroum18);

        voie7.add(vroum19);
        voie7.add(vroum20);
        voie7.add(vroum21);

        reseau.add(voie);
        reseau.add(voie2);
        reseau.add(voie3);
        reseau.add(voie4);
        reseau.add(voie5);
        reseau.add(voie6);
        reseau.add(voie7);


        int i = 0;
        int j = 0;
        for (Voie voi : reseau) {
            int rd1 = 146;
            int rd2 = 146;
            voi.y = B_HEIGHT - i;
            voi.Sens();
            for (Vroum car : voi) {
                car.id=voi.id;
                Random rn = new Random();
                int randomNum1 = rn.nextInt(224 + 1);
                car.rightDirection = voi.rightDirection;
                car.leftDirection = voi.leftDirection;
                //car.loadImages();
                car.y = voi.y;
                if (voi.rightDirection){
                    car.x = -500 - j - randomNum1;
                    if (randomNum1 < rd1 - 146) {
                        car.x -= rd1 - 146 - randomNum1;
                    }
                }
                else if (voi.leftDirection){
                    car.x = B_HEIGHT + 500 + j + randomNum1;
                    if (randomNum1 < rd1 - 146) {
                        car.x += rd2 - 146 - randomNum1;
                    }
                }
                rd1 = randomNum1;
                rd2 = randomNum1;
                j += 470;
            }

            j = 0;
            i += 150;
        }
    }



    /**
     * Compare every collision involved with every element each 40ms
     * Put an end to the game if the collision is forbidden as follow
     * Ewok try to go beyond screen limits
     * Collision between Ewok and Falcon Millenium
     * Collision between Falcons Millenium because of random initialisation
     * Collision between the Ewok and the Channels
     * Manages the abscissa and ordinate of the channels which disappear from
     * the screen and reappear with a random reset
     * Manages the inifite mode with circular permutation of Channels with
     * gloabl movement towards down direction
     */

    public void checkCollision(Frog frog) {
        var max = B_HEIGHT;
        bl = 0;
        for (Voie voi : reseau) {
            if (voi.id ==0) {

                for (Vroum car : voi) {

                    if (frog.y >= car.top && frog.y <= car.bottom && frog.x <= car.right && frog.x >= car.left) {
                        if (nbfrog != 1) {
                            frog.score = -3;
                        }

                        inGame = false;
                    }
                    else if (car.rightDirection && car.left > B_WIDTH) {
                        car.x = -100;


                    } else if (car.leftDirection && car.right < 0) {
                        car.x = B_WIDTH + 100;

                    }
                }
            }
            else if (voi.id == 1){
                for (Vroum car : voi) {

                    if (frog.x <= car.right && frog.x >= car.left && frog.y >= voi.top && frog.y <= voi.bottom) {
                        bl+=1;
                        if (voi.rightDirection) {
                            frog.mover = 1;
                        } else if (voi.leftDirection) {
                            frog.mover = 2;
                        }


                    }
                    else if (car.rightDirection && car.left > B_WIDTH) {
                        car.x = -100;

                    } else if (car.leftDirection && car.right < 0) {
                        car.x = B_WIDTH + 100;
                    }
                }
                if (bl == 0 && frog.y >= voi.top && frog.y <= voi.bottom){
                    frog.mover = 0;
                    if (nbfrog != 1) {
                        frog.score = -3;
                    }
                    inGame = false;

                }
                if (bl == 0 && (frog.y <= voi.top || frog.y >= voi.bottom)){
                    frog.mover =0;
                }

            }
        }



        int j=0;
        for (Voie voi : reseau){

            int rd1 = 146;
            int rd2 = 146;
            if (voi.y > max) {
                voi.y =  -288;
                voi.Sens();
                for (Vroum car : voi) {
                    car.id = voi.id;
                    Random rn = new Random();
                    int randomNum1 = rn.nextInt(224 + 1);
                    car.rightDirection = voi.rightDirection;
                    car.leftDirection = voi.leftDirection;
                    car.y = voi.y;
                    if (voi.rightDirection) {
                        if (randomNum1 < rd1 - 146) {
                            car.x -= rd1 - 146 - randomNum1;
                        }
                    } else if (voi.leftDirection) {
                        if (randomNum1 < rd1 - 146) {
                            car.x += rd2 - 146 - randomNum1;
                        }
                    }
                    rd1 = randomNum1;
                    rd2 = randomNum1;
                    j += 270;
                }
            }
        }

        if (frog.y < 0 || frog.x >= B_WIDTH || frog.x < 0 || frog.y >= B_HEIGHT) {
            if (nbfrog != 1) {
                frog.score = -3;
            }
            inGame = false;
        }

        if (nbfrog ==0 && frog.y < 100){
            if (nbfrog != 1) {
                frog.score = -3;
            }
            inGame = false;
            win = true;
        }
    }

    public void down(){
        int border = B_HEIGHT/3;
        if (nbfrog==0 || nbfrog ==1){
            for (Voie voi :reseau) {
                if (frog.y < border) {
                    voi.downmouv = true;
                    frog.downmouv = true;
                }

                if (frog.y > border) {
                    voi.downmouv = false;
                    frog.downmouv = false;
                }
            }
        } else {
            int y = Math.min(frog.y, frog2.y);
            for (Voie voi :reseau) {
                if (y < border) {
                    voi.downmouv = true;
                    frog.downmouv = true;
                    frog2.downmouv = true;
                }

                if (y > border) {
                    voi.downmouv = false;
                    frog.downmouv = false;
                    frog2.downmouv = false;
                }
            }
            }


    }


    public void refresh() {
        if (inGame) {
            checkCollision(frog);
            if (nbfrog == 2) {
                checkCollision(frog2);
            }
            for (Voie voi : reseau) {
                voi.move();
                for (Vroum car : voi) {
                    car.move();
                    car.y = voi.y;
                }
            }
            if (nbfrog != 0){
                down();
            }
            frog.move();
            if (nbfrog == 2){
                frog2.move();
            }

        }
    }

    public void moveFrog(String c, Frog frog){
        switch(c){
            case "left":
                frog.leftDirection = true;
                frog.upDirection = false;
                frog.downDirection = false;
                break;
            case "right":
                frog.rightDirection = true;
                frog.upDirection = false;
                frog.downDirection = false;
                break;
            case "up":
                frog.upDirection = true;
                frog.rightDirection = false;
                frog.leftDirection = false;
                frog.score++;
                break;
            case "down":
                frog.downDirection = true;
                frog.rightDirection = false;
                frog.leftDirection = false;
                frog.score--;
                break;
        }

    }
}
