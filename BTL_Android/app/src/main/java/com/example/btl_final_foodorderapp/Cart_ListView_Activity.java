package com.example.btl_final_foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Cart_ListView_Activity extends AppCompatActivity {
    private ListView listView;
    private CartListAdapter adapter;

    Button btnOrder;

    EditText edsumcart;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list_view);

        listView = findViewById(R.id.cart_listview);

        edsumcart = findViewById(R.id.edsumcart);

        DatabaseHelperCart databaseHelperCart = new DatabaseHelperCart(Cart_ListView_Activity.this);
        List<CartItem> items = databaseHelperCart.getAllItems();



        adapter = new CartListAdapter(Cart_ListView_Activity.this, items);
        listView.setAdapter(adapter);

        btnOrder = findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        Button btn_sum = findViewById(R.id.btn_sum_cart);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double totalPrice = 0;
                for (CartItem item : items) {
                    totalPrice += item.getPrice() * item.getQuantity();
                }
                edsumcart.setText(String.format(totalPrice+totalPrice*0.1+"VND"));
            }
        });
        Button btn_showform = findViewById(R.id.btnOrder);
        btn_showform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart_ListView_Activity.this,Form_Activity.class);
                startActivity(intent);
            }
        });
    }
}
