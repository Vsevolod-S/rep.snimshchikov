package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EllipseTest {

    @Test
    void EllipseTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 0);
        double r = 1.0;
        Ellipse e = new Ellipse(a, b, r);
        assertEquals(new Ellipse(new Point(-2, 2), new Point(2, 0), 1), e);
    }

    @Test
    void perimeterTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 0);
        double r = 1.0;
        Ellipse e = new Ellipse(a, b, r);
        assertEquals(17.740555584033615, e.perimeter());
    }

    @Test
    void squareTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 0);
        double r = 1.0;
        Ellipse e = new Ellipse(a, b, r);
        assertEquals(23.78186711245481, e.square());
    }

    @Test
    void rotationTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 1);
        double r = 1.0;
        Ellipse e = new Ellipse(a, b, r);
        e.rotation(45.0);
        assertEquals(new Ellipse(new Point(-1.4760957399025187, 0.060853945340628046),
                new Point(1.4760957399025187, 2.939146054659372), 1), e);
    }

    @Test
    void movingTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 1);
        double r = 1.0;
        Ellipse e = new Ellipse(a, b, r);
        e.moving(new Point (3.4 , 4.9));
        assertEquals(new Ellipse(new Point(1.4, 5.4),
                new Point(5.4, 4.4), 1), e);
    }

    @Test
    void getCentreTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 1);
        double r = 1.0;
        Ellipse e = new Ellipse(a, b, r);
        assertEquals(new Point(0.0, 1.5), e.getCentre());
    }

    @Test
    void distanceFromFocusToCenterTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 1);
        double r = 1.0;
        Ellipse e = new Ellipse(a, b, r);
        assertEquals(2.0615528128088303, e.distanceFromFocusToCenter());
    }
}
