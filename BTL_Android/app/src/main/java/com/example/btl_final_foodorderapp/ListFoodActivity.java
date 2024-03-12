package com.example.btl_final_foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListFoodActivity extends AppCompatActivity {
    String food[]={"FAST FOOD","DRINK","ICREAM","CAKE","NOODLE"};
    int foodImage[] = {R.drawable.fastfood,R.drawable.drink,R.drawable.icream,R.drawable.cake,R.drawable.ramen};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food);
        listView = findViewById(R.id.customListView);
        Custom_BaseAdapter ct = new Custom_BaseAdapter(getApplicationContext(),food,foodImage);
        listView.setAdapter(ct);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) { // Nếu người dùng chọn item 1
                    Intent intent = new Intent(ListFoodActivity.this, FastFood_Activity.class);
                    startActivity(intent);
                }
                if (i == 1) { // Nếu người dùng chọn item 2
                    Intent intent = new Intent(ListFoodActivity.this, Drink_Food_Activity.class);
                    startActivity(intent);
                }
                if (i == 2) { // Nếu người dùng chọn item 3
                    Intent intent = new Intent(ListFoodActivity.this, Icream_Food_Activity.class);
                    startActivity(intent);
                }
//                if (i == 3) { // Nếu người dùng chọn item 4
//                    Intent intent = new Intent(ListFoodActivity.this, Ramen_Food_Activity.class);
//                    startActivity(intent);
//                }
//                if (i == 0) { // Nếu người dùng chọn item 5
//                    Intent intent = new Intent(ListFoodActivity.this, Cake_Food_Activity.class);
//                    startActivity(intent);
//                }
            }
        });
    }
}