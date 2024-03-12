package com.example.btl_final_foodorderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Custom_BaseAdapter extends BaseAdapter {

    Context context;
    String listFood[];
    int listImage[];
    LayoutInflater inflater;

    public Custom_BaseAdapter(Context ctx,String [] foodlist,int [] images )
    {
        this.context = ctx;
        this.listFood = foodlist;
        this.listImage = images;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listFood.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_custom_list_view,null);
        TextView txtView = (TextView)  view.findViewById(R.id.textView);
        ImageView foodImage = (ImageView) view.findViewById(R.id.fastfood);
        txtView.setText(listFood[i]);
        foodImage.setImageResource(listImage[i]);
        return view;
    }
}
