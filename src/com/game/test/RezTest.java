package com.game.test;

import com.game.zmeika.main.Rez;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class RezTest {

    @Test
    void sum() {
        Rez rez = new Rez();
        int actual = rez.sum(5,6);
        int expected = 11;
        assertEquals(expected, actual);
    }

    @Test
    void div() {

    }

}