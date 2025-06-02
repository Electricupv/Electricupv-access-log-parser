package ru.courses.test;

import ru.courses.geometry.Line;
import ru.courses.geometry.Point;

public class TestLine {
    public static void main(String[] args) {
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
}
