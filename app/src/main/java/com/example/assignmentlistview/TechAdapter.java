package com.example.assignmentlistview;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TechAdapter extends BaseAdapter {

    private final Context context;
    private final String[] titles;
    private final String[] subtitles;
    private final Integer[] imgIds;

    public TechAdapter(Context context, String[] titles, String[] subtitles, Integer[] imgIds) {
        this.context = context;
        this.titles = titles;
        this.subtitles = subtitles;
        this.imgIds = imgIds;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return titles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(R.layout.sample_view , parent, false);
        } else {
            row = convertView;
        }

        TextView titleText = row.findViewById(R.id.title);
        TextView subtitleText = row.findViewById(R.id.subtitle);
        ImageView icon = row.findViewById(R.id.imageView);

        titleText.setText(titles[position]);
        subtitleText.setText(subtitles[position]);
        icon.setImageResource(imgIds[position]);

        return row;
    }
}
