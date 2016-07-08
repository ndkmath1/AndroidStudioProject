package com.example.khanh.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by khanh on 06/07/2016.
 */
public class CustomListAdapter extends BaseAdapter {
    private List<Country> listCountry;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(List<Country> listCountry, Context context) {
        this.listCountry = listCountry;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listCountry.size();
    }

    @Override
    public Object getItem(int i) {
        return listCountry.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.list_item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imageView);
            viewHolder.textViewCountry = (TextView) view.findViewById(R.id.textViewCountryName);
            viewHolder.textViewPopulation = (TextView) view.findViewById(R.id.textViewPopulation);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Country country = this.listCountry.get(i);
        viewHolder.textViewCountry.setText(country.getCountryName());
        viewHolder.textViewPopulation.setText("population: " + country.getPopulation());
        viewHolder.imageView.setImageResource(getMipMapResIdByName(country.getFlagName()));
        return view;
    }

    private int getMipMapResIdByName(String resName) {
        String pkgName = context.getPackageName();
        int resId = context.getResources().getIdentifier(resName, "mipmap", pkgName);
        return resId;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textViewCountry;
        TextView textViewPopulation;
    }
}
