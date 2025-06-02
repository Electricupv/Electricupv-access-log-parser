public class ClosedPolyLine extends PolyLine {

    // Конструктор с точками
    public ClosedPolyLine(Point... points) {
        super(points);
    }
    
    // Переопределяем getLines() чтобы добавить замыкающий сегмент
    @Override
    public Line[] getLines() {
        if (points.length < 2) {
            return new Line[0];
        }
        
        // Получаем обычные сегменты от родительского класса
        Line[] parentLines = super.getLines();
        
        // Создаем новый массив с дополнительным сегментом
        Line[] lines = new Line[parentLines.length + 1];
        
        // Копируем существующие сегменты
        System.arraycopy(parentLines, 0, lines, 0, parentLines.length);
        
        // Добавляем замыкающий сегмент от последней точки к первой
        lines[lines.length - 1] = new Line(points[points.length - 1], points[0]);
        
        return lines;
    }
    
    // Переопределяем getLength() переиспользуя код родительского класса
    @Override
    public double getLength() {
        if (points.length < 2) {
            return 0;
        }
        
        // Получаем длину обычной ломаной от родительского класса
        double parentLength = super.getLength();
        
        // Добавляем длину замыкающего сегмента от последней точки к первой
        Line closingSegment = new Line(points[points.length - 1], points[0]);
        
        return parentLength + closingSegment.getLength();
    }
    
    // Переопределяем toString() для более точного описания
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("closedPolyLine [");
        for (int i = 0; i < points.length; i++) {
            res.append(points[i]);
            if (i < points.length - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
} 