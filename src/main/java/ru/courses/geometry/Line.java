package ru.courses.geometry;

import ru.courses.measurable.Measurable;

public class Line implements Measurable {
    public Point start;
    public Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end   = new Point(x2, y2);
    }

    public double getLength() {
        int dx = end.x - start.x;
        int dy = end.y - start.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public String toString() {
        return "Линия от " + start + " до " + end;
    }
} 