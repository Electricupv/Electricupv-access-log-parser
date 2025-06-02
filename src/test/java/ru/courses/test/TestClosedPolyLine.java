package ru.courses.test;

import ru.courses.geometry.ClosedPolyLine;
import ru.courses.geometry.Line;
import ru.courses.geometry.Point;
import ru.courses.geometry.PolyLine;

public class TestClosedPolyLine {
    public static void main(String[] args) {
        // Создаем точки для тестирования
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 0);
        Point p3 = new Point(3, 4);
        Point p4 = new Point(0, 4);
        
        // Создаем обычную ломаную
        PolyLine polyLine = new PolyLine(p1, p2, p3, p4);
        System.out.println("Обычная ломаная: " + polyLine);
        System.out.println("Длина обычной ломаной: " + polyLine.getLength());
        
        // Создаем замкнутую ломанную с теми же точками
        ClosedPolyLine closedPolyLine = new ClosedPolyLine(p1, p2, p3, p4);
        System.out.println("\nЗамкнутая ломаная: " + closedPolyLine);
        System.out.println("Длина замкнутой ломаной: " + closedPolyLine.getLength());
        
        // Разница в длине должна равняться расстоянию от последней точки до первой
        Line closingSegment = new Line(p4, p1);
        System.out.println("\nДлина замыкающего сегмента: " + closingSegment.getLength());
        System.out.println("Разница в длинах: " + (closedPolyLine.getLength() - polyLine.getLength()));
        
        // Проверяем сегменты
        Line[] polyLines = polyLine.getLines();
        Line[] closedLines = closedPolyLine.getLines();
        
        System.out.println("\nСегменты обычной ломаной (" + polyLines.length + "):");
        for (Line line : polyLines) {
            System.out.println("  " + line);
        }
        
        System.out.println("\nСегменты замкнутой ломаной (" + closedLines.length + "):");
        for (Line closedLine : closedLines) {
            System.out.println("  " + closedLine);
        }
    }
} 