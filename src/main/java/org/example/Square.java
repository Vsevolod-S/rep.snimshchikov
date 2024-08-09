package org.example;
import java.lang.Math;
import java.util.ArrayList;


public final class Square extends Rectangle{

    //конструктор по умолчанию
    public Square(Point p1, Point p2)
    {
        super(p1, p2, (Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) +Math.pow(p2.getY() - p1.getY(), 2)))/2.0);
    }

    //Печать квадрата
    public void printSquare()
    {
        super.p1.printCoords();
        super.p2.printCoords();
    }

    //Расчет периметра
    public double perimeter()
    {
        Vector2 a = new Vector2 (this.p1, this.p2);
        return a.length()*4.0;
    }

    //Расчет площади
    public double square()
    {
        Vector2 a = new Vector2 (this.p1, this.p2);
        return Math.pow(a.length(),2);
    }

    //Вращение
    public void rotation(double angle)
    {
        Square s = new Square(this.p1, this.p2);

        //Расчет центра
        Point centre = s.getCentre();

        //Вычитаем из каждой точки точку центра (переносим центр прямоугольника в начало координат)
        this.p1.subtraction(centre);
        this.p2.subtraction(centre);

        //Вращаем прямоугольник относительно начала координат
        this.p1 = this.p1.rotationNewPositionOfPoint(angle);
        this.p2 = this.p2.rotationNewPositionOfPoint(angle);

        //Возвращаем центр прямоугольника на прежнее место (до вращения)
        this.p1.addition(centre);
        this.p2.addition(centre);
    }

    //Перемещение
    public void moving(Point newCentre)
    {
        Square s = new Square(this.p1, this.p2);

        //Расчет разности между старым и новым центром (результат храним в newCentre)
        newCentre.subtraction(s.getCentre());

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
        Square s = new Square(this.p1, this.p2);
        Point centre = s.getCentre();

        //Вычитаем из каждой точки точку центра (переносим центр треугольника в начало координат)
        this.p1.subtraction(centre);
        this.p2.subtraction(centre);

        //Умножаем координаты на коэффициент
        this.p1.setCoords(this.p1.getX() * coeff, this.p1.getY() * coeff);
        this.p2.setCoords(this.p2.getX() * coeff, this.p2.getY() * coeff);

        //Возвращаем центр треугольника на прежнее место (до масштабирования)
        this.p1.addition(centre);
        this.p2.addition(centre);
    }

    //Получение 4 точек
    public ArrayList<Point> get4Points ()
    {
        //Расчет обычного вектора
        Vector2 a = new Vector2 (p1, p2);
        double len_a = a.length();
        a=a.normal(a);
        a.multiplication(len_a/2.0);
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
        Square s = new Square(this.p1, this.p2);
        //Получаем 4 точки прямоугольника
        ArrayList<Point> list = s.get4Points();
        //Берем из них де противоположные, считаем вектор
        Vector2 a = new Vector2 (list.get(0), list.get(3));
        return a.length();
    }

    //Получение стороны
    public double getSide ()
    {
        Vector2 a = new Vector2 (this.p1, this.p2);
        return a.length();
    }

    //Получение описанной окружности
    public Circle getOuterCircle()
    {
        Square s = new Square(this.p1, this.p2);
        return new Circle(s.getCentre(), s.getSide()/Math.sqrt(2.0));
    }

    //Получение вписанной окружности
    public Circle getInnerCircle()
    {
        Square s = new Square(this.p1, this.p2);
        return new Circle(s.getCentre(), s.getSide()/2.0);
    }
}
