package com.zetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BoardTest {
    Board board =new Board();


    @Test
    public void testinitGame() {
        board.nbfrog = 1;
        board.initGame();
        assertEquals(1, board.voie3.id);
        assertTrue(board.reseau.size() == 7);
        assertTrue(board.frog.x != 0 && board.frog.y != 0);
        assertTrue(board.frog2.x ==0 && board.frog2.y == 0);
        for (Voie voi : board.reseau) {
            assertTrue(voi.size() == 3);
            for (Vroum car : voi){
                //assertTrue(car.x > board.B_WIDTH || car.x < 0);
            }
        }
        board.nbfrog = 2;
        board.initGame();
        assertTrue(board.frog2.x != 0 && board.frog2.y != 0);
    }


    @Test
    public void testcheckcollision(){
        board.voie.add(board.vroum1);
        board.reseau.add(board.voie);
        board.nbfrog=1;

        board.vroum1.x = board.B_WIDTH/2;
        board.vroum1.y = board.B_HEIGHT-100;
        board.voie.y = board.vroum1.y;
        board.frog.y = board.vroum1.y;board.frog.x = board.vroum1.x;
        board.vroum1.left = board.vroum1.x;
        board.vroum1.right = board.vroum1.x + 125;
        board.vroum1.top = board.vroum1.y;
        board.vroum1.bottom = board.vroum1.y + 45;
        board.voie.top = board.voie.y;
        board.voie.bottom = board.voie.y + 41;

        board.checkCollision(board.frog);
        //ewok on falcon millenium
        if (board.voie.id == 0) {
            assertFalse(board.inGame);
        }

        //ewok on speeder
        board.inGame = true;
        board.voie.id =1;
        board.vroum1.id = 1;
        board.voie.rightDirection = true;
        board.vroum1.rightDirection = true;
        board.checkCollision(board.frog);
        if (board.voie.id == 1) {
            assertEquals(1, board.frog.mover);
        }

        //ewok in lava
        board.inGame = true;
        board.vroum1.x += 200;
        board.vroum1.move();
        board.checkCollision(board.frog);
        if (board.voie.id == 1) {
            assertFalse(board.inGame);
        }

        // in single finite mode : ewok won
        board.inGame = true;
        board.nbfrog = 0;
        board.frog.y = 50;
        board.checkCollision(board.frog);
        assertFalse(board.inGame);
        assertTrue(board.win);

        //check of circular track permutation
        board.inGame = true;
        board.voie.y = board.B_HEIGHT+2;
        board.vroum1.y = board.voie.y;
        board.checkCollision(board.frog);
        assertTrue(board.voie.y < 0);

    }




    @Test
    public void testdown() {
        board.initGame();
        board.nbfrog = 1;
        board.frog.y = 20;
        board.frog.x = board.B_WIDTH/2;
        board.down();
        assertTrue( board.frog.downmouv);

        //two players : 2 frogs move downward if at least one respect the condition
        board.nbfrog = 2;
        board.frog2.y = board.B_HEIGHT-10;
        board.frog2.x = 10;
        board.down();
        assertTrue(board.frog.downmouv);
        assertTrue(board.frog2.downmouv);
    }




    @Test
    public void testmoveFrog() {
        board.frog.leftDirection = false;
        board.frog.upDirection = false;
        board.frog.downDirection = false;
        board.moveFrog("left", board.frog);
        assertTrue(board.frog.leftDirection);
    }
}