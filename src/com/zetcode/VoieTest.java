package com.zetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoieTest {
    Board board = new Board();
    @Test
    public void testmove() {
        board.voie.y = board.B_HEIGHT/2;
        int y = board.voie.y;
        board.voie.downmouv = true;
        board.voie.move();
        y += board.voie.vitesse;
        assertEquals(y , board.voie.y);
    }

}