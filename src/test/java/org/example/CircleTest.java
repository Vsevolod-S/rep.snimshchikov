package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {
    @Test
    void CircleTest(){
        Point a = new Point(-2, 2);
        double r = 1.0;
        Circle c = new Circle(a, r);
        assertEquals(new Circle(new Point(-2, 2),1.0), c);
    }

    @Test
    void getRadiusTest(){
        Point a = new Point(-2, 2);
        double r = 1.0;
        Circle c = new Circle(a, r);
        assertEquals(1.0, c.getRadius());
    }

    @Test
    void scaling1Test(){
        Point a = new Point(-2, 2);
        double r = 1.0;
        Circle c = new Circle(a, r);
        c.scaling(2.8);
        assertEquals(new Circle(new Point(-2, 2),2.8), c);
    }

    /*@Test
    void movingTest(){
        Point a = new Point(-2, 2);
        double r = 1.0;
        Circle c = new Circle(a, r);
        c.moving(new Point(5, 5));
        assertEquals(new Circle(new Point(5, 5),1.0), c);
    }*/

    @Test
    void circumferenceTest(){
        Point a = new Point(-2, 2);
        double r = 1.0;
        Circle c = new Circle(a, r);
        assertEquals(2.0*Math.PI, c.circumference());
    }

    /*@Test
    void square1Test(){
        Point a = new Point(-2, 2);
        double r = 1.0;
        Circle c = new Circle(a, r);
        assertEquals(2.0*Math.PI, c.square());
    }*/
}
