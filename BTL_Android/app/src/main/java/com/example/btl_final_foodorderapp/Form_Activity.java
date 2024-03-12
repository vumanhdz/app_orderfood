package com.example.btl_final_foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Form_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Button btn_ctnOder = findViewById(R.id.btn_continueOder);
        btn_ctnOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtName = findViewById(R.id.edname);
                EditText edtAddress = findViewById(R.id.edaddress);

                String name = edtName.getText().toString();
                String address = edtAddress.getText().toString();

                if (name.isEmpty() || address.isEmpty()) {
                    // Hiển thị thông báo nếu chưa nhập dữ liệu
                    Toast.makeText(Form_Activity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Form_Activity.this, Invoice_Activity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("address", address);
                    startActivity(intent);
                }
            }
        });

    }
}