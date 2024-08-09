package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    void TriangleTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        Point c = new Point(1, 7);
        Triangle t = new Triangle(a, b, c);
        assertEquals(new Triangle(a, b, c), t);
    }

    @Test
    void perimeterTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        Point c = new Point(1, 7);
        Triangle t = new Triangle(a, b, c);
        assertEquals(18.686840917729384, t.perimeter());
    }

    @Test
    void squareTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        Point c = new Point(1, 7);
        Triangle t = new Triangle(a, b, c);
        assertEquals(14.0, t.square());
    }

    @Test
    void rotationTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        Point c = new Point(1, 7);
        Triangle t = new Triangle(a, b, c);
        t.rotation(30.0);
        assertEquals(new Triangle(new Point(-2.331993839287707, 4.278820406478982),
                new Point(-1.7149880397373714, 0.32669391010753435),
                new Point(5.046981879025077, 2.3944856834134844)), t);
    }

    @Test
    void movingTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 2);
        Point c = new Point(0, 0);
        Triangle t = new Triangle(a, b, c);
        t.moving(new Point (8.0, 8.0));
        assertEquals(new Triangle(new Point(6.0, 8.666666666666668),
                new Point(10.0, 8.666666666666668),
                new Point(8.0, 6.666666666666667)), t);
    }

    @Test
    void scalingTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        Point c = new Point(1, 7);
        Triangle t = new Triangle(a, b, c);
        t.scaling(2.0);
        assertEquals(new Triangle(new Point(-4.333333333333334, -2.3333333333333335),
                new Point(3.666666666666667, -2.3333333333333335),
                new Point(1.6666666666666667, 11.666666666666666)), t);
    }

    @Test
    void getOuterCircleTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        Point c = new Point(1, 7);
        Triangle t = new Triangle(a, b, c);
        Circle circle = t.getOuterCircle();
        assertEquals(new Circle(new Point(0.0 , 3.2857142857142856), 3.84654629081036), circle);
    }

    @Test
    void getInnerCircleTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        Point c = new Point(1, 7);
        Triangle t = new Triangle(a, b, c);
        Circle circle = t.getInnerCircle();
        assertEquals(new Circle(new Point(0.2723526469992165 , 1.4983806050082351), 1.4983806050082351), circle);
    }
}
