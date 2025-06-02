package ru.courses.test;

import ru.courses.geometry.Point;

public class TestsPoint {

    public static void main(String[] args) {
        System.out.println("=== Тестирование класса Point ===\n");
        
        testBasicFunctionality();
        testEqualsHashCodeClone();
        testTwoPointClasses();
    }
    
    private static void testBasicFunctionality() {
        Point point1 = new Point(1, 3);
        Point point2 = new Point(1, 3);
        Point point3 = new Point(5, 8);

        System.out.println("Текстовое представление точек:");
        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);

        System.out.println("\nРезультаты сравнения ссылок:");
        System.out.println("point1 == point2: " + (point1 == point2));
        System.out.println("point2 == point3: " + (point2 == point3));
        System.out.println();
    }
    
    private static void testEqualsHashCodeClone() {
        Point point1 = new Point(1, 3);
        Point point2 = new Point(1, 3);
        Point point3 = new Point(5, 8);
        
        // Тестирование equals
        System.out.println("Тестирование equals:");
        System.out.println("point1.equals(point2): " + point1.equals(point2));
        System.out.println("point1.equals(point3): " + point1.equals(point3));
        System.out.println("point1.equals(null): " + point1.equals(null));
        
        // Тестирование hashCode
        System.out.println("\nТестирование hashCode:");
        System.out.println("point1.hashCode(): " + point1.hashCode());
        System.out.println("point2.hashCode(): " + point2.hashCode());
        System.out.println("Одинаковые объекты имеют одинаковый hashCode: " + (point1.hashCode() == point2.hashCode()));
        
        // Тестирование clone
        System.out.println("\nТестирование clone:");
        Point point1Clone = point1.clone();
        System.out.println("point1Clone: " + point1Clone);
        System.out.println("point1.equals(point1Clone): " + point1.equals(point1Clone));
        System.out.println("point1 == point1Clone: " + (point1 == point1Clone));
        
        // Проверка независимости клона
        point1Clone.x = 10;
        System.out.println("После изменения клона:");
        System.out.println("point1: " + point1);
        System.out.println("point1Clone: " + point1Clone);
        System.out.println();
    }
    
    private static void testTwoPointClasses() {
        System.out.println("Демонстрация двух классов Point:");
        
        // Наш Point из ru.courses.geometry
        Point ourPoint = new Point(5, 10);
        
        // Point из java.awt
        java.awt.Point awtPoint = new java.awt.Point(15, 20);
        
        System.out.println("Наш Point: " + ourPoint);
        System.out.println("java.awt.Point: " + awtPoint);
        
        System.out.println("Разные форматы toString:");
        System.out.println("Наш Point: " + ourPoint.toString());
        System.out.println("java.awt.Point: " + awtPoint.toString());
    }
}
