package com.example.btl_final_foodorderapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class Drink_Food_Adapter extends BaseAdapter {

    private Context context;
    private Cursor cursor;

    public Drink_Food_Adapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override
    public Object getItem(int i) {
        cursor.moveToPosition(i);
        return cursor;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.drink_items_listview, parent, false);
        }

        cursor.moveToPosition(position);

        TextView tvName = convertView.findViewById(R.id.textview_food_name);
        TextView tvPrice = convertView.findViewById(R.id.textview_food_price);

        String name = "";
        int price = 0;
        int nameIndex = cursor.getColumnIndex(DatabaseHelperFood.COLUMN_NAME_DRINK);
        if (nameIndex != -1) {
            name = cursor.getString(nameIndex);
        }

        int priceIndex = cursor.getColumnIndex(DatabaseHelperFood.COLUMN_PRICE_DRINK);
        if (priceIndex != -1) {
            price = cursor.getInt(priceIndex);
        }

        tvName.setText(name);
        tvPrice.setText(String.valueOf(price));

        return convertView;
    }
}
