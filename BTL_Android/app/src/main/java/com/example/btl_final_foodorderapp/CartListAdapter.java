package com.example.btl_final_foodorderapp;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartListAdapter extends BaseAdapter {

    private Context context;
    private List<CartItem> items;

    public CartListAdapter(Context context, List<CartItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return items.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.cart_items_listview, viewGroup, false);

        TextView idTextView = itemView.findViewById(R.id.tv_item_name_id);
        TextView nameTextView = itemView.findViewById(R.id.tv_item_name_cart);
        TextView priceTextView = itemView.findViewById(R.id.tv_item_price_cart);
        TextView quantityTextView = itemView.findViewById(R.id.et_item_quantity);

        CartItem item = items.get(i);

        idTextView.setText(i+1+"");
        nameTextView.setText(item.getName());
        priceTextView.setText(String.format(item.getPrice()+ ""));
        quantityTextView.setText(String.valueOf(item.getQuantity()));

        Button btnDelete = itemView.findViewById(R.id.btn_delete_item);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelperCart databaseHelperCart = new DatabaseHelperCart(context);
                databaseHelperCart.deleteItem(item.getId());
                items.remove(item);
                notifyDataSetChanged();
            }
        });

        return itemView;
    }
}
