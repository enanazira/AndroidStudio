package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.adapter.BeverageRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<Beverage> allBeverageInfo = getAllBeverageInfo();
        BeverageRecyclerViewAdapter beverageRecyclerViewAdapter = new BeverageRecyclerViewAdapter(MainActivity.this, allBeverageInfo);
        recyclerView.setAdapter(beverageRecyclerViewAdapter);
    }

    private List<Beverage> getAllBeverageInfo(){

        List<Beverage> allBeverage = new ArrayList<Beverage>();

        allBeverage.add(new Beverage("Flat White", R.drawable.flat_white));
        allBeverage.add(new Beverage("Cappuccino", R.drawable.cappuccino_1));
        allBeverage.add(new Beverage("Earl Grey", R.drawable.earl_grey));
        allBeverage.add(new Beverage("Espresso", R.drawable.espresso_1));
        allBeverage.add(new Beverage("Green Tea", R.drawable.green_tea));

        allBeverage.add(new Beverage("Latte", R.drawable.latte_2));


        return allBeverage;
    }
}

