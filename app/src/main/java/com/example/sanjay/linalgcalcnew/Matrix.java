package com.example.sanjay.linalgcalcnew;

/**
 * Created by Sanjay on 12/28/2017.
 */

public class Matrix {

    private int rowNum;
    private int colNum;
    private Fraction[][] matrix;
    private boolean isResult = false;


    public Matrix() {
        this.rowNum = 0;
        this.colNum = 0;
    }

    public Matrix(int row, int col, boolean isResult) {
        if (row <= 0 || row >= 6 || col <= 0 || col >= 6) {
            throw new IllegalArgumentException();
        } else {
            this.rowNum = row;
            this.colNum = col;
        }
    }

    public Matrix(int row, int col, boolean isResult, Fraction[][] matrix) {
        this(row, col, isResult);
        this.matrix = matrix;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    public Fraction[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Fraction[][] matrix) {
        this.matrix = matrix;
    }

    public boolean getIsResult() {
        return isResult;
    }

    public void setResult(boolean result) {
        isResult = result;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result += matrix[i][j].toString() + "\t";
            }
            result += "\n";
        }
        return result;
    }
}
