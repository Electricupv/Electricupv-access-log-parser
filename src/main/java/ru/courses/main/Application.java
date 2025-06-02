package ru.courses.main;

import ru.courses.geometry.*;
import ru.courses.measurable.*;
import ru.courses.numbers.*;
import ru.courses.geometry.Point; // Наш Point доступен по простому имени
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Application {
    
    public static void main(String[] args) {
        if (args.length == 2) {
            System.out.println("=== Возведение в степень ===");
            double result = powerFromStrings(args[0], args[1]);
            System.out.println(args[0] + " в степени " + args[1] + " = " + result);
            System.out.println();
        }
        
        System.out.println("=== Демонстрация двух классов Point ===");
        demonstratePointClasses();
        
        System.out.println("\n=== Демонстрация всех задач ===\n");
        
        // Демонстрация полиморфизма с Measurable
        System.out.println("1. Полиморфизм с интерфейсом Measurable:");
        demonstrateMeasurable();
        
        System.out.println("\n2. Fraction как подтип Number:");
        demonstrateFractionAsNumber();
        
        System.out.println("\n3. Задания по сложению:");
        demonstrateSpecificSums();
    }
    
    /**
     * Демонстрирует работу с двумя разными классами Point
     */
    private static void demonstratePointClasses() {
        // Наш Point из ru.courses.geometry (доступен по простому имени)
        Point ourPoint = new Point(5, 10);
        
        // Point из java.awt (используем полное имя)
        java.awt.Point awtPoint = new java.awt.Point(15, 20);
        
        System.out.println("Наш Point из ru.courses.geometry: " + ourPoint);
        System.out.println("Координаты: x=" + ourPoint.x + ", y=" + ourPoint.y);
        
        System.out.println("Point из java.awt: " + awtPoint);
        System.out.println("Координаты: x=" + awtPoint.x + ", y=" + awtPoint.y);
        
        // Демонстрируем различия в функциональности
        System.out.println("Наш Point использует формат: " + ourPoint.toString());
        System.out.println("java.awt.Point использует формат: " + awtPoint.toString());
    }
    
    /**
     * Возводит число X в степень Y, где X и Y переданы как строки
     * @param xStr строка с числом X
     * @param yStr строка с числом Y
     * @return результат X^Y
     */
    public static double powerFromStrings(String xStr, String yStr) {
        int x = parseInt(xStr);
        int y = parseInt(yStr);
        return pow(x, y);
    }
    
    private static void demonstrateMeasurable() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 0);
        Point p3 = new Point(3, 4);
        Point p4 = new Point(0, 4);
        
        Line line = new Line(p1, p2);
        PolyLine polyLine = new PolyLine(p1, p2, p3, p4);
        ClosedPolyLine closedPolyLine = new ClosedPolyLine(p1, p2, p3, p4);
        
        Measurable[] measurables = {line, polyLine, closedPolyLine};
        MeasurableUtils.printInfo(measurables);
        
        System.out.println("Обычная ломаная: " + polyLine + " (длина: " + polyLine.getLength() + ")");
        System.out.println("Замкнутая ломаная: " + closedPolyLine + " (длина: " + closedPolyLine.getLength() + ")");
    }
    
    private static void demonstrateFractionAsNumber() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 4);
        
        Number[] numbers = {f1, f2, 5, 2.5};
        
        for (Number num : numbers) {
            System.out.println(num.getClass().getSimpleName() + ": " + num + " = " + num.doubleValue());
        }
        
        double sum = 0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        System.out.println("Общая сумма: " + sum);
    }
    
    private static void demonstrateSpecificSums() {
        // Задание 1: 2 + 3/5 + 2.3
        Fraction threeFifths = new Fraction(3, 5);
        double result1 = NumberUtils.sumAll(2, threeFifths, 2.3);
        System.out.println("Задание 1: 2 + 3/5 + 2.3 = " + result1);
        
        // Задание 2: 3.6 + 49/12 + 3 + 3/2
        Fraction fortyNineTwelfths = new Fraction(49, 12);
        Fraction threeHalves = new Fraction(3, 2);
        double result2 = NumberUtils.sumAll(3.6, fortyNineTwelfths, 3, threeHalves);
        System.out.println("Задание 2: 3.6 + 49/12 + 3 + 3/2 = " + result2);
        
        // Задание 3: 1/3 + 1
        Fraction oneThird = new Fraction(1, 3);
        double result3 = NumberUtils.sumAll(oneThird, 1);
        System.out.println("Задание 3: 1/3 + 1 = " + result3);
    }
} 