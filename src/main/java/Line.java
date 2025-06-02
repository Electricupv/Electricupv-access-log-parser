public class Line implements Measurable {
    public Point start;
    public Point end;

    // Через две точки
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Длина по формуле гипотенузы
    public double getLength() {
        int dx = end.x - start.x;
        int dy = end.y - start.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    // "Линия от {X1;Y1} до {X2;Y2}"
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
