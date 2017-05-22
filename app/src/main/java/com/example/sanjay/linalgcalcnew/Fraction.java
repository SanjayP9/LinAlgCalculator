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
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(int num) {
        this.numerator = num;
        this.denominator = 1;
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
