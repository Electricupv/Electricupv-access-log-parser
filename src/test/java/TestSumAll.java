/**
 * Тестовый класс для выполнения конкретных заданий по сложению
 * Задания из "Практика ООП. Полиморфизм #6. Сложение"
 */
public class TestSumAll {
    
    public static void main(String[] args) {
        System.out.println("=== Выполнение заданий по сложению ===\n");
        
        // Задание 1: 2 + 3/5 + 2.3
        Fraction threeFifths = new Fraction(3, 5);
        double result1 = NumberUtils.sumAll(2, threeFifths, 2.3);
        System.out.println("Задание 1: 2 + 3/5 + 2.3 = " + result1);
        
        // Задание 2: 3.6 + 49/12 + 3 + 3/2
        Fraction fortyNineTwelfths = new Fraction(49, 12);
        Fraction threeHalves = new Fraction(3, 2);
        double result2 = NumberUtils.sumAll(3.6, fortyNineTwelfths, 3, threeHalves);
        System.out.println("Задание 2: 3.6 + 49/12 + 3 + 3/2 = " + result2);
        
        // Задание 3: 1/3 + 1
        Fraction oneThird = new Fraction(1, 3);
        double result3 = NumberUtils.sumAll(oneThird, 1);
        System.out.println("Задание 3: 1/3 + 1 = " + result3);
    }
} 