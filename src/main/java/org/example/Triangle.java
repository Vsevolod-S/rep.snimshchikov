package org.example;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Objects;

public class Triangle implements Figure {
    //объявляем точки треугольника
    private Point p1;
    private Point p2;
    private Point p3;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(p1, triangle.p1) && Objects.equals(p2, triangle.p2) && Objects.equals(p3, triangle.p3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2, p3);
    }

    //конструктор по умолчанию
    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

        Vector2 v1 = new Vector2(p2, p1);
        Vector2 v2 = new Vector2(p3, p2);
        Vector2 v3 = new Vector2(p1, p3);
        double len1 = v1.length();
        double len2 = v2.length();
        double len3 = v3.length();
        checkingExistenceTriangle(len1, len2, len3);
    }

    public static void checkingExistenceTriangle(double a, double b, double c) {
        if (a + b >= c) {
            if (a + c >= b)
                if (b + c >= a) {
                    //Решил не уведомлять о положительном исходе.
                    //Оставил только негативный сценарий
                    //System.out.println("Треугольник существует.");
                }
        }
        else {
            System.out.println("Треуголник не существует!");
        }
    }

    //Печать координат треугольника
    public void printTriangle() {
        p1.printCoords();
        p2.printCoords();
        p3.printCoords();
    }

    //Расчет периметра
    public double perimeter() {
        //Объявляем вектора (входные параметры: точка начала, точка конца)
        Vector2 a = new Vector2(this.p1, this.p2);
        Vector2 b = new Vector2(this.p2, this.p3);
        Vector2 c = new Vector2(this.p3, this.p1);
        return a.length() + b.length() + c.length();
    }

    //Расчет площади
    public double square() {
        return 1.0 / 2.0 * Math.abs((p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p3.getX() - p1.getX()) * (p2.getY() - p1.getY()));
    }

    //Вращение
    //радианы * Math.PI/180 = градусы
    public void rotation(double angle) {
        Triangle t = new Triangle(this.p1, this.p2, this.p3);

        //Расчет центра
        Point centre = t.getCentre();

        //Вычитаем из каждой точки точку центра (переносим центр треугольника в начало координат)
        this.p1.subtraction(centre);
        this.p2.subtraction(centre);
        this.p3.subtraction(centre);

        //Вращаем треугольник относительно начала координат
        this.p1 = p1.rotationNewPositionOfPoint(angle);
        this.p2 = p2.rotationNewPositionOfPoint(angle);
        this.p3 = p3.rotationNewPositionOfPoint(angle);

        //Возвращаем центр треугольника на прежнее место (до вращения)
        this.p1.addition(centre);
        this.p2.addition(centre);
        this.p3.addition(centre);
    }

    //Перемещение
    public void moving(Point newCentre) {
        Triangle t = new Triangle(this.p1, this.p2, this.p3);

        //Расчет разности между старым и новым центром (результат храним в newCentre)
        newCentre.subtraction(t.getCentre());

        //Добавление разности между центрами (само перемещение)
        this.p1.addition(newCentre);
        this.p2.addition(newCentre);
        this.p3.addition(newCentre);
    }

    //Масштабирование
    public void scaling(double coeff) {
        Triangle t = new Triangle(this.p1, this.p2, this.p3);
        Point centre = t.getCentre();

        //Вычитаем из каждой точки точку центра (переносим центр треугольника в начало координат)
        this.p1.subtraction(centre);
        this.p2.subtraction(centre);
        this.p3.subtraction(centre);

        //Умножаем координаты на коэффициент
        this.p1.setCoords(this.p1.getX() * coeff, this.p1.getY() * coeff);
        this.p2.setCoords(this.p2.getX() * coeff, this.p2.getY() * coeff);
        this.p3.setCoords(this.p3.getX() * coeff, this.p3.getY() * coeff);

        //Возвращаем центр треугольника на прежнее место (до масштабирования)
        this.p1.addition(centre);
        this.p2.addition(centre);
        this.p3.addition(centre);
    }

    //Расчет центра фигуры
    public Point getCentre() {
        return new Point((p1.getX() + p2.getX() + p3.getX()) / 3.0, (p1.getY() + p2.getY() + p3.getY()) / 3.0);
    }

    //Получение 3 точек
    public ArrayList<Point> get3Points() {
        //Объявляем список точек рамером 3 [0...2]
        ArrayList<Point> list = new ArrayList<>(2);

        //Суем вершины в список
        list.add(this.p1);
        list.add(this.p2);
        list.add(this.p3);

        return list;
    }

    //Описанная окружность
    public Circle getOuterCircle() {
        double x_12 = this.p1.getX() - this.p2.getX();
        double y_12 = this.p1.getY() - this.p2.getY();
        double x_23 = this.p2.getX() - this.p3.getX();
        double y_23 = this.p2.getY() - this.p3.getY();
        ;
        double x_31 = this.p3.getX() - this.p1.getX();
        double y_31 = this.p3.getY() - this.p1.getY();
        double z_1 = Math.pow(this.p1.getX(), 2) + Math.pow(this.p1.getY(), 2);
        double z_2 = Math.pow(this.p2.getX(), 2) + Math.pow(this.p2.getY(), 2);
        double z_3 = Math.pow(this.p3.getX(), 2) + Math.pow(this.p3.getY(), 2);
        double z_x = y_12 * z_3 + y_23 * z_1 + y_31 * z_2;
        double z_y = x_12 * z_3 + x_23 * z_1 + x_31 * z_2;
        double z = x_12 * y_31 - y_12 * x_31;
        Point centre = new Point(-z_x / (2.0 * z), z_y / (2.0 * z));
        Vector2 r = new Vector2(centre, this.p1);
        return new Circle(centre, r.length());
    }

    //Вписанная окружность
    public Circle getInnerCircle() {
        Triangle t = new Triangle(this.p1, this.p2, this.p3);
        double r = t.square() / (t.perimeter() / 2.0);
        Vector2 a = new Vector2(p2, p3);
        Vector2 b = new Vector2(p3, p1);
        Vector2 c = new Vector2(p1, p2);
        double x = (a.length() * p1.getX() + b.length() * p2.getX() + c.length() * p3.getX()) / (a.length() + b.length() + c.length());
        double y = (a.length() * p1.getY() + b.length() * p2.getY() + c.length() * p3.getY()) / (a.length() + b.length() + c.length());
        Point centre = new Point(x, y);
        return new Circle(centre, r);
    }

}