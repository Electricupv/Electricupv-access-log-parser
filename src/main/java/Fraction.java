public final class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("Denominator must be positive");
        }

        int sign = numerator < 0 ? -1 : 1;
        int absNumerator = Math.abs(numerator);
        int gcd = gcd(absNumerator, denominator);
        this.numerator = sign * (absNumerator / gcd);
        this.denominator = denominator / gcd;
    }

    private Fraction(int numerator, int denominator, boolean normalized) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fraction sum(Fraction other) {
        int num = this.numerator * other.denominator + this.denominator * other.numerator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den);
    }

    public Fraction sum(int value) {
        // value = value/1
        int num = this.numerator + value * this.denominator;
        int den = this.denominator;
        return new Fraction(num, den);
    }

    public Fraction minus(Fraction other) {
        int num = this.numerator * other.denominator - this.denominator * other.numerator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den);
    }

    public Fraction minus(int value) {
        int num = this.numerator - value * this.denominator;
        int den = this.denominator;
        return new Fraction(num, den);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 3);    // 1/3
        Fraction f2 = new Fraction(2, 5);    // 2/5
        Fraction f3 = new Fraction(7, 8);    // 7/8

        Fraction result = f1.sum(f2).sum(f3).minus(5);

        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);
        System.out.println("Result of f1.sum(f2).sum(f3).minus(5) = " + result);
    }
}