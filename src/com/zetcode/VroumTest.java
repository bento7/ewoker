package com.zetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VroumTest {
    Board board = new Board();
    @Test
    public void testmove() {
        board.vroum1.y = board.B_HEIGHT/2;
        int y = board.vroum1.y;
        board.vroum1.downDirection = true;
        board.vroum1.move();
        y += board.vroum1.vitesse;
        assertEquals(y , board.vroum1.y);
    }

}
