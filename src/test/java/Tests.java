import org.junit.Test;

import java.util.Arrays;

public class Tests {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 2, 5};
        int result = Main.findFirst(arr, 2);
        System.out.println(result);
        System.out.println(Main.findFirst(arr, 9));
    }


@Test
    public void test2() {
        int[] arr = {1, 2, 3, 4, 2, 2, 5};
        int x = 2;
        int result = Main.findLast(arr, x);
        System.out.println("Результат: " + result);
    }

    @Test
    public  void test3() {
        int[] arr = {1, -2, -7, 4, 2, 2, 5};
        System.out.println(Main.maxAbs(arr));
    }
    @Test
    public void test4() {
        int[] arr = {1, -2, -7, 4, 2, 2, 5};
        System.out.println(Main.countPositive(arr));
    }

    @Test
    public void test5() {
        int[] arr1 = {1, -2, -7, 4, 2, 2, 5};
        System.out.println(Main.palindrom(arr1));

        int[] arr2 = {1, -2, -7, 4, -7, -2, 1};
        System.out.println(Main.palindrom(arr2));
    }

    @Test
    public void test6() {
        int[] arr = {1, 2, 3, 4, 5};
        Main.reverse(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    @Test
    public void test7() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] reversed = Main.reverseBack(arr);

        for (int num : reversed) {
            System.out.print(num + " ");
        }
    }

    @Test
    public void test8() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {7, 8, 9};
        int[] result = Main.concat(arr1, arr2);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    @Test
    public void test9() {
        int[] arr = {1, 2, 3, 8, 2, 2, 9};
        int x = 2;
        int[] result = Main.findAll(arr, x);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void test10() {
        int[] arr = {1, 2, -3, 4, -2, 2, -5};
        int[] result = Main.deleteNegative(arr);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void test11() {
        int[] arr = {1, 2, 3, 4, 5};
        int x = 9;
        int pos = 3;
        int[] result = Main.add(arr, x, pos);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void test12() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] ins = {7, 8, 9};
        int pos = 3;
        int[] result = Main.add(arr, ins, pos);
        System.out.println(Arrays.toString(result));
    }


}
