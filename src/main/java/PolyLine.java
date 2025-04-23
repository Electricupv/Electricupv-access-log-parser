public class PolyLine {
    public Point[] points;

    // Можно создать пустую ломаную
    public PolyLine() {
        this.points = new Point[0];
    }

    // Можно сразу указать набор точек
    public PolyLine(Point... points) {
        this.points = points;
    }

    // Текстовое представление: "Линия [T1,T2,…,TN]"
    public String toString() {
        String res = "polyLine [";
        for (int i = 0; i < points.length; i++) {
            res += points[i];
            if (i < points.length - 1) {
                res += ",";
            }
        }
        res += "]";
        return res;
    }

    // Массив сегментов-линий между соседними точками
    public Line[] getLines() {
        if (points.length < 2) {
            return new Line[0];
        }
        Line[] lines = new Line[points.length - 1];
        for (int i = 0; i < points.length - 1; i++) {
            lines[i] = new Line(points[i], points[i+1]);
        }
        return lines;
    }

    // Суммарная длина всех сегментов
    public double getLength() {
        double sum = 0;
        Line[] ls = getLines();
        for (int i = 0; i < ls.length; i++) {
            sum += ls[i].getLength();
        }
        return sum;
    }
}
