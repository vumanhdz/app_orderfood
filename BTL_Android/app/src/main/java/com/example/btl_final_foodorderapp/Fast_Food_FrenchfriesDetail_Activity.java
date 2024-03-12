package com.example.btl_final_foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Fast_Food_FrenchfriesDetail_Activity extends AppCompatActivity {
    private TextView tvNameDetail;
    private TextView tvPriceDetail;

    private EditText edNumberDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_food_frenchfries_detail);

        tvNameDetail = findViewById(R.id.tvname);
        tvPriceDetail = findViewById(R.id.tvprice);
        edNumberDetail = findViewById(R.id.ednumber);

        Button btn_add_db = findViewById(R.id.buttondetail);
        btn_add_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = tvNameDetail.getText().toString();
                String price = tvPriceDetail.getText().toString();
                String quantity = edNumberDetail.getText().toString();
                // Lưu dữ liệu vào database
                DatabaseHelperCart dbHelper = new DatabaseHelperCart(Fast_Food_FrenchfriesDetail_Activity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("price", price);
                values.put("quantity", quantity);
                db.insert("cart", null, values);
                db.close();
                Toast.makeText(Fast_Food_FrenchfriesDetail_Activity.this, "Thêm vào giỏ hàng thành công", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton imageButton = findViewById(R.id.imgcart_fastfood);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fast_Food_FrenchfriesDetail_Activity.this,Cart_ListView_Activity.class);
                startActivity(intent);
            }
        });
    }
}