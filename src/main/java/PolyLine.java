public class PolyLine implements Measurable {
    public Point[] points;
    // Можно сразу указать набор точек
    public PolyLine(Point... points) {
        this.points = points;
    }

    // Текстовое представление: "Линия [T1,T2,…,TN]"
    public String toString() {
        StringBuilder resBuilder = new StringBuilder("polyLine [");
        for (int i = 0; i < points.length; i++) {
            resBuilder.append(points[i]);
            if (i < points.length - 1) {
                resBuilder.append(",");
            }
        }
        String res = resBuilder.toString();
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
        for (Line l : ls) {
            sum += l.getLength();
        }
        return sum;
    }
}
