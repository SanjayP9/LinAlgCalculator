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

    public Fraction[][] scalarMultiply(Fraction[][] m, Fraction scalar) {
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
            Fraction ratio;
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m.length; j++) {
                    if (j > i) {
                        ratio = frac.divide(m[j][i], m[i][i]);

                        for (int n = 0; n < m.length; n++) {
                            m[j][n] = frac.subtract(m[j][n], frac.multiply(ratio, m[i][n]));
                        }
                    }
                }
            }

            Fraction det = new Fraction(1, 1);

            for (int i = 0; i < m.length; i++) {
                if (m[i][i].getNumerator() == 0) {
                    return new Fraction();
                }
                det = frac.multiply(det, m[i][i]);
            }

            return det;
        }
    }

    public Fraction[][] adjugate(Fraction[][] m)
    {
        Fraction[][] result = new Fraction[m.length][m[0].length];

        for (int i =0; i < m.length;i++ )
        {
            for (int j= 0; j< m[0].length;j++)
            {

            }
        }

        return transpose(result);
    }

    private static Fraction[][] trimArray(Fraction[][] m, int x1, int x2, int y1, int y2, int currX, int currY) {
        List<List<Fraction>> trimmedList = new ArrayList<>();

        for (int i = x1; i <= x2; i++) {
            ArrayList<Fraction> temp = new ArrayList<>();

            for (int j = y1; j <= y2; j++) {
                if (j != currX && i != currY) {
                   temp.add(m[i][j]);
                }
            }
            if(!(temp.isEmpty())) {
                trimmedList.add(temp);
            }
        }

        Fraction[][] trimmedArray = new Fraction[trimmedList.size()][trimmedList.get(0).size()];

        for (int i =0 ;i < trimmedList.size();i++)
        {
            trimmedArray[i] = trimmedList.get(i).toArray(trimmedArray[i]);
        }

        return trimmedArray;
    }


    public static void main(String[] args) {
        Random rand = new Random();

        Fraction[][] matrix = new Fraction[5][5];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = new Fraction(rand.nextInt(11), 1);
            }
        }


       /* Fraction[][] m1 = new Fraction[][]{
                {new Fraction(1, 1), new Fraction(2, 1), new Fraction(3, 1)},
                {new Fraction(4, 1), new Fraction(5, 1), new Fraction(6, 1)},
                {new Fraction(4, 1), new Fraction(5, 1), new Fraction(6, 1)}
        };

        Fraction[][] m2 = new Fraction[][]{
                {new Fraction(1, 1), new Fraction(2, 1)},
                {new Fraction(3, 1), new Fraction(1, 1)}
        };*/

        Fraction[][] result = trimArray(matrix, 1, 4, 1, 4, 3, 2);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j].toString() + "\t");
            }
            System.out.println();
        }


        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j].toString() + "\t");
            }
            System.out.println();
        }


    }
}