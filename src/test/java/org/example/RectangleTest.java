package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {
    @Test
    void RectangleTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        double h = 2.0;
        Rectangle r = new Rectangle(a, b, h);
        assertEquals(new Rectangle(a, b, h), r);
    }

    @Test
    void perimeterTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        double h = 2.0;
        Rectangle r = new Rectangle(a, b, h);
        assertEquals(16.0, r.perimeter());
    }

    @Test
    void squareTest(){
        Point a = new Point(-2, 0);
        Point b = new Point(2, 0);
        double h = 2.0;
        Rectangle r = new Rectangle(a, b, h);
        assertEquals(16.0, r.square());
    }

    @Test
    void rotationTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 2);
        double h = 2.0;
        Rectangle r = new Rectangle(a, b, h);
        r.rotation(38.0);
        assertEquals(new Rectangle(new Point(-1.9101472880945898, 1.4072628425812295),
                new Point(1.9101472880945898, 2.5927371574187705), 2.0), r);
    }

    @Test
    void movingTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 2);
        double h = 2.0;
        Rectangle r = new Rectangle(a, b, h);
        r.moving(new Point(5, 5));
        assertEquals(new Rectangle(new Point(3.0, 5.0),
                new Point(7.0, 5.0), 2.0), r);
    }

    @Test
    void scalingTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 2);
        double h = 2.0;
        Rectangle r = new Rectangle(a, b, h);
        r.scaling(3.2);
        assertEquals(new Rectangle(new Point(-6.4, 2.0),
                new Point(6.4, 2.0), 6.4), r);
    }

    @Test
    void getDiagonalTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 2);
        double h = 2.0;
        Rectangle r = new Rectangle(a, b, h);
        assertEquals(5.656854249492381, r.getDiagonal());
    }

    @Test
    void getHeightTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 2);
        double h = 2.0;
        Rectangle r = new Rectangle(a, b, h);
        assertEquals(4.0, r.getHeight());
    }

    @Test
    void getWidthTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 0);
        double h = 2.0;
        Rectangle r = new Rectangle(a, b, h);
        assertEquals(4.47213595499958, r.getWidth());
    }

    /*@Test
    void get4PointsTest(){
        Point a = new Point(-2, 2);
        Point b = new Point(2, 2);
        double h = 2.0;
        Rectangle r = new Rectangle(a, b, h);
        ArrayList<Point> list = r.get4Points();
        ArrayList<Point> list1 = new ArrayList<>();
        list1.add(new Point (-6.4, -4.4));
        list1.add(new Point (-6.4, 8.4));
        list1.add(new Point (6.4, -4.4));
        list1.add(new Point (6.4, 8.4));
        assertEquals(list1, list); //надо equals и hascode для List писать?
    }*/
}
