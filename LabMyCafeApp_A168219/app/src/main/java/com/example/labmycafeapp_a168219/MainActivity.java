package com.example.labmycafeapp_a168219;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnMinus, btnCheckOut;
    TextView  tvQuantity;
    EditText etName;

    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        btnMinus = findViewById(R.id.btn_minus);
        btnCheckOut = findViewById(R.id.btn_checkout);
        tvQuantity = findViewById(R.id.tv_quantity);
        etName = findViewById(R.id.pt_name);

        quantity=1;

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                tvQuantity.setText(""+quantity);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity--;
                tvQuantity.setText(""+quantity);
            }
        });

        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            String name;
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                Toast.makeText(MainActivity.this,"Thank You "+name+" for order "+
                        quantity+" Latte.",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,OrderedDetailActivity.class);
                intent.putExtra("quantity",quantity);
                intent.putExtra("name",name);

                startActivity(intent);

            }
        });
    }
}
