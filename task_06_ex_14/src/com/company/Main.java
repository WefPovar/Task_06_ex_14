package com.company;

import java.util.Scanner;

public class Main {

   public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        double x = readX("x");
        double n = readN("n");
        double e = readE("e");

        double sum_n = calcSequenceOfN(x, n);
        double sum_e = calcSequenceOfE(x, n, e);
        double sum_e10 = calcSequenceOfE(x, n, e / 10);
        double sum = calcFunction(x);

        printResultsOfFunction(sum_n, sum_e, sum_e10, sum);
    }

    private static double readX(String letter) {
        System.out.printf("Input "+ letter + ":");
        double x = scanner.nextDouble();

        if (Math.abs(x) > 1) {
            System.out.println("'x' cannot be less than -1");
            System.exit(1);
        }
        return x;
    }

    private static double readN(String letter) {
        System.out.printf("Input "+ letter + ":");
        double n = scanner.nextDouble();

        if (n < 0) {
            System.out.println("'n' cannot be less than 0");
            System.exit(1);
        }
        return n;
    }

    private static double readE(String letter) {
        System.out.printf("Input "+ letter + ":");
        double e = scanner.nextDouble();

        if (e < 0) {
            System.out.println("'e' cannot be less than 0");
            System.exit(1);
        }
        return e;
    }

    private static double calcSequenceOfN(double x, double n) {
        double sum = 0;

        for (int i = 1; i <= n; i++) {
            double a = Math.pow(-1, i + 1) * Math.pow(x, i) / i;
            sum += a;
        }
        return sum;
    }

    private static double calcSequenceOfE(double x, double n, double e) {
        double sum = 0;

        for (int i = 1; i <= n; i++) {
            double a = Math.pow(-1, i + 1) * Math.pow(x, i) / i;

            if (Math.abs(a) > e) {
                sum += a;
            }
        }
        return sum;
    }

    private static double calcFunction(double x) {
        return Math.log(1 + x);
    }

    private static void printResultsOfFunction(double sum_n, double sum_e, double sum_e10, double sum) {
        System.out.println("The sum of 'n' variables is equal to " + sum_n);
        System.out.println("The sum of the numbers > e is equal to " + sum_e);
        System.out.println("The sum of the numbers > e/10 is equal to " + sum_e10);
        System.out.println("The result of function is equal to " + sum);
    }

}
