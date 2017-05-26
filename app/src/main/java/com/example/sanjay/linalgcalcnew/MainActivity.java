package com.example.sanjay.linalgcalcnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;
    String[] listNames = new String[]{
            "Add/Subtract Matrices",
            "Multiply Matrices",
            "Scalar Multiply Matrices",
            "Determinant",
            "Adjugate Matrix",
            "Inverse Matrix",
            "Add/Subtract Vectors",
            "Multiply Vectors",
            "Cross Product",
            "Dot Product",
            "Projection",
            "Parallelepiped Volume",
            "Point to Plane Distance",
            "Intersection of 2 Lines in 3D Space",
            "Intersection of 2 Planes",
            "Intersection of 3 Planes"
    };

    int[] listImages = new int[]{

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        listView = (ListView) findViewById(R.id.listview);
    }
}
