package ru.courses.test;

import ru.courses.geometry.Line;
import ru.courses.geometry.Point;

public class TestLine {
    public static void main(String[] args) {
        System.out.println("=== Base test Line ===");
        testBasicFunctionality();
        
        System.out.println("\n=== Testing equals, hashCode and clone ===");
        testEqualsHashCodeClone();
    }
    
    private static void testBasicFunctionality() {
        // создаём три линии
        Line line1 = new Line(new Point(1, 3), new Point(5, 8));
        Line line2 = new Line(new Point(10, 11), new Point(15, 19));
        // line3 «делит» конец line1 и начало line2
        Line line3 = new Line(line1.end, line2.start);

        // 1) выводим line3
        System.out.println(line3);

        // 2) меняем координаты через публичные поля
        line3.start.x = 2;
        line3.start.y = 4;
        line3.end.x   = 6;
        line3.end.y   = 10;

        // 3) снова выводим line3
        System.out.println(line3);

        // 4) считаем и выводим суммарную длину трёх линий
        double total = line1.getLength()
                + line2.getLength()
                + line3.getLength();
        System.out.println("Суммарная длина: " + total);
    }
    
    private static void testEqualsHashCodeClone() {
        // Создаем линии для тестирования
        Line line1 = new Line(new Point(0, 0), new Point(3, 4));
        Line line2 = new Line(new Point(0, 0), new Point(3, 4)); // такая же линия
        Line line3 = new Line(new Point(1, 1), new Point(2, 2)); // другая линия
        
        System.out.println("line1: " + line1);
        System.out.println("line2: " + line2);
        System.out.println("line3: " + line3);
        
        // Тестирование equals
        System.out.println("\nТестирование equals:");
        System.out.println("line1.equals(line2): " + line1.equals(line2)); // true
        System.out.println("line1.equals(line3): " + line1.equals(line3)); // false
        System.out.println("line1 == line2: " + (line1 == line2)); // false
        System.out.println("line1.equals(null): " + line1.equals(null)); // false
        
        // Тестирование hashCode
        System.out.println("\nТестирование hashCode:");
        System.out.println("line1.hashCode(): " + line1.hashCode());
        System.out.println("line2.hashCode(): " + line2.hashCode());
        System.out.println("Одинаковые объекты имеют одинаковый hashCode: " + (line1.hashCode() == line2.hashCode()));
        
        // Тестирование clone (глубокое копирование)
        System.out.println("\nТестирование clone:");
        Line line1Clone = line1.clone();
        System.out.println("line1Clone: " + line1Clone);
        System.out.println("line1.equals(line1Clone): " + line1.equals(line1Clone)); // true
        System.out.println("line1 == line1Clone: " + (line1 == line1Clone)); // false
        
        // Проверка глубокого копирования
        System.out.println("\nПроверка глубокого копирования:");
        System.out.println("line1.start == line1Clone.start: " + (line1.start == line1Clone.start)); // false
        System.out.println("line1.end == line1Clone.end: " + (line1.end == line1Clone.end)); // false
        
        // Change clone and check independence
        line1Clone.start.x = 100;
        line1Clone.end.y = 200;
        System.out.println("После изменения клона:");
        System.out.println("line1: " + line1);
        System.out.println("line1Clone: " + line1Clone);
        System.out.println("line1.equals(line1Clone): " + line1.equals(line1Clone)); // false
    }
}
