package org.example;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Objects;

public class Rectangle implements Figure
{
    protected Point   p1; //Первая точка прямоугольника
    protected Point   p2; //Вторая точка прямоугольника
    protected double  h;  //Половина высоты прямоугольника

    //конструктор по умолчанию
    public Rectangle(Point p1, Point p2, double h)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.h = h;
    }

    //Печать компонент прямоугольника
    public void printRectangle()
    {
        this.p1.printCoords();
        this.p2.printCoords();
        System.out.println("Половина высоты= " + this.h);
    }

    //Расчет периметра
    public double perimeter()
    {
        Vector2 a = new Vector2 (this.p1, this.p2);
        return 2.0*(2.0 * h + a.length());
    }

    //Расчет площади
    public double square()
    {
        Vector2 a = new Vector2 (this.p1, this.p2);
        return (2.0 * h) * a.length();
    }

    //Вращение
    public void rotation(double angle)
    {
        Rectangle r = new Rectangle(this.p1, this.p2, this.h);

        //Расчет центра
        Point centre = r.getCentre();

        //Вычитаем из каждой точки точку центра (переносим центр прямоугольника в начало координат)
        //По-хорошему можно вызвать метод r.moving(centre);
        this.p1.subtraction(centre);
        this.p2.subtraction(centre);

        //Вращаем прямоугольник относительно начала координат
        this.p1 = this.p1.rotationNewPositionOfPoint(angle);
        this.p2 = this.p2.rotationNewPositionOfPoint(angle);

        //Возвращаем центр прямоугольника на прежнее место (до вращения)
        //Тут тоже moving
        this.p1.addition(centre);
        this.p2.addition(centre);
    }

    //Перемещение
    public void moving(Point newCentre)
    {
        Rectangle r = new Rectangle(this.p1, this.p2, this.h);

        //Расчет разности между старым и новым центром (результат храним в newCentre)
        newCentre.subtraction(r.getCentre());

        //Добавление разности между центрами (само перемещение)
        this.p1.addition(newCentre);
        this.p2.addition(newCentre);
    }

    //Расчет центра фигуры
    public Point getCentre()
    {
        double x = (p1.getX() + p2.getX()) / 2.0;
        double y = (p1.getY() + p2.getY()) / 2.0;
        return new Point(x, y);
    }

    //Масштабирование
    public void scaling (double coeff)
    {
        Rectangle r = new Rectangle(this.p1, this.p2, this.h);
        Point centre = r.getCentre();

        //Вычитаем из каждой точки точку центра (переносим центр треугольника в начало координат)
        this.p1.subtraction(centre);
        this.p2.subtraction(centre);

        //Умножаем координаты на коэффициент
        this.p1.setCoords(this.p1.getX() * coeff, this.p1.getY() * coeff);
        this.p2.setCoords(this.p2.getX() * coeff, this.p2.getY() * coeff);
        this.h = h * coeff;

        //Возвращаем центр треугольника на прежнее место (до масштабирования)
        this.p1.addition(centre);
        this.p2.addition(centre);
    }

    //Получение 4 точек
    public ArrayList<Point> get4Points ()
    {
        //Расчет обычного вектора
        Vector2 a = new Vector2 (this.p1, this.p2);

        a=a.normal(a);
        a.multiplication(this.h);
        //Объявляем список точек рамером 4 [0...3]
        ArrayList<Point> list = new ArrayList<>(3);

        //Делаем обход по вершинам
        list.add(this.p1.pointPlusVector(a));
        list.add(this.p1.pointMinusVector(a));
        list.add(this.p2.pointPlusVector(a));
        list.add(this.p2.pointMinusVector(a));

        return list;
    }

    //Получение диагонали
    public double getDiagonal ()
    {
        Rectangle r = new Rectangle(this.p1, this.p2, this.h);
        //Получаем 4 точки прямоугольника
        ArrayList<Point> list = r.get4Points();
        //Берем из них де противоположные, считаем вектор
        Vector2 a = new Vector2 (list.get(0), list.get(3));
        return a.length();
    }

    //Получение высоты
    public double getHeight ()
    {
        return h * 2.0;
    }

    //Получение ширины
    public double getWidth ()
    {
        Vector2 a = new Vector2 (this.p1, this.p2);
        return a.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(h, rectangle.h) == 0 && Objects.equals(p1, rectangle.p1) && Objects.equals(p2, rectangle.p2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2, h);
    }
}