package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {
    @Test
    void SquareTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 0);
        Square s = new Square(a, b);
        assertEquals(new Square(new Point(-2, 2), new Point(2, 0)), s);
    }

    @Test
    void perimeterTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        Square s = new Square(a, b);
        assertEquals(16.0, s.perimeter());
    }

    @Test
    void squareTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        Square s = new Square(a, b);
        assertEquals(16.0, s.square());
    }

    @Test
    void rotationTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 0);
        Square s = new Square(a, b);
        s.rotation(42.0);
        assertEquals(new Square(new Point(1.7164921778923363, 2.4330577808429164),
                new Point(-1.7164921778923363, -0.43305778084291635)), s);
    }

    @Test
    void movingTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 0);
        Square s = new Square(a, b);
        s.moving(new Point(5, 5));
        assertEquals(new Square(new Point(3.0, 6.0),
                new Point(7.0, 4.0)), s);
    }

    @Test
    void getDiagonalTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        Square s = new Square(a, b);
        assertEquals(5.656854249492381, s.getDiagonal());
    }

    @Test
    void getSideTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        Square s = new Square(a, b);
        assertEquals(4.0, s.getSide());
    }

    @Test
    void getOuterCircleTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        Square s = new Square(a, b);
        Circle circle = s.getOuterCircle();
        assertEquals(new Circle(new Point(0.0 , 0.0), 2.82842712474619), circle);
    }

    @Test
    void getInnerCircleTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        Square s = new Square(a, b);
        Circle circle = s.getInnerCircle();
        assertEquals(new Circle(new Point(0.0 , 0.0), 2.0), circle);
    }
}
