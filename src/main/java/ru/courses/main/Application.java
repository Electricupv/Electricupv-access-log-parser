package ru.courses.main;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Application {
    
    public static void main(String[] args) {
        if (args.length == 2) {
            double result = powerFromStrings(args[0], args[1]);
            System.out.println(args[0] + " to the power of " + args[1] + " = " + result);
        } else {
            System.out.println("Usage: java Application <number> <power>");
        }
    }
    
    /**
     * Powers number X to power Y, where X and Y are passed as strings
     * @param xStr string with number X
     * @param yStr string with number Y
     * @return result X^Y
     */
    public static double powerFromStrings(String xStr, String yStr) {
        int x = parseInt(xStr);
        int y = parseInt(yStr);
        return pow(x, y);
    }
} 