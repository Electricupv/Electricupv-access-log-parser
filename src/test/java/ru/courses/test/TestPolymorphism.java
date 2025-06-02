package ru.courses.test; /**
 * Тестовый класс для демонстрации полиморфизма с интерфейсом Measurable
 */
import ru.courses.geometry.*;
import ru.courses.measurable.*;

public class TestPolymorphism {
    public static void main(String[] args) {
        // Создаем точки для тестирования
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 0);
        Point p3 = new Point(3, 4);
        Point p4 = new Point(0, 4);
        
        // Создаем объекты, реализующие Measurable
        Line line = new Line(p1, p2);
        PolyLine polyLine = new PolyLine(p1, p2, p3, p4);
        ClosedPolyLine closedPolyLine = new ClosedPolyLine(p1, p2, p3, p4);
        
        // Создаем массив объектов Measurable
        Measurable[] measurables = {line, polyLine, closedPolyLine};
        
        // Используем полиморфизм - вызываем методы через общий интерфейс
        System.out.println("=== Демонстрация полиморфизма с Measurable ===");
        MeasurableUtils.printInfo(measurables);
        
        System.out.println("\n=== Сравнение обычной и замкнутой ломаной ===");
        System.out.println("Обычная ломаная: " + polyLine + " (длина: " + polyLine.getLength() + ")");
        System.out.println("Замкнутая ломаная: " + closedPolyLine + " (длина: " + closedPolyLine.getLength() + ")");
    }
} 