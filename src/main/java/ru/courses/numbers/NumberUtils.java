package ru.courses.numbers;

public class NumberUtils {
    
    public static double sumAll(Number... numbers) {
        double sum = 0.0;
        for (Number number : numbers) {
            if (number != null) {
                sum += number.doubleValue();
            }
        }
        return sum;
    }
} 