package com.example.sanjay.linalgcalcnew;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Sanjay on 6/29/2017.
 * Used to get row and column. after they are entered enter matrix becomes enabled and goes to another
 * activity where its entered and a submit button is pressed. That activity recieves the row and column initially
 * then returns a 2d fraction array which is added to the matricies arraylist. Then they are displayed on the
 * textviews for on this activity. When they are displayed its seekbar is disabled. when both matricies
 * are displayed and both seekbars are disabled the result is calculated and is shown.
 * When the operation is changed or the reset button is pressed clear saved rows, columns and matrices
 * and set everything back to normal.
 * TODO Add left side drawer to switch between vectors and matrices. (Try to make use of icons)
 * TODO Make reset button
 * TODO Also do vector/plane entry (should be easy)
 * TODO Send Feedback and maybe dark mode (Inverted text and app theme becomes dark)
 * TODO Make Matrix.toString formatted properly
 */

public class MatrixMainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Spinner opSpinner;
    ListView listView;
    ArrayList<Matrix> matrices = null; // Store A, B and Result matrices

    // Create xml for double matrix with operation and do xml for single matrix.
    // change titles to differentiate
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matrix_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("Matrix Calculations");


        listView = (ListView) findViewById(R.id.matrixList);

        // TEST
        Fraction[][] m1 = new Fraction[][]{
                {new Fraction(6), new Fraction(8845), new Fraction(4), new Fraction(9)},
                {new Fraction(3544), new Fraction(6), new Fraction(5540), new Fraction(0)},
                {new Fraction(30), new Fraction(6), new Fraction(0), new Fraction(450)},
                {new Fraction(3), new Fraction(6), new Fraction(4540), new Fraction(0)},
                {new Fraction(5), new Fraction(10), new Fraction(4842), new Fraction(9)}
        };
        // TEST


        ArrayList<Matrix> matrices = new ArrayList<Matrix>();
        matrices.add(new Matrix("A", 5, 4, m1));
        matrices.add(new Matrix("B", 5, 4, m1));
        matrices.add(new Matrix("Result", 5, 4, m1));

        MatrixBlockAdapter matrixBlockAdapter = new MatrixBlockAdapter(getApplicationContext(), R.layout.matrix_block, matrices);
        listView.setAdapter(matrixBlockAdapter);
    }


}
