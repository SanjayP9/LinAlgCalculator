package com.example.sanjay.linalgcalcnew;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Sanjay on 5/12/2017.
 */

public class FractionCalc {

    //Remove static after done testing

    public FractionCalc() {
    }

    public static Fraction add(Fraction frac1, Fraction frac2) {

        return simplifyFraction(new Fraction(frac1.getNumerator() * frac2.getDenominator() +
                frac2.getNumerator() * frac1.getDenominator(),
                frac1.getDenominator() * frac2.getDenominator()));

    }

    public static Fraction subtract(Fraction frac1, Fraction frac2) {
        return add(frac1, scalarMultiply(frac2, -1));
    }

    public static Fraction multiply(Fraction frac1, Fraction frac2) {

        return simplifyFraction(new Fraction(frac1.getNumerator() * frac2.getNumerator(),
                frac1.getDenominator() * frac2.getDenominator()));

    }

    public static Fraction scalarMultiply(Fraction frac, int scalar) {
        return simplifyFraction(new Fraction(frac.getNumerator() * scalar, frac.getDenominator()));
    }

    public static Fraction divide(Fraction frac1, Fraction frac2) {
        return multiply(frac1, reciprocal(frac2));
    }

    public static Fraction reciprocal(Fraction frac) {
        return new Fraction(frac.getDenominator(), frac.getNumerator());
    }

    public boolean equals(Fraction frac1, Fraction frac2)
    {
        frac1 = simplifyFraction(frac1);
        frac2 = simplifyFraction(frac2);

        if (frac1.getNumerator()==frac2.getNumerator()) {
            if ((frac1.getNumerator() == 0) || (frac1.getDenominator() == frac2.getDenominator()))
            {
                return true;
            }
        }
        return false;
    }

    public static Fraction simplifyFraction(Fraction frac) {
        if (frac.getNumerator() == frac.getDenominator()) {
            return new Fraction(1, 1);
        }

        if (frac.getNumerator() == 0) {
            return new Fraction();
        } else if (frac.getDenominator() == 1) {
            return frac;
        }

        int gcf = getGcf(frac.getNumerator(), frac.getDenominator());

        return new Fraction(frac.getNumerator() / gcf, frac.getDenominator() / gcf);
    }

    // A is larger integer
    private static Tuple findRemainder(int A, int B) {
        int temp = A;
        int count = 0;

        while (temp > 0) {
            temp -= B;
            if (temp >= 0) {
                count++;
            }
        }

        return new Tuple(count, A - (count * B));
    }

    // A = q * B + r
    private static int euc(int A, int B, int depthCount) {
        Tuple temp = findRemainder(A, B);

        if (temp.getRemainder() == 0) {
            return B;
        } else if (depthCount >= 200) {
            return 1;
        }

        depthCount++;
        return euc(B, temp.getRemainder(), depthCount);
    }

    public static int getGcf(int A, int B) {

        if (A == 0 || B == 0) {
            return 1;
        }

        int result = 1;
        boolean isNegative = false;

        if (A < 0 || B < 0) {
            isNegative = true;
        }

        if (!(Math.abs(A) == 1 || Math.abs(B) == 1)) {
            if (A > B) {
                result = euc(Math.abs(A), Math.abs(B), 0);
            } else {
                result = euc(Math.abs(B), Math.abs(A), 0);
            }
        }

        if (isNegative) {
            return -1 * result;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        /*Random rand = new Random();
        Fraction frac;
        FractionCalc calc = new FractionCalc();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            frac = new Fraction(rand.nextInt(10000), rand.nextInt(10000));

            if (rand.nextInt(2) == 1) {
                frac.setNumerator(frac.getNumerator() * -1);
            }

            System.out.println(frac.toString() + "\t\t" + calc.simplifyFraction(frac).toString());

            scanner.nextLine();
        }*/
    }
}
