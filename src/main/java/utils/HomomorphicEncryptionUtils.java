package utils;

import beans.Polynomial;
import beans.RationalPolynomial;
import beans.SecretKey;

import java.util.Random;

/**
 * Created by zajic on 09.04.17.
 */
public class HomomorphicEncryptionUtils {
    public static Polynomial getPolynomialFromIntWithBase(int value, int base) {
        String valueWithNewBase = Integer.toString(value, base);
        Polynomial polynomial = new Polynomial();
        char[] digits = valueWithNewBase.toCharArray();

        for (int degree = digits.length - 1, index = 0; degree >= 0; degree--, index++) {
            int coefficient = Integer.valueOf(String.valueOf(digits[index]));
            polynomial.withCoefficientAndDegree(coefficient, degree);
        }

        return polynomial;
    }

    public static int getRandomBase(int val1, int val2) {
        int max = Integer.max(val1, val2);
        Random rnd = new Random();
        if (max > 10) {
            return 2 + rnd.nextInt(8);
        } else {
            return max + rnd.nextInt(9 - max);
        }
    }

    public static Polynomial getPartRandomPolynomial(int degreeTwo) {
        Random rnd = new Random();
        int a = rnd.nextInt(100);
        int b = rnd.nextInt(100);

        return new Polynomial().withCoefficientAndDegree(a * a, 2 * degreeTwo).withCoefficientAndDegree(b * b, 0);
    }

    public static int positiveNumber(int bound) {
        int res = 0;
        Random rnd = new Random();

        while (res == 0) {
            res = rnd.nextInt(bound + 1);
//            System.out.println("bound: " + bound + " res: " + res);
        }

        return res;
    }

    public static SecretKey getRandomPolynomial(int degree, int base) {
        Random rnd = new Random();

        Polynomial randomPolynomial = Polynomial.ONE;
        if (degree % 2 == 0) degree = degree + 1;
        int degreeOne = degree - 1;

        while (degreeOne != 0) {
            int degreeTwo = positiveNumber(degreeOne / 2);
            randomPolynomial = randomPolynomial.multiply(getPartRandomPolynomial(degreeTwo));
            degreeOne = degreeOne - 2 * degreeTwo;
        }

        int a = rnd.nextInt(50);
        int b = rnd.nextInt(50);
        randomPolynomial = randomPolynomial.multiply(new Polynomial()
                .withCoefficientAndDegree(a, 1)
                .withCoefficientAndDegree(b, 0)).add(new Polynomial().withCoefficientAndDegree(base,0));

        SecretKey key = new SecretKey();
        key.setMappingPolynomial(randomPolynomial);
        key.setA(-a);
        key.setB(b);
        return key;
    }

    public static Polynomial polynomialNOK(Polynomial pol1, Polynomial pol2) {
        RationalPolynomial help;

        do {
            help = pol1.divide(pol2);
            //System.out.println("help: " + help.toString() + " pol1: " + pol1.toString() + " pol2: " + pol2.toString());
            pol1 = pol2;
            pol2 = help.getWholePart();
        } while (help.getReminder().toString().equals(Polynomial.ZERO.toString()));

        return pol1;
    }

    public static RationalPolynomial polynomialNOD(Polynomial pol1, Polynomial pol2) {
        Polynomial NOK;
        NOK = polynomialNOK(pol1, pol2);
        return pol1.multiply(pol2).divide(NOK);
    }

    public static void encode() {
        int opendata1 = 1234;
        int opendata2 = 4321;

        SecretKey secretKey = getRandomPolynomial(6, 9);

        Polynomial polynomFromOpenData1 = getPolynomialFromIntWithBase(opendata1, 9);
        Polynomial encodedOpenData1 = polynomFromOpenData1.mapWith(secretKey.getMappingPolynomial());

        Polynomial polynomFromOpenData2 = getPolynomialFromIntWithBase(opendata2, 9);
        Polynomial encodedOpenData2 = polynomFromOpenData2.mapWith(secretKey.getMappingPolynomial());

        long now = System.nanoTime();


        int a = 1111;
        for (int i = 0; i < 10000; i++) {
            a = a*a;
        }

        System.out.println(System.nanoTime() - now);
    }
}
