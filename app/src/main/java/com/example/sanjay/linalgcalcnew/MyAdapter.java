package com.example.sanjay.linalgcalcnew;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sanjay on 5/26/2017.
 * Image/Test adapter for main menu selection screen
 */

public class MyAdapter extends ArrayAdapter<String> {
    String[] titles;
    int[] icons;
    Context context;

    public MyAdapter(@NonNull Context context, int[] icons, String[] titles) {
        super(context, R.layout.listview_item);
        this.icons = icons;
        this.titles = titles;
        this.context = context;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listview_item, parent, false);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.title = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.icon.setImageResource(this.icons[position]);
        viewHolder.title.setText(this.titles[position]);
        return convertView;
    }

    private static class ViewHolder {
        ImageView icon;
        TextView title;
    }

}
