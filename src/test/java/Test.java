public class Test {

    @org.junit.Test
    public void test1() {
        System.out.println(Main.listNums(5));
    }

    @org.junit.Test
    public void test2() {
        System.out.println(Main.reverseListNums(5));
    }

    @org.junit.Test
    public void test3() {
        System.out.println(Main.chet(9));
    }

    @org.junit.Test
    public void test4() {
        System.out.println(Main.chet(9));
    }

    @org.junit.Test
    public void test5() {
        System.out.println(Main.numLen(12567));
    }

    @org.junit.Test
    public void test6() {
        System.out.println(Main.equalNum(1111));
        System.out.println(Main.equalNum(1211));
    }

    @org.junit.Test
    public void test7() {
        Main.square(2);
        System.out.println();

        Main.square(4);
    }

    @org.junit.Test
    public void test8() {
        Main.leftTriangle(2);
        System.out.println();

        Main.leftTriangle(4);
    }

    @org.junit.Test
    public void test9() {
        Main.rightTriangle(3);
        System.out.println();

        Main.rightTriangle(4);
    }

}
