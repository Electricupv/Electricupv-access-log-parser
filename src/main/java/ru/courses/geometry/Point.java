package ru.courses.geometry;

public class Point implements Cloneable {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }
    
    /**
     * Сравнивает две точки по их координатам
     * Точки считаются равными, если у них одинаковые координаты x и y
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }
    
    /**
     * Возвращает хеш-код точки на основе её координат
     */
    @Override
    public int hashCode() {
        return 31 * x + y;
    }
    
    /**
     * Создает копию точки с теми же координатами
     * @return новый объект Point с теми же координатами
     */
    @Override
    public Point clone() {
        return new Point(this.x, this.y);
    }
} 