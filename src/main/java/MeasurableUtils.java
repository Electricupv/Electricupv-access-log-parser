/**
 * Утилитный класс для работы с объектами, реализующими интерфейс Measurable
 */
public class MeasurableUtils {
    
    /**
     * Вычисляет общую длину всех объектов в массиве
     * @param measurables массив объектов, реализующих Measurable
     * @return суммарная длина всех объектов
     */
    public static double getTotalLength(Measurable[] measurables) {
        double totalLength = 0;
        for (Measurable measurable : measurables) {
            totalLength += measurable.getLength();
        }
        return totalLength;
    }
    
    /**
     * Выводит информацию о каждом объекте и общую длину
     * @param measurables массив объектов, реализующих Measurable
     */
    public static void printInfo(Measurable[] measurables) {
        for (int i = 0; i < measurables.length; i++) {
            System.out.println((i + 1) + ". " + measurables[i] + " (длина: " + measurables[i].getLength() + ")");
        }
        System.out.println("Общая длина: " + getTotalLength(measurables));
    }
} 