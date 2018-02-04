package com.example.sanjay.linalgcalcnew;

/**
 * Created by Sanjay on 12/28/2017.
 */

public class Matrix {

    protected String name;
    private int rowNum;
    private int colNum;
    protected Fraction[][] matrixResult;

    public Matrix(String name) {
        this.name = name;
    }

    public Matrix(String name, int row, int col, Fraction[][] matrix) {
        this(name);

        setRowNum(row);
        setColNum(col);
        setMatrixResult(matrix);
    }

    public int getRowNum() {
        return rowNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRowNum(int rowNum) {

        if (rowNum <= 1 || rowNum >= 6) {

            throw new IllegalArgumentException();
        } else {
            this.rowNum = rowNum;
        }
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {

        if (colNum <= 1 || colNum >= 6) {
            throw new IllegalArgumentException();
        } else {
            this.colNum = colNum;
        }
    }

    public Fraction[][] getMatrixResult() {
        return matrixResult;
    }

    public void setMatrixResult(Fraction[][] matrixResult) {
        this.matrixResult = matrixResult;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < matrixResult.length; i++) {

            //result += (i == (matrixResult.length / 2)) ? (this.name + " = ") : ("\t");

            for (int j = 0; j < matrixResult[0].length; j++) {
                result += "\t" + matrixResult[i][j].toString();
            }
            result += "\n";
        }
        return result;
    }

    /*public static void main(String[] args) {
        Fraction[][] m1 = new Fraction[][]{
                {new Fraction(6), new Fraction(8845), new Fraction(4), new Fraction(9)},
                {new Fraction(3544), new Fraction(6), new Fraction(5540), new Fraction(0)},
                {new Fraction(30), new Fraction(6), new Fraction(0), new Fraction(450)},
                {new Fraction(3), new Fraction(6), new Fraction(4540), new Fraction(0)},
                {new Fraction(5), new Fraction(10), new Fraction(4842), new Fraction(9)}
        };


        //Matrix temp = new Matrix()
    }*/
}
