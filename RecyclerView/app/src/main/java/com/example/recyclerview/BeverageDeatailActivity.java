package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BeverageDeatailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage_deatail);

        Intent intent = getIntent();
        TextView tvName = findViewById(R.id.tv_beverage_name_detail);
        tvName.setText(intent.getStringExtra("beverageName"));

    }
}
