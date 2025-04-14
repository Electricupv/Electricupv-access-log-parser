import org.junit.Test;

public class Tests {

    public static void main(String[] args) {
        System.out.println(Main.module(5));
        System.out.println(Main.module(-3));
        System.out.println(Main.module(0));
    }

@Test
    public void test2() {
        System.out.println(Main.safeDiv(5, 0));
        System.out.println(Main.safeDiv(8, 2));
    }

@Test
public void test3() {
    System.out.println(Main.max(5, 7));
    System.out.println(Main.max(8, -1));
}

@Test
public void test4() {
    System.out.println(Main.makeDecision(5, 7));
    System.out.println(Main.makeDecision(8, -1));
    System.out.println(Main.makeDecision(4, 4));
}

@Test
public void tes5() {
    System.out.println(Main.max3(5, 7, 7));
    System.out.println(Main.max3(8, -1, 4));
}

@Test
public void main() {
    // Пример 1:
    System.out.println(Main.sum3(5, 7, 2));
    // Пример 2:
    System.out.println(Main.sum3(8, -1, 4));
}

@Test
public void test7() {
    System.out.println(Main.sum2(5, 7));
    System.out.println(Main.sum2(8, -1));
}

@Test
public void test8() {
    System.out.println(Main.is35(5));
    System.out.println(Main.is35(8));
    System.out.println(Main.is35(15));
}

    @Test
    public void test9() {
        System.out.println(Main.magic6(5, 7));
        System.out.println(Main.magic6(8, 2));
        System.out.println(Main.magic6(1, 6));
    }

@Test
public void test10() {
    System.out.println(Main.age(5));
    System.out.println(Main.age(31));
    System.out.println(Main.age(44));

    System.out.println(Main.age(11));
    System.out.println(Main.age(22));
    System.out.println(Main.age(1));
}

@Test
public void test11() {
    System.out.println(Main.day(5));

    System.out.println(Main.day(1));
    System.out.println(Main.day(7));
    System.out.println(Main.day(8));
}

@Test
public void test12() {
    Main.printDays("четверг");
    System.out.println("-----");

    Main.printDays("чг");
    System.out.println("-----");

    Main.printDays("понедельник");
}
}
