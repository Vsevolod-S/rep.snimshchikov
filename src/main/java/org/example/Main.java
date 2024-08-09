package org.example;
import java.util.ArrayList;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Point a = new Point(-2, 2);
        Point b = new Point(2, 1);
        Point c = new Point(1, 7);



        System.out.println("окружность");
        Circle c1 = new Circle(a, 1.0);
        c1.moving(new Point(5, 5));
        c1.printCircle();
    }
}