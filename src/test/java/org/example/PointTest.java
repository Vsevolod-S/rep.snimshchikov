package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    void PointTest(){
        Point p1 = new Point(1.0, 2.0);
        assertEquals(new Point(1.0, 2.0), p1);
    }

    @Test
    void Point1Test(){
        Point p1 = new Point();
        assertEquals(new Point(0.0, 0.0), p1);
    }

    @Test
    void subtractionTest(){
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(5.0, 1.5);
        p1.subtraction(p2);
        assertEquals(new Point(-4.0, 0.5), p1);
    }

    @Test
    void additionTest(){
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(5.0, 1.5);
        p1.addition(p2);
        assertEquals(new Point(6.0, 3.5), p1);
    }

    @Test
    void pointMinusVectorTest() {
        Point p1 = new Point(1.0, 2.0);
        Vector2 v1 = new Vector2(0.5,  1.0);
        p1 = p1.pointMinusVector(v1);
        assertEquals(new Point(0.5, 1.0), p1);
    }

    @Test
    void pointPlusVectorTest() {
        Point p1 = new Point(1.0, 2.0);
        Vector2 v1 = new Vector2(0.5,  1.0);
        p1 = p1.pointPlusVector(v1);
        assertEquals(new Point(1.5, 3.0), p1);
    }

    @Test
    void setCoordsTest() {
        Point p1 = new Point(1.0, 2.0);
        p1.setCoords(2.0,3.0);
        assertEquals(new Point(2.0,3.0), p1);
    }

    @Test
    void setXTest() {
        Point p1 = new Point();
        p1.setX(2.0);
        assertEquals(2.0, p1.getX());
    }

    @Test
    void setYTest() {
        Point p1 = new Point();
        p1.setY(2.0);
        assertEquals(2.0, p1.getY());
    }

    @Test
    void getXTest() {
        Point p1 = new Point(100.0, 101.0);
        double value = p1.getX();
        assertEquals(100.0, value);
    }

    @Test
    void getYTest() {
        Point p1 = new Point(100.0, 101.0);
        double value = p1.getY();
        assertEquals(101.0, value);
    }

    @Test
    void rotationNewPositionOfPointTest() {
        Point p1 = new Point(-2.3333333333333335, -2.3333333333333335);
        Point p2 = p1.rotationNewPositionOfPoint(30);
        assertEquals(new Point(-2.6653271726210406,1.9454870731456484), p2);
    }
}