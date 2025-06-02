package ru.courses.test;

import ru.courses.geometry.Point;

public class TestsPoint {

    public static void main(String[] args) {
        Point point1 = new Point(1, 3);
        Point point2 = new Point(1, 3);
        Point point3 = new Point(5, 8);

        System.out.println("Текстовое представление точек:");
        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);

        System.out.println("\nРезультаты сравнения:");
        System.out.println("point1 == point2: " + (point1 == point2));
        System.out.println("point2 == point3: " + (point2 == point3));
    }


}
