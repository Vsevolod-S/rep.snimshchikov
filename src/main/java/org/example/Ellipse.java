package org.example;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Objects;

public class Ellipse {
    protected Point   f1; //точка фокуса 1
    protected Point   f2; //точка фокуса 2
    protected double  r;  //перифокусное расстояние (минимальное расстояние от фокуса до точки на эллипсе)
    public Ellipse(Point f1, Point f2, double r)
    {
        this.f1 = f1;
        this.f2 = f2;
        this.r = r;
    }

    public double perimeter()
    {
        Ellipse e1 = new Ellipse(this.f1, this.f2, this.r);
        double big = e1.getTheBigAxleShaft();
        double minor = e1.getTheMinorAxleShaft();
        return 2.0 * Math.PI * Math.sqrt((Math.pow(big, 2) + Math.pow(minor, 2))/2);
    }

    public double square()
    {
        Ellipse e1 = new Ellipse(this.f1, this.f2, this.r);
        double big = e1.getTheBigAxleShaft();
        double minor = e1.getTheMinorAxleShaft();
        return Math.PI * big * minor;
    }

    //Вращение
    public void rotation(double angle)
    {
        Ellipse e = new Ellipse(this.f1, this.f2, this.r);

        //Расчет центра
        Point centre = e.getCentre();

        //Вычитаем из каждой точки точку центра (переносим центр прямоугольника в начало координат)
        this.f1.subtraction(centre);
        this.f2.subtraction(centre);

        //Вращаем прямоугольник относительно начала координат
        this.f1 = this.f1.rotationNewPositionOfPoint(angle);
        this.f2 = this.f2.rotationNewPositionOfPoint(angle);

        //Возвращаем центр прямоугольника на прежнее место (до вращения)
        this.f1.addition(centre);
        this.f2.addition(centre);
    }

    //Перемещение
    public void moving(Point newCentre)
    {
        Ellipse e = new Ellipse(this.f1, this.f2, this.r);

        //Расчет разности между старым и новым центром (результат храним в newCentre)
        newCentre.subtraction(e.getCentre());

        //Добавление разности между центрами (само перемещение)
        this.f1.addition(newCentre);
        this.f2.addition(newCentre);
    }

    //Расчет центра фигуры
    public Point getCentre()
    {
        double x = (f1.getX() + f2.getX()) / 2.0;
        double y = (f1.getY() + f2.getY()) / 2.0;
        return new Point(x, y);
    }

    //Масштабирование
    public void scaling (double coeff)
    {
        Ellipse e = new Ellipse(this.f1, this.f2, this.r);
        Point centre = e.getCentre();

        //Вычитаем из каждой точки точку центра (переносим центр треугольника в начало координат)
        this.f1.subtraction(centre);
        this.f2.subtraction(centre);

        //Умножаем координаты на коэффициент
        this.f1.setCoords(this.f1.getX() * coeff, this.f1.getY() * coeff);
        this.f2.setCoords(this.f2.getX() * coeff, this.f2.getY() * coeff);
        this.r = r * coeff;

        //Возвращаем центр треугольника на прежнее место (до масштабирования)
        this.f1.addition(centre);
        this.f2.addition(centre);
    }
    //расстояние от фокуса до центра
    public double distanceFromFocusToCenter()
    {
        Ellipse e = new Ellipse(this.f1, this.f2, this.r);
        Point centre = e.getCentre();
        Vector2 v = new Vector2(this.f1, centre);
        return v.length();
    }

    //Получение обоих фокусов в виде списка
    public ArrayList<Point> getFocusPoints ()
    {
        //Объявляем список точек рамером 2 [0...1]
        ArrayList<Point> list = new ArrayList<>(1);

        //Добавляем фокусы
        list.add(this.f1);
        list.add(this.f2);

        return list;
    }
    //Длина большей полуоси
    public double getTheBigAxleShaft()
    {
        Ellipse e = new Ellipse(this.f1, this.f2, this.r);
        Point centre = e.getCentre();
        Vector2 v = new Vector2(this.f2, centre);
        return this.r + v.length();
    }

    //Длина малой полуоси
    public double getTheMinorAxleShaft()
    {
        Ellipse e = new Ellipse(this.f1, this.f2, this.r);
        Point centre = e.getCentre();
        Vector2 v = new Vector2(this.f2, centre);
        double x = this.r + v.length();
        return Math.sqrt(Math.pow(x,2) - Math.pow(v.length(),2));
    }

    //Печать эллипса
    public void printEllipse()
    {
        this.f1.printCoords();
        this.f2.printCoords();
        System.out.println(this.r);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return Double.compare(r, ellipse.r) == 0 && Objects.equals(f1, ellipse.f1) && Objects.equals(f2, ellipse.f2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f1, f2, r);
    }
}
