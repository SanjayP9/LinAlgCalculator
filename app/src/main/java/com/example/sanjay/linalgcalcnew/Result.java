package com.example.sanjay.linalgcalcnew;

/**
 * Created by Sanjay on 2/1/2018.
 */

public class Result extends Matrix {

    private Fraction constantResult;

    public Result(String name) {
        super(name)
    }

    public Result(String name, int row, int col, Fraction[][] matrix) {
        super(name, row, col, matrix);
    }

    public void calcResult(MatriceCalc.MatriceOperations operation, Matrix A, Matrix B) {
        switch (operation) {
            case Add:
                this.matrixResult = MatriceCalc.add(A.getMatrixResult(), B.getMatrixResult());
                break;
            case Adjugate:
                this.matrixResult = MatriceCalc.adjugate(A.getMatrixResult());
                break;
            case Cofactor:
                // this.matrixResult = MatriceCalc TODO: implement cofactor
                break;
            case Determinant:
                this.constantResult = MatriceCalc.determinant(A.getMatrixResult());
                break;
            case ScalarMultiply:
                this.matrixResult = MatriceCalc.scalarMultiply(A.getMatrixResult(), )
                break;
            case Inverse:
                this.matrixResult = MatriceCalc.inverse(A.getMatrixResult());
                break;
            case Multiply:
                break;
            case Subtract:
                break;
        }
    }
}