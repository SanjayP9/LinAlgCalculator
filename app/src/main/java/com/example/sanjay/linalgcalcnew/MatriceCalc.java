package com.example.sanjay.linalgcalcnew;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Sanjay on 5/12/2017.
 * MarticieCalc.java contains all matrices calculations
 */

public class MatriceCalc {

    public enum MatriceOperations {
        Add,
        Subtract,
        Multiply,
        ScalarMultiply,
        Determinant,
        Adjugate,
        Cofactor,
        Inverse
    }

    private MatriceCalc() {

    }

    // Transposes a given matrixResult of fractions.
    public static Fraction[][] transpose(Fraction[][] m) {
        Fraction[][] result = new Fraction[m[0].length][m.length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                result[j][i] = m[i][j];
            }
        }
        return result;
    }

    public static Fraction[][] add(Fraction[][] m1, Fraction[][] m2) {
        Fraction[][] resultMatrix = new Fraction[m1.length][m1[0].length];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                resultMatrix[i][j] = Fraction.multiply(m1[i][j], m2[i][j]);
            }
        }
        return resultMatrix;
    }

    public static Fraction[][] subtract(Fraction[][] m1, Fraction[][] m2) {
        return add(m1, scalarMultiply(m2, new Fraction(-1, 1)));
    }

    public static Fraction[][] scalarMultiply(Fraction[][] m, Fraction scalar) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = Fraction.multiply(m[i][j], scalar);
            }
        }
        return m;
    }

    public static Fraction[][] multiply(Fraction[][] m1, Fraction[][] m2) {
        Fraction[][] result = new Fraction[m1.length][m2[0].length];

        for (int k = 0; k < m2[0].length; k++) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    result[i][k] = Fraction.add(result[i][k], Fraction.multiply(m1[i][j], m2[j][k]));
                }
            }
        }

        return result;
    }

    public static Fraction determinant(Fraction[][] m) {
        if (m.length == 2) {
            return Fraction.subtract(Fraction.multiply(m[0][0], m[1][1]), Fraction.multiply(m[0][1], m[1][0]));
        } else {

            Fraction det = new Fraction();

            for (int i = 0; i < m.length; i++) {
                det = Fraction.add(det, Fraction.multiply(determinant(trimMatrix(m, i, 0)),
                        Fraction.scalarMultiply(m[0][i], ((int) Math.pow((-1), i + 2)))));
            }
            return det;
        }
    }

    public static Fraction[][] cofactor(Fraction[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {

            }
        }

        return null;
    }

    public static Fraction[][] adjugate(Fraction[][] m) {
        Fraction[][] result = new Fraction[m.length][m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                result[i][j] = Fraction.scalarMultiply(determinant(trimMatrix(m, j, i)),
                        (int) (Math.pow(-1, i + j + 2)));
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
        return scalarMultiply(adjugate(m), Fraction.reciprocal(determinant(m)));
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

    // Returns a matrix in row-echelon form using Gaussian Elimination
    public static Fraction[][] rowEchelon(Fraction[][] m) {
        // TODO: Make it actually reduced row echelon, this is row echelon
        Fraction[][] reducedMatrix = new Fraction[m.length][m[0].length];

        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[row].length; col++) {
                reducedMatrix[row][col] = new Fraction(m[row][col]);
            }
        }

        int lead = 0;
        for (int r = 0; r < m.length; r++) {
            if (m[0].length <= lead) { break; }
            int i = r;

            while (m[i][lead].getDecimal() == 0) {
                i++;
                if (i == m.length) {
                    i = r;
                    lead++;
                    if (m[0].length == lead) {
                        lead--;
                        break;
                    }
                }
            }

            for (int j = 0; j < m[0].length; j++) {
                Fraction temp = reducedMatrix[r][j];
                reducedMatrix[r][j] = reducedMatrix[i][j];
                reducedMatrix[i][j] = temp;
            }

            Fraction div = reducedMatrix[r][lead];

            if (div.getDecimal() != 0) {
                for (int j = 0; j < m[0].length; j++) {
                    reducedMatrix[r][j] = Fraction.divide(reducedMatrix[r][j], div);
                }
            }

            for (int j = 0; j < m.length; j++) {
                if (j != r) {
                    Fraction sub = reducedMatrix[j][lead];
                    for (int k = 0; k < m[0].length; k++) {
                        reducedMatrix[j][k] = Fraction.subtract(reducedMatrix[j][k],
                                Fraction.multiply(reducedMatrix[r][k], sub));
                    }
                }
            }
            lead++;
        }
        return reducedMatrix;
    }

    // Returns a matrix in reduced row-echelon using Gaussian Elimination
    public static Fraction[][] reducedRowEchelon(Fraction[][] m) {
        Fraction[][] reducedMatrix;

        reducedMatrix = new Fraction[m.length][m[0].length];

        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[row].length; col++) {
                reducedMatrix[row][col] = new Fraction(m[row][col]);
            }
        }

        for (int r = 0; r < m.length; r++) {
            Fraction k = reducedMatrix[r][r];
            for (int c = 0; c < m[0].length; c++) {
                reducedMatrix[r][c] = Fraction.divide(reducedMatrix[r][c], k);
            }

            for (int i = 0; i < m.length; i++) {
                if (i != r) {
                    Fraction f = reducedMatrix[i][r];
                    for (int j = 0; j < m[0].length; j++) {
                        reducedMatrix[i][j] = Fraction.subtract(reducedMatrix[i][j],
                                Fraction.multiply(reducedMatrix[r][j], f));
                    }
                }
            }
        }
        return reducedMatrix;
    }
}