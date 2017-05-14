package com.example.sanjay.linalgcalcnew;

/**
 * Created by Sanjay on 5/12/2017.
 */

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int den) {
        this.numerator = num;
        this.denominator = den;
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

    @Override
    public String toString()
    {
        if (this.denominator!=1)
        {
            return this.numerator + "/" + this.denominator;
        }
        else
        {
            return Integer.toString(this.numerator);
        }

    }
}
