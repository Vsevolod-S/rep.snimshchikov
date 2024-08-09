package org.example;

import java.util.Objects;

public class Point
{
    //точка с координатами (x,y)
    private double x;
    private double y;
    //конструктор по умолчанию
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    //Пустой конструктор
    public Point()
    {
        this.x = 0.0;
        this.y = 0.0;
    }

    //Вычитание
    public void subtraction(Point p1)
    {
        this.x = this.x - p1.getX();
        this.y = this.y - p1.getY();
    }

    //Сложение
    public void addition(Point p1)
    {
        this.x = this.x + p1.getX();
        this.y = this.y + p1.getY();
    }

    //Построение вектора из точки со знаком минус
    public Point pointMinusVector(Vector2 v)
    {
        return new Point(this.x - v.getI(), this.y - v.getJ());
    }

    //Построение вектора из точки со знаком плюс
    public Point pointPlusVector(Vector2 v)
    {
        return new Point(this.x + v.getI(), this.y + v.getJ());
    }


    //Задать координаты
    public void setCoords (double a, double b)
    {
        this.x = a;
        this.y = b;
    }

    //Задать координату x
    public void setX (double a)
    {
        this.x = a;
    }

    //Задать координату Y
    public void setY (double b)
    {
        this.y = b;
    }

    //Получить компоненту х
    public double getX ()
    {
        return this.x;
    }

    //Получить компоненту Y
    public double getY ()
    {
        return this.y;
    }

    //Печать координат
    public void printCoords ()
    {
        System.out.println ("Координата x = " + this.x);
        System.out.println ("Координата y = " + this.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(x, point.x) == 0 && Double.compare(y, point.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Point rotationNewPositionOfPoint(double angle)
    {
        return new Point(this.x * Math.cos(angle) - this.y *  Math.sin(angle), this.x * Math.sin(angle) + this.y *  Math.cos(angle));
    }
}
