package com.example.sanjay.linalgcalcnew;

import android.annotation.TargetApi;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

/*TODO: Add string array for size descriptions and for general function description*/
public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;

    String[] listNames = new String[]{
            "Matrix",
            "Vector"
    };
    /*String[] listNames = new String[]{
            "Add/Subtract Matrices",
            "Multiply Matrices",
            "Scalar Multiply Matrices",
            "Determinant",
            "Adjugate Matrix",
            "Cofactor Matrix",
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
*/
    int[] listImages = new int[]{
            R.drawable.m_add_sub,
            R.drawable.v_add_sub
    };
    /*int[] listImages = new int[]{
            R.drawable.m_add_sub,
            R.drawable.m_multiply,
            R.drawable.m_scalar,
            R.drawable.m_det,
            R.drawable.m_adj,
            R.drawable.m_cof,
            R.drawable.m_inverse,
            R.drawable.v_add_sub,
            R.drawable.v_multiply,
            R.drawable.v_cross,
            R.drawable.v_dot,
            R.drawable.v_proj,
            R.drawable.not_available,
            R.drawable.not_available,
            R.drawable.not_available,
            R.drawable.not_available,
            R.drawable.not_available
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);


        toolbar.setTitle("Linear Algebra Calculator");

        listView = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, this.listImages, this.listNames);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0)
                {
                    Intent matrixIntent = new Intent(MainActivity.this, MatrixSizeActivity.class);
                    startActivity(matrixIntent);
                }
                else if (i == 1)
                {
                    //Intent matrixIntent = new Intent(MainActivity.this, MatrixSizeActivity.class);
                    //startActivity(matrixIntent);
                }
            }
        });
    }
}
