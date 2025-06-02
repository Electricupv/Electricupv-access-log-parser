package ru.courses.geometry;

import ru.courses.measurable.Measurable;

public class Line implements Measurable, Cloneable {
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
    
    /**
     * Сравнивает две линии по их начальной и конечной точкам
     * Линии считаются равными, если их начало и конец расположены в одинаковых точках
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Line line = (Line) obj;
        return start.equals(line.start) && end.equals(line.end);
    }
    
    /**
     * Возвращает хеш-код линии на основе её начальной и конечной точек
     */
    @Override
    public int hashCode() {
        return 31 * start.hashCode() + end.hashCode();
    }
    
    /**
     * Создает глубокую копию линии с новыми объектами точек
     * @return новый объект Line с клонированными точками
     */
    @Override
    public Line clone() {
        return new Line(start.clone(), end.clone());
    }
} 