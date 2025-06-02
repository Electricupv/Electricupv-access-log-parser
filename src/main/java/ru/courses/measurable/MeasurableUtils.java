package ru.courses.measurable;

public class MeasurableUtils {
    
    public static double getTotalLength(Measurable[] measurables) {
        double totalLength = 0;
        for (Measurable measurable : measurables) {
            totalLength += measurable.getLength();
        }
        return totalLength;
    }
    
    public static void printInfo(Measurable[] measurables) {
        for (int i = 0; i < measurables.length; i++) {
            System.out.println((i + 1) + ". " + measurables[i] + " (длина: " + measurables[i].getLength() + ")");
        }
        System.out.println("Общая длина: " + getTotalLength(measurables));
    }
} 