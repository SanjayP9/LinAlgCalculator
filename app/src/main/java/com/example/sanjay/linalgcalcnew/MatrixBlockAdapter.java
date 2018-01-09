package com.example.sanjay.linalgcalcnew;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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

                // set view
                if (this.matrices.get(position).getMatrix() != null) {
                    // Names are stored in Matrix obj now
                    //String mName;
                    //mName = (position == 0) ? "A" : "B";
                    TableLayout matrixDisplay = (TableLayout) convertView.findViewById(R.id.tableLayout1);
                    //matrixDisplay.setText(this.matrices.get(position).toString());

                    fillTable(this.matrices.get(position).getMatrix(), matrixDisplay);

                    /*TableRow tempRow = new TableRow(this.context);
                    TextView tempView = new TextView(this.context);

                    for (int i = 0; i < this.matrices.get(position).getMatrix().length; i++) {
                        for (int j = 0; j < this.matrices.get(position).getMatrix()[0].length; j++) {
                            tempView.setText(this.matrices.get(position).getMatrix()[i][j].toString());

                            if (tempView.getParent() != null) {
                                ((ViewGroup) tempView.getParent()).removeView(tempView);
                            }

                            tempRow.addView(tempView);
                        }
                        if (tempRow.getParent() != null) {
                            ((ViewGroup) tempRow.getParent()).removeView(tempRow);
                        }
                        matrixDisplay.addView(tempRow);
                    }*/
                }
                break;


            case RESULT_BLOCK:
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.m_result_block, parent, false);
                }
                if (this.matrices.get(2).getMatrix() != null) {
                    TextView result = (TextView) convertView.findViewById(R.id.textResult);
                    result.setText(this.matrices.get(2).toString());
                }

                break;
        }
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    /*@Override
    public int getCount() {
        return 3;
    }*/

    @Override
    public int getItemViewType(int position) {
        if (this.matrices.get(position).getName().equals("Result")) {
            return RESULT_BLOCK;
        }
        return MATRIX_BLOCK;
    }

    private void fillTable(Fraction[][] matrix, TableLayout table) {
        table.removeAllViews();
        for (int i = 0; i < matrix.length; i++) {
            TableRow row = new TableRow(this.context);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

            for (int j = 0; j < matrix[0].length; j++) {
                TextView edit = new TextView(this.context);
                //edit.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL| InputType.TYPE_NUMBER_FLAG_SIGNED);
                //edit.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                edit.setText(matrix[i][j].toString());
                edit.clearFocus();
                edit.setPadding(30,0,0,0);
                edit.setTextSize(12f);
                edit.setTextColor(Color.BLACK);

                //edit.setKeyListener(null);
                row.addView(edit);
            }
            table.addView(row);
        }
    }
}