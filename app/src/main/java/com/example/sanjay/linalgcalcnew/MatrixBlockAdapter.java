package com.example.sanjay.linalgcalcnew;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

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
                if (this.matrices.get(position) != null) {
                    String mName;
                    mName = (position == 0) ? "A" : "B";


                }


                break;


            case RESULT_BLOCK:
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.m_result_block, parent, false);
                }


                // set view

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
        if (this.matrices.get(position).getIsResult()) {
            return RESULT_BLOCK;
        }
        return MATRIX_BLOCK;
    }
}