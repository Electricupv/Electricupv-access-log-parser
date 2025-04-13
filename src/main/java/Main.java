import java.util.Scanner;

public class Main {

//Необходимо реализовать метод таким образом, чтобы он возвращал только дробную часть числа х.
//При выводе результата необходимо обеспечить точность вычислений — три знака после запятой Подсказка: вещественное число
//может быть преобразовано к целому путем отбрасывания дробной части.
/*
    public static void main(String[] args) {
        System.out.println("Дробная часть");
        System.out.printf("%.3f%n", fraction(8.54));
        System.out.printf("%.3f%n", fraction(3));
        System.out.printf("%.3f%n", fraction(6.87987));
    }

    public static double fraction(double x) {
        double fractionalPart = x - (long) x;
        return Math.round(fractionalPart * 1000) / 1000.0;
    }

//Сумма знаков. Дана следующая сигнатура метода:
//public static int sumLastNums(int x);
//Необходимо реализовать метод таким образом, чтобы он возвращал результат сложения двух последних знаков числа х, предполагая, что знаков в числе не менее двух. Подсказки:

        public static void main(String[] args) {
            System.out.println(sumLastNums(4568));
            System.out.println(sumLastNums(90));
            System.out.println(sumLastNums(101));
        }

        public static int sumLastNums(int x) {
            int lastDigit = x % 10;
            int secondLastDigit = (x / 10) % 10;
            return lastDigit + secondLastDigit;
        }


//Букву в число. Дана следующая сигнатура метода:
//public static int charToNum(char x);
//Метод принимает символ х, который представляет собой один из “0 1 2 3 4 5 6 7 8 9”. Необходимо реализовать метод таким образом, чтобы он преобразовывал символ в соответствующее число. При реализации метода не использовать методы класса Character. Подсказка: код символа ‘0’ — это число 48

    public static void main(String[] args) {
        char x = '8';
        System.out.println("Букву в число");
        System.out.println(charToNum(x));
    }

    public static int charToNum(char x) {
        return x - '0';
    }

//Есть ли позитив. Дана следующая сигнатура метода:
//public static boolean isPositive(int x);
//Необходимо реализовать метод таким образом, чтобы он принимал число x и возвращал true если оно положительное.

    public static void main(String[] args) {
        System.out.println("Есть ли позитив");
        System.out.println(isPositive(3));
        System.out.println(isPositive(-5));
        System.out.println(isPositive(0));
    }

    public static boolean isPositive(int x) {
        return x > 0;
    }

//Двузначное. Дана следующая сигнатура метода:
//public static boolean is2Digits(int x);
//Необходимо реализовать метод таким образом, чтобы он принимал положительное число x и возвращал true если оно двузначное.

    public static void main(String[] args) {
        System.out.println("Двузначное");
        System.out.println(is2Digits(32));
        System.out.println(is2Digits(516));
        System.out.println(is2Digits(9));
    }

    public static boolean is2Digits(int x) {
        return x >= 10 && x < 100;
    }

//Большая буква. Дана следующая сигнатура метода:
//public static boolean isUpperCase(char x);
//Необходимо реализовать метод таким образом, чтобы он принимал символ x и возвращал true если это большая буква в диапазоне от ‘A’ до ‘Z’. При реализации метода не использовать методы класса Character.

    public static void main(String[] args) {
        System.out.println("Большая буква");
        System.out.println(isUpperCase('D'));
        System.out.println(isUpperCase('q'));
    }

    public static boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }

//Диапазон. Дана следующая сигнатура метода:
//public static boolean isInRange(int a, int b, int num);
//Метод принимает левую и правую границу [a и b] некоторого числового диапазона. Необходимо реализовать метод таким образом, чтобы он возвращал true, если num входит в указанный диапазон (включая границы). Обратите внимание, что отношение a и b заранее неизвестно (неясно кто из них больше, а кто меньше)

    public static void main(String[] args) {
        System.out.println("Диапазон");
        System.out.println(isInRange(5, 1, 3));
        System.out.println(isInRange(2, 15, 33));
        System.out.println(isInRange(10, 20, 15));
    }

    public static boolean isInRange(int a, int b, int num) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return num >= min && num <= max;
    }

//Делитель. Дана следующая сигнатура метода:
//public static boolean isDivisor (int a, int b);
//Необходимо реализовать метод таким образом, чтобы он возвращал true если любое из принятых чисел делит другое нацело.

    public static void main(String[] args) {
        System.out.println("Делитель");
        System.out.println(isDivisor(3, 6));
        System.out.println(isDivisor(2, 15));
    }

    public static boolean isDivisor(int a, int b) {
        return (a != 0 && b % a == 0) || (b != 0 && a % b == 0);
    }

//Равенство. Дана следующая сигнатура метода:
//public static boolean isEqual (int a, int b, int c);
//Необходимо реализовать метод таким образом, чтобы он возвращал true если все три полученных методом числа равны

    public static void main(String[] args) {
        System.out.println("Равенство");
        System.out.println(isEqual(3, 3, 3));
        System.out.println(isEqual(2, 15, 2));
    }

    public static boolean isEqual(int a, int b, int c) {
        return a == b && b == c;
    }


//Многократный вызов. Дан следующий метод:
//public static int lastNumSum(int a, int b){
 //       return (a%10)+(b%10);
 //   }

//Выполните с его помощью последовательное сложение пяти чисел: 5, 11, 123, 14, 1, и результат выведите на экран. Постарайтесь выполнить задачу, используя минимально возможное количество вспомогательных переменных.
// Ответом на данное задание является код метода main, в котором происходит вызов данной функции.
/* Решение выполняется в таком порядке:
            5+11 это 6
            6+123 это 9
            9+14 это 13
            13+1 это 4
    Итого 4
*/

    public static void main(String[] args) {
        System.out.println("Многократный вызов");
        int result = lastNumSum(5, 11);    // 5+11 = 6
        result = lastNumSum(result, 123);  // 6+123 = 9
        result = lastNumSum(result, 14);   // 9+14 = 13
        result = lastNumSum(result, 1);    // 13+1 = 4
        System.out.println(result);        // Вывод: 4
    }

    public static int lastNumSum(int a, int b) {
        return (a % 10) + (b % 10);
    }

}




