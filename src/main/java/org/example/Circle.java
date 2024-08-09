package org.example;

public final class Circle extends Ellipse{

    public Circle(Point c, double r)
    {
        super(c, c, r);
    }

    //Получение радиуса
    public double getRadius ()
    {
        return this.r;
    }

    //Масштабирование
    public void scaling (double coeff)
    {
        this.r = this.r * coeff;
    }

    //Перемещение
    public void moving(Point newCentre)
    {
        this.f1 = newCentre;
    }

    //Расчет длины окружности
    public double circumference()
    {
        return 2.0*Math.PI*r;
    }

    //Расчет площади
    public double square()
    {
        return Math.PI*Math.pow(r,2);
    }

    //Печать окружности
    public void printCircle()
    {
        f1.printCoords();
        System.out.println("Радиус= " + r);
    }

}
