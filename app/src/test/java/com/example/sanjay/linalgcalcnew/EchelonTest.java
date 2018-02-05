package com.example.sanjay.linalgcalcnew;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Mark on 2018-02-01.
 */

public class EchelonTest {

    @Test
    public void reducedRowEchelonTest() {
        Fraction[][] matrix = new Fraction[][] {
                {new Fraction(3), new Fraction(2), new Fraction(-4), new Fraction(3)},
                {new Fraction(2), new Fraction(3), new Fraction(3), new Fraction(15)},
                {new Fraction(5), new Fraction(-3), new Fraction(1), new Fraction(14)},
        };

        Fraction[][] reduced = MatriceCalc.rowEchelon(matrix);

        Matrix m = new Matrix("test", reduced.length, reduced[0].length, reduced);

        System.out.println(m.toString());

        Fraction[][] expected = new Fraction[][] {
                {new Fraction(1), new Fraction(0), new Fraction(0), new Fraction(3)},
                {new Fraction(0), new Fraction(1), new Fraction(0), new Fraction(1)},
                {new Fraction(0), new Fraction(0), new Fraction(1), new Fraction(2)},
        };

        for (int row = 0; row < expected.length; row++) {
            for (int col = 0; col < expected[0].length; col++) {
                assertEquals(reduced[row][col].getDecimal(), expected[row][col].getDecimal());
            }
        }
    }

    @Test
    public void reducedRowEchelonTest2() {
        Fraction[][] matrix = new Fraction[][] {
                {new Fraction(3), new Fraction(2), new Fraction(-4), new Fraction(3)},
                {new Fraction(2), new Fraction(3), new Fraction(3), new Fraction(15)},
                {new Fraction(5), new Fraction(-3), new Fraction(1), new Fraction(14)},
        };

        Fraction[][] reduced = MatriceCalc.reducedRowEchelon(matrix);

        Matrix m = new Matrix("test", reduced.length, reduced[0].length, reduced);

        System.out.println(m.toString());

        Fraction[][] expected = new Fraction[][] {
                {new Fraction(1), new Fraction(0), new Fraction(0), new Fraction(3)},
                {new Fraction(0), new Fraction(1), new Fraction(0), new Fraction(1)},
                {new Fraction(0), new Fraction(0), new Fraction(1), new Fraction(2)},
        };

        for (int row = 0; row < expected.length; row++) {
            for (int col = 0; col < expected[0].length; col++) {
                assertEquals(reduced[row][col].getDecimal(), expected[row][col].getDecimal());
            }
        }
    }
}
