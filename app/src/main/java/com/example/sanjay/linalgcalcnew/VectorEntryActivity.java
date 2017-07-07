package com.example.sanjay.linalgcalcnew;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by sparaboo on 2017-07-04.
 */

public class VectorEntryActivity extends AppCompatActivity
{
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vector_entry);

        toolbar =(Toolbar)findViewById(R.id.toolbar3);
        toolbar.setTitle("Set Vector Size");

        Bundle vectorBundle = getIntent().getExtras();

        if (vectorBundle != null)
        {
            toolbar.setTitle(vectorBundle.getString("listNames"));
        }

    }
}
