public class Line {
    public Point start;
    public Point end;

    // Через две точки
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Через четыре числа
    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end   = new Point(x2, y2);
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
