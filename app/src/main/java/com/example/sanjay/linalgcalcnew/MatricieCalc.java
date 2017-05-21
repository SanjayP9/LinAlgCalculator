package com.example.sanjay.linalgcalcnew;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Sanjay on 5/12/2017.
 */

public class MatricieCalc {
    private static FractionCalc frac;

    public MatricieCalc() {
        frac = new FractionCalc();
    }

    public static Fraction[][] transpose(Fraction[][] m) {
        Fraction[][] result = new Fraction[m[0].length][m.length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                result[j][i] = m[i][j];
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

    public static Fraction[][] scalarMultiply(Fraction[][] m, Fraction scalar) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = frac.multiply(m[i][j], scalar);
            }
        }
        return m;
    }

    public static Fraction[][] multiply(Fraction[][] m1, Fraction[][] m2) {
        Fraction[][] result = new Fraction[m1.length][m2[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = new Fraction();
            }
        }

        for (int k = 0; k < m2[0].length; k++) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    result[i][k] = frac.add(result[i][k], frac.multiply(m1[i][j], m2[j][k]));
                }
            }
        }

        return result;
    }

    public static Fraction determinant(Fraction[][] m) {
        if (m.length == 2) {
            return frac.subtract(frac.multiply(m[0][0], m[1][1]), frac.multiply(m[0][1], m[1][0]));
        } else {

            Fraction det = new Fraction();

            for (int i = 0; i < m.length; i++)
            {
                det = frac.add(det,frac.multiply(determinant(trimMatrix(m, i,0)), frac.scalarMultiply(m[0][i],((int)Math.pow((-1),i+2)))));
            }

            return det;
        }
    }

    public static Fraction[][] adjugate(Fraction[][] m) {
        Fraction[][] result = new Fraction[m.length][m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                result[i][j] = frac.scalarMultiply(determinant(trimMatrix(m, j, i)), (int) (Math.pow(-1, i + j + 2)));
            }
        }
        return transpose(result);
    }

    private static Fraction[][] trimMatrix(Fraction[][] m, int currX, int currY) {
        List<List<Fraction>> trimmedList = new ArrayList<>();

        for (int i = 0; i < m.length; i++) {
            ArrayList<Fraction> temp = new ArrayList<>();

            for (int j = 0; j < m[0].length; j++) {
                if (j != currX && i != currY) {
                    temp.add(m[i][j]);
                }
            }
            if (!(temp.isEmpty())) {
                trimmedList.add(temp);
            }
        }

        Fraction[][] trimmedArray = new Fraction[trimmedList.size()][trimmedList.get(0).size()];

        for (int i = 0; i < trimmedList.size(); i++) {
            trimmedArray[i] = trimmedList.get(i).toArray(trimmedArray[i]);
        }

        return trimmedArray;
    }

    public static Fraction[][] inverse(Fraction[][] m) {
        return scalarMultiply(adjugate(m), frac.reciprocal(determinant(m)));
    }

    private static Fraction[][] genMatrix(int size) {
        Random rand = new Random();
        Fraction[][] matrix = new Fraction[size][size];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = new Fraction(rand.nextInt(11), 1);
            }
        }

        return matrix;
    }

    private static void displayMatrix(Fraction[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j].toString() + "\t");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        Fraction[][] m1 = new Fraction[][]{
                {new Fraction(6), new Fraction(8), new Fraction(4), new Fraction(9)},
                {new Fraction(3), new Fraction(6), new Fraction(0), new Fraction(0)},
                {new Fraction(5), new Fraction(10), new Fraction(2), new Fraction(9)},
                {new Fraction(1), new Fraction(0), new Fraction(10), new Fraction(1)}
        };

        displayMatrix(m1);
        System.out.println("\nAdjugate");

        displayMatrix(adjugate(m1));

        System.out.println("\nInverse");

        displayMatrix(inverse(m1));
        System.out.println("\nDeterminant");

        Fraction result = determinant(m1);
        System.out.println(result.toString());

    }
}