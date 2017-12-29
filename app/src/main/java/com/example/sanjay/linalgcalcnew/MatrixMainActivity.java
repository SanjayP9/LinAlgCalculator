package com.example.sanjay.linalgcalcnew;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Sanjay on 6/29/2017.
 * Used to get the size of both matrices. Functionality should be added so that this activity
 * receives an intent message from main activity that specifies 1 or 2 matrices then this activity
 * creates sized entry based on message. Then based on that original message it should send that to
 * the grid view activity so that it can tell if it needs to input another matrix. Should send size
 * and elements in intent message. then create a result activity that displays all results for
 * matrix problems. Pass through list names activities between main menu and result should have back
 * button in tool bar that goes to matrix entry screen
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



        listView = (ListView)findViewById(R.id.matrixList);

        //MatrixBlockAdapter myAdapter = new MatrixBlockAdapter()

    }


    public void sendMessage(View view) {
        //Intent intent = new Intent(this,)
    }


}