package com.darthlynx.algorithms.timus;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MahjongTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Mahjong mahjong;

    // TODO
    // 1a 2a 3a 6a 7a 8a 5b 5b 5b 9c 8c 7c 1c 1c   - Tsumo
    // 1a 2a 3a 6a 7a 8a 5b 5b 5b 9c 8c 7c 1c 1b   - Tenpai (pair)
    // 1a 2a 3a 6a 7a 8a 5b 5b 5b 9c 8c 6c 1c 1c   - Tenpai (triple)
    // 1a 2a 3a 6a 7a 8a 5b 5b 5b 9c 5c 3c 1c 1c   - Noten

    @Before
    public void setUpMahjong() {
        mahjong = new Mahjong();
        PrintStream out = new PrintStream(outContent);
        System.setOut(out);
    }

    @After
    public void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    public void testTsumo() {
        String dice = "1a 2a 3a 6a 7a 8a 5b 5b 5b 9c 8c 7c 1c 1c";
        String expectedResult = "Tsumo";
//        mahjong.solve(dice);
//        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testTenpaiForPair() {

    }

    @Test
    public void testTenpaiForTriple() {

    }

    @Test
    public void testNoten() {

    }
}
