package ru.courses.test;

import ru.courses.geometry.Line;
import ru.courses.geometry.Point;
import ru.courses.geometry.PolyLine;

public class TestPolyLine {
    public static void main(String[] args) {
        System.out.println("=== Basic PolyLine test ===");
        testBasicFunctionality();
        
        System.out.println("\n=== Testing equals and hashCode ===");
        testEqualsAndHashCode();
    }
    
    private static void testBasicFunctionality() {
        // 1) Создаём ломаную через указанные точки
        PolyLine pl = new PolyLine(
                new Point(1, 5),
                new Point(2, 8),
                new Point(5, 3),
                new Point(8, 9)
        );

        System.out.println("Ломаная: " + pl);

        // 2) Рассчитываем длину ломаной
        double lenPl = pl.getLength();
        System.out.println("Полная длина ломаной: " + lenPl);

        // 3) Получаем массив линий
        Line[] segments = pl.getLines();

        // 4) Рассчитываем суммарную длину массива линий
        double sumSeg = 0;
        for (Line segment : segments) {
            sumSeg += segment.getLength();
        }
        System.out.println("Сумма длин сегментов: " + sumSeg);

        // 5) Сравниваем – должны совпасть
        System.out.println("Длины ломаной и массива линий совпадают? " + (lenPl == sumSeg));

        // 6) Меняем точку {2;8} → {12;8}
        pl.points[1].x = 12;

        // Изменения отразились в данной точке, в Ломаной и в двух Линиях массива
        System.out.println("После изменения точки:");
        System.out.println("Ломаная: " + pl);
        System.out.println("Сегмент 0: " + segments[0]);
        System.out.println("Сегмент 1: " + segments[1]);
    }
    
    private static void testEqualsAndHashCode() {
        // Создаем ломанные для тестирования
        PolyLine poly1 = new PolyLine(
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2)
        );
        
        PolyLine poly2 = new PolyLine(
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2)
        );
        
        PolyLine poly3 = new PolyLine(
                new Point(0, 0),
                new Point(1, 1),
                new Point(3, 3) // другая последняя точка
        );
        
        PolyLine poly4 = new PolyLine(
                new Point(0, 0),
                new Point(1, 1) // меньше точек
        );
        
        System.out.println("poly1: " + poly1);
        System.out.println("poly2: " + poly2);
        System.out.println("poly3: " + poly3);
        System.out.println("poly4: " + poly4);
        
        // Тестирование equals
        System.out.println("\nТестирование equals:");
        System.out.println("poly1.equals(poly2): " + poly1.equals(poly2)); // true - все точки совпадают
        System.out.println("poly1.equals(poly3): " + poly1.equals(poly3)); // false - разные последние точки
        System.out.println("poly1.equals(poly4): " + poly1.equals(poly4)); // false - разное количество точек
        System.out.println("poly1 == poly2: " + (poly1 == poly2)); // false - разные объекты
        System.out.println("poly1.equals(null): " + poly1.equals(null)); // false
        
        // Тестирование hashCode
        System.out.println("\nТестирование hashCode:");
        System.out.println("poly1.hashCode(): " + poly1.hashCode());
        System.out.println("poly2.hashCode(): " + poly2.hashCode());
        System.out.println("Одинаковые объекты имеют одинаковый hashCode: " + (poly1.hashCode() == poly2.hashCode()));
        System.out.println("poly3.hashCode(): " + poly3.hashCode());
        
        // Тестирование с пустой ломанной
        PolyLine emptyPoly1 = new PolyLine();
        PolyLine emptyPoly2 = new PolyLine();
        System.out.println("\nТестирование пустых ломанных:");
        System.out.println("emptyPoly1.equals(emptyPoly2): " + emptyPoly1.equals(emptyPoly2)); // true
        System.out.println("emptyPoly1.hashCode() == emptyPoly2.hashCode(): " + (emptyPoly1.hashCode() == emptyPoly2.hashCode()));
    }
}
