package com.example.btl_final_foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

public class FastFood_Activity extends AppCompatActivity {

    private ListView listView;
    private Drink_Food_Adapter adapter;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_food);

        // Khởi tạo đối tượng DatabaseHelperFood để tạo database
        DatabaseHelperFood dbHelper = new DatabaseHelperFood(this);
        db = dbHelper.getReadableDatabase();

        // Lấy dữ liệu từ bảng food_drink
        Cursor cursor = db.query(DatabaseHelperFood.TABLE_FOOD_FASTFOOD,
                null, null, null, null, null, null);

        // Khởi tạo adapter và truyền vào cursor
        adapter = new Drink_Food_Adapter(this, cursor);
        listView = findViewById(R.id.fastfood_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) { // Nếu người dùng chọn item đầu tiên
                    Intent intent = new Intent(FastFood_Activity.this,FastFoodDetail_Buger_Activity.class);
                    startActivity(intent);
                }
                if (i == 1) { // Nếu người dùng chọn item đầu tiên
                    Intent intent = new Intent(FastFood_Activity.this,Fast_Food_FrenchfriesDetail_Activity.class);
                    startActivity(intent);
                }
            }
        });
//        ImageButton imageButton = findViewById(R.id.imgcart_fastfood);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(FastFood_Activity.this,Cart_ListView_Activity.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Đóng kết nối database khi activity bị hủy
        db.close();
    }
}

