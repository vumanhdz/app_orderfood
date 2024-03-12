package com.example.btl_final_foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Invoice_Activity extends AppCompatActivity {

    ListView listview_invoice;
    InvoiceAdapter invoiceAdapter;
    EditText editTextTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);
        EditText ednameinvoice = findViewById(R.id.ednameinvoice);
        EditText edaddressinvoice = findViewById(R.id.edaddressinvoice);
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        ednameinvoice.setText(name);

        String address = intent.getStringExtra("address");
        edaddressinvoice.setText(address);

        listview_invoice = findViewById(R.id.listview_invoice);
        editTextTotal = findViewById(R.id.editTextTotal);

        DatabaseHelperCart databaseHelperCart = new DatabaseHelperCart(Invoice_Activity.this);
        List<CartItem> items = databaseHelperCart.getAllItems();

        double totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        editTextTotal.setText(String.format(totalPrice*0.9+"VND"));



        invoiceAdapter = new InvoiceAdapter(Invoice_Activity.this, items);
        listview_invoice.setAdapter(invoiceAdapter);

        Button btn_success = findViewById(R.id.btnsuccess);
        btn_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Bạn đã đặt hàng thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Invoice_Activity.this, Cart_ListView_Activity.class);
                startActivity(intent);
            }
        });

    }
}