package com.example.sanjay.linalgcalcnew;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MatrixBlockAdapter extends ArrayAdapter<Matrix> {
    public static final int MATRIX_BLOCK = 0;
    public static final int RESULT_BLOCK = 1;


    Context context;
    int resource;
    ArrayList<Matrix> matrices = null;

    public MatrixBlockAdapter(Context context, int resource, ArrayList<Matrix> matrices) {
        super(context, resource, matrices);
        this.context = context;
        this.resource = resource;
        this.matrices = matrices;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Matrix m = matrices.get(position);


        switch (getItemViewType(position)) {
            case MATRIX_BLOCK:
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.matrix_block, parent, false);
                }

                ((TextView)(convertView.findViewById(R.id.titleText))).setText("Matrix " + this.matrices.get(position).getName());

                // set view
                if (this.matrices.get(position).getMatrixResult() != null) {
                    TableLayout matrixDisplay = (TableLayout) convertView.findViewById(R.id.tableLayout1);

                    fillTable(this.matrices.get(position).getMatrixResult(), matrixDisplay);
                }
                break;


            case RESULT_BLOCK:
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.m_result_block, parent, false);
                }
                if (this.matrices.get(2).getMatrixResult() != null) {
                    TableLayout resultDisplay = (TableLayout)convertView.findViewById(R.id.tableLayoutResult);
                    fillTable(this.matrices.get(2).getMatrixResult(), resultDisplay);
                }

                break;
        }
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return (this.matrices.get(position).getName().equals("Result")) ? RESULT_BLOCK : MATRIX_BLOCK;
    }

    private void fillTable(Fraction[][] matrix, TableLayout table) {
        table.removeAllViews();
        for (int i = 0; i < matrix.length; i++) {
            TableRow row = new TableRow(this.context);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

            for (int j = 0; j < matrix[0].length; j++) {
                TextView edit = new TextView(this.context);

                edit.setText(matrix[i][j].toString());
                edit.clearFocus();
                edit.setPadding(30, 0, 0, 0);
                edit.setTextSize(12f);
                edit.setTextColor(Color.BLACK);
                row.addView(edit);
            }
            table.addView(row);
        }
    }
}