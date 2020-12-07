package com.example.alatmusiktradisional;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<AlatMusikTradisional> movieItems;
    public CustomListAdapter(Activity activity, List<AlatMusikTradisional> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }
    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView daerah = (TextView) convertView.findViewById(R.id.text_daerah);
        TextView kategori = (TextView) convertView.findViewById(R.id.text_kategori);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
        AlatMusikTradisional m = movieItems.get(position);
        nama.setText("Nama : "+ m.get_nama());
        daerah.setText("Daerah : "+ m.get_daerah());
        kategori.setText("Kategori : "+ m.get_kategori());
        return convertView;
    }
}