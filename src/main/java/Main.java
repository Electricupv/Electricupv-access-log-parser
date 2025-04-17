public class Main {
//Поиск первого значения. Дана следующая сигнатура метода:
//public static int findFirst(int[] arr, int x);
//Необходимо реализовать метод таким образом, чтобы он возвращал индекс первого вхождения числа x в массив arr. Если число не входит в массив – возвращается -1.

    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

//Поиск последнего значения. Дана следующая сигнатура метода:
//public static int findLast(int[] arr, int x);
//Необходимо реализовать метод таким образом, чтобы он возвращал индекс последнего вхождения числа x в массив arr. Если число не входит в массив – возвращается -1.

    public static int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

//Поиск максимального. Дана следующая сигнатура метода:
//public static int maxAbs(int[] arr);
//Необходимо реализовать метод таким образом, чтобы он возвращал наибольшее по модулю (то есть без учета знака) значение массива arr.

    public static int maxAbs(int[] arr) {
        int maxAbs = Math.abs(arr[0]);
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int abs = Math.abs(arr[i]);
            if (abs > maxAbs) {
                maxAbs = abs;
                result = arr[i];
            }
        }
        return result;
    }

//Подсчет позитива. Дана следующая сигнатура метода:
//public static int countPositive(int[] arr);
//Необходимо реализовать метод таким образом, чтобы он возвращал количество положительных элементов массива arr.

    public static int countPositive(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num > 0) {
                count++;
            }
        }
        return count;
    }

//Палиндром. Дана следующая сигнатура метода:
//public static boolean palindrom(int[] arr);
//Необходимо реализовать метод таким образом, чтобы он возвращал true, если массив arr является палиндромом, то есть справа-налево и наоборот читается одинаково

    public static boolean palindrom(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

//Реверс. Дана следующая сигнатура метода:
//public static void reverse(int[] arr);
//Необходимо реализовать метод таким образом, чтобы он изменял массив arr. После проведенных изменений массив должен быть записан задом-наперед

    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

////Возвратный реверс. Дана следующая сигнатура метода:
//public static int[] reverseBack(int[] arr);
//Необходимо реализовать метод таким образом, чтобы он возвращал новый массив, в котором значения массива arr записаны задом наперед.

    public static int[] reverseBack(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

//Объединение. Дана следующая сигнатура метода:
//public static int[] concat(int[] arr1, int[] arr2);
//Необходимо реализовать метод таким образом, чтобы он возвращал новый массив, в котором сначала идут элементы первого массива (arr1), а затем второго (arr2).

    public static int[] concat(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }
        return result;
    }

//Все вхождения. Дана следующая сигнатура метода:
//public static int[] findAll(int[] arr, int x);
//Необходимо реализовать метод таким образом, чтобы он возвращал новый массив, в котором записаны индексы всех вхождений числа x в массив arr.

    public static int[] findAll(int[] arr, int x) {
        // Считаем количество вхождений x в массив
        int count = 0;
        for (int num : arr) {
            if (num == x) {
                count++;
            }
        }
        // Создаем массив для индексов
        int[] result = new int[count];
        int index = 0;
        // Добавляем индексы в новый массив
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result[index++] = i;
            }
        }

        return result;
    }

//Удалить негатив. Дана следующая сигнатура метода:
//public static int[] deleteNegative(int[] arr);
//Необходимо реализовать метод таким образом, чтобы он возвращал новый массив, в котором записаны все элементы массива arr кроме отрицательных.

    public static int[] deleteNegative(int[] arr) {
        // Считаем количество неотрицательных элементов
        int count = 0;
        for (int num : arr) {
            if (num >= 0) {
                count++;
            }
        }
        // Создаем новый массив для неотрицательных элементов
        int[] result = new int[count];
        int index = 0;
        // Добавляем неотрицательные элементы в новый массив
        for (int num : arr) {
            if (num >= 0) {
                result[index++] = num;
            }
        }
        return result;
    }

//Добавление в массив. Дана следующая сигнатура метода:
//public static int[] add(int[] arr, int x, int pos);
//Необходимо реализовать метод таким образом, чтобы он возвращал новый массив, который будет содержать все элементы массива arr, однако в позицию pos будет вставлено значение x.

    public static int[] add(int[] arr, int x, int pos) {
        // Проверяем корректность позиции
        if (pos < 0 || pos > arr.length) {
            throw new IllegalArgumentException("Invalid position");
        }
        // Создаем новый массив, размер которого на 1 больше, чем у исходного
        int[] result = new int[arr.length + 1];
        // Копируем элементы до позиции pos
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        // Вставляем элемент x в позицию pos
        result[pos] = x;
        // Копируем элементы после позиции pos
        for (int i = pos; i < arr.length; i++) {
            result[i + 1] = arr[i];
        }
        return result;
    }

//Добавление массива в массив. Дана следующая сигнатура метода:
//public static int[] add(int[] arr, int[] ins, int pos);
//Необходимо реализовать метод таким образом, чтобы он возвращал новый массив, который будет содержать все элементы массива arr, однако в позицию pos будут вставлены значения массива ins.

    public static int[] add(int[] arr, int[] ins, int pos) {
        // Проверяем корректность позиции
        if (pos < 0 || pos > arr.length) {
            throw new IllegalArgumentException("Invalid position");
        }
        // Создаем новый массив, размер которого равен длине arr + длине ins
        int[] result = new int[arr.length + ins.length];
        // Копируем элементы до позиции pos
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        // Вставляем элементы из массива ins
        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }
        // Копируем оставшиеся элементы массива arr после позиции pos
        for (int i = pos; i < arr.length; i++) {
            result[ins.length + i] = arr[i];
        }
        return result;
    }

}