package com.example.sanjay.linalgcalcnew;

/**
 * Created by Sanjay on 5/12/2017.
 */

public class MatricieCalc {
    FractionCalc frac;

    public MatricieCalc() {
        frac = new FractionCalc();
    }

    public Fraction[][] transpose(Fraction[][] m) {
        Fraction[][] result = new Fraction[m[0].length][m.length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                result[i][j] = m[j][i];
            }
        }
        return result;
    }

    public Fraction[][] add(Fraction[][] m1, Fraction[][] m2) {
        Fraction[][] resultMatrix = new Fraction[m1.length][m1[0].length];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                resultMatrix[i][j] = frac.multiply(m1[i][j], m2[i][j]);
            }
        }
        return resultMatrix;
    }

    public Fraction[][] subtract(Fraction[][] m1, Fraction[][] m2) {
        return add(m1, scalarMultiply(m2, new Fraction(-1, 1)));
    }

    public Fraction[][] scalarMultiply(Fraction[][] m, Fraction scalar) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = frac.multiply(m[i][j], scalar);
            }
        }
        return m;
    }

    public Fraction[][] multiplyColumn(Fraction[][] m1, Fraction[] m2) {
        Fraction[][] result = new Fraction[m1.length][ m2.length];


    }
}