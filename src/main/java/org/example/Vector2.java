package org.example;
import java.lang.Math;
import java.util.Objects;

public class Vector2
{
    //вектор = ai+bj, где a,b - компоненты (проекции) вектора, a i,j - базис
    private double i;
    private double j;
    //конструктор по умолчанию (принимает точки)
    public Vector2(Point start, Point finish)
    {
        this.i = finish.getX() - start.getX();
        this.j = finish.getY() - start.getY();
    }

    //конструктор (принимает компоненты i и j)
    public Vector2(double i, double j)
    {
        this.i = i;
        this.j = j;
    }

    //Получить компоненту i
    public double getI()
    {
        return this.i;
    }

    //Получить компоненту j
    public double getJ()
    {
        return this.j;
    }

    //Умножение на число
    public void multiplication(double a)
    {
        this.i = this.i * a;
        this.j = this.j * a;
    }

    //Длина вектора
    public double length()
    {
        return Math.sqrt(Math.pow(this.i, 2) +Math.pow(this.j, 2));
    }

    //Печать компонент вектора
    public void printVector2 ()
    {
        System.out.println ("Компонента базиса i = " + this.i);
        System.out.println ("Компонента базиса j = " + this.j);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2 vector2 = (Vector2) o;
        return Double.compare(i, vector2.i) == 0 && Double.compare(j, vector2.j) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }

    //Нормальный вектор
    public Vector2 normal(Vector2 a)
    {
        double len = a.length();
        double i1 = this.j/len;
        double j1 = -this.i/len;
        return new Vector2(i1, j1);
    }
}