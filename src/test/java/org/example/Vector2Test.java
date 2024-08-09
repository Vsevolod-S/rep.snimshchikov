package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2Test {
    @Test
    void Vector2Test() {
        Vector2 v1 = new Vector2(4.0, -0.5);
        assertEquals(new Vector2(4.0, -0.5), v1);
    }

    @Test
    void getITest() {
        Vector2 v1 = new Vector2(4.0, -0.5);
        assertEquals(4.0, v1.getI());
    }

    @Test
    void getJTest() {
        Vector2 v1 = new Vector2(4.0, -0.5);
        assertEquals(-0.5, v1.getJ());
    }

    @Test
    void multiplicationTest() {
        Vector2 v1 = new Vector2(4.0, -0.5);
        v1.multiplication(2.0);
        assertEquals(new Vector2(8.0, -1.0), v1);
    }

    @Test
    void lengthTest() {
        Vector2 v1 = new Vector2(4.0, -0.5);
        assertEquals(4.031128874149275, v1.length());
    }

    @Test
    void normalTest() {
        Vector2 v1 = new Vector2(4.0, -0.5);
        Vector2 v2 = new Vector2(2.0, 2.0);
        assertEquals(new Vector2(-0.17677669529663687, -1.414213562373095), v1.normal(v2));
    }
}
