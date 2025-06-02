public class Start2 {
    public static void main(String[] args) {
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
}
