package com.example.sanjay.linalgcalcnew;

/**
 * Created by Sanjay on 5/12/2017.
 */

public class Fraction {
    private int numerator;
    private int denominator;
    private boolean numRoot;
    private boolean denRoot;

    public Fraction() {
        this(0, 1);
    }

    public Fraction(int num) {
        this(num, 1);
    }

    public Fraction(int num, int den) {
        this.numerator = num;
        this.denominator = den;
    }

    public Fraction(int num, int den, boolean numRoot, boolean denRoot) {
        this.numerator = num;
        this.denominator = den;
        this.numRoot = numRoot;
        this.denRoot = denRoot;
    }

    public Fraction(Fraction fraction) {
        this(fraction.getNumerator(), fraction.getDenominator(), fraction.isNumRoot(), fraction.isDenRoot());
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public boolean isNumRoot() {
        return numRoot;
    }

    public void setNumRoot(boolean numRoot) {
        this.numRoot = numRoot;
    }

    public boolean isDenRoot() {
        return denRoot;
    }

    public void setDenRoot(boolean denRoot) {
        this.denRoot = denRoot;
    }

    public double getDecimal() {
        return (this.numerator * 1.0d) / (this.denominator * 1.0d);
    }


    // Adds 2 fractions
    public static Fraction add(Fraction frac1, Fraction frac2) {

        return simplifyFraction(new Fraction(frac1.getNumerator() * frac2.getDenominator() +
                frac2.getNumerator() * frac1.getDenominator(),
                frac1.getDenominator() * frac2.getDenominator()));

    }

    // Subtracts 2 fractions using add() and scalarMultiply()
    public static Fraction subtract(Fraction frac1, Fraction frac2) {
        return add(frac1, scalarMultiply(frac2, -1));
    }

    // Multiplies the numerator and denominator of 2 fractions then puts it in lowest terms
    public static Fraction multiply(Fraction frac1, Fraction frac2) {

        return simplifyFraction(new Fraction(frac1.getNumerator() * frac2.getNumerator(),
                frac1.getDenominator() * frac2.getDenominator()));
    }

    // Multiplies fractions numerator by an integer then puts it in lowest terms
    public static Fraction scalarMultiply(Fraction frac, int scalar) {
        return simplifyFraction(new Fraction(frac.getNumerator() * scalar, frac.getDenominator()));
    }

    // Divides a fraction by another by getting reciprocal then multiplying
    public static Fraction divide(Fraction frac1, Fraction frac2) {
        return multiply(frac1, reciprocal(frac2));
    }

    // Switches numerator and denominator of a fraction
    public static Fraction reciprocal(Fraction frac) {
        return new Fraction(frac.getDenominator(), frac.getNumerator());
    }

    // Returns boolean based on if 2 fractions are equivalent by putting in lowest terms and comparing
    public static boolean equals(Fraction frac1, Fraction frac2) {
        frac1 = simplifyFraction(frac1);
        frac2 = simplifyFraction(frac2);

        if (frac1.getNumerator() == frac2.getNumerator()) {
            if ((frac1.getNumerator() == 0) || (frac1.getDenominator() == frac2.getDenominator())) {
                return true;
            }
        }
        return false;
    }

    // Returns simplified fraction by dividing the numerator and denominator by the
    // greatest common factor
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

    // Uses Euclidean's algorithm to find the greatest common factor
    // en.wikipedia.org/wiki/Euclidean_algorithm
    // **A is larger integer**
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


    @Override
    public String toString() {

        String result = "";

        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }

        if (this.numRoot) {
            result += "√" + this.numerator;
        } else {
            result += Integer.toString(this.numerator);
        }

        if (denominator != 1) {
            result += "/";

            if (this.denRoot) {
                result += "√" + this.denominator;
            } else {
                result += Integer.toString(this.denominator);
            }
        }
        return result;
    }
}
