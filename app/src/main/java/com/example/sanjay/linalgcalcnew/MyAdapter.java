package com.example.sanjay.linalgcalcnew;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by Sanjay on 5/26/2017.
 */

public class MyAdapter extends ArrayAdapter<String>
{
    String [] names;
    int[] flags;
    Context context;

    public MyAdapter(@NonNull Context context, @LayoutRes int resource ,int[] flags, String[] names)
    {
        super(context, R.layout.listview_item);
        this.flags = flags;
        this.names = names;
        this.context = context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
