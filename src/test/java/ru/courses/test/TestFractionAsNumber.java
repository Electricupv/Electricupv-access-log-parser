package ru.courses.test;

import ru.courses.numbers.Fraction;

/**
 * Тестовый класс для демонстрации работы Fraction как подтипа Number
 */
public class TestFractionAsNumber {
    
    public static void main(String[] args) {
        // Создаем Fraction объекты
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 4);
        
        // Создаем другие Number объекты
        int intNum = 5;
        double doubleNum = 2.5;
        
        // Демонстрация полиморфизма - массив Number объектов
        Number[] numbers = {f1, f2, intNum, doubleNum};
        
        System.out.println("=== Демонстрация Fraction как подтипа Number ===");
        for (Number num : numbers) {
            System.out.println(num.getClass().getSimpleName() + ": " + num + " = " + num.doubleValue());
        }
        
        // Сумма через Number интерфейс
        double sum = 0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        System.out.println("Общая сумма: " + sum);
    }
} 