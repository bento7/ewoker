package com.zetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrogTest {
    Board board = new Board();
    @Test
    public void testmove() {
        board.frog.y = board.B_HEIGHT/2;
        board.frog.x = board.B_WIDTH/2;
        int y = board.frog.y;
        int x = board.frog.x;
        board.frog.downDirection = true;
        board.frog.downmouv = true;
        board.frog.mover = 1;
        board.frog.move();
        y += 50 + board.frog.downspeed;
        x += board.frog.vitesse;
        assertEquals(y , board.frog.y);
        assertEquals(x, board.frog.x);
    }


}