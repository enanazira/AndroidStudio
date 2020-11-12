package com.example.pardus_point;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pardus_point.R;
import com.example.pardus_point.adapter.ActivityRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class totalMerit extends AppCompatActivity {


    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_merit);

        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(totalMerit.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<Activity> allActivityInfor = getAllActivityInfor();

        ActivityRecyclerViewAdapter activityRecyclerViewAdapter = new ActivityRecyclerViewAdapter(totalMerit.this,allActivityInfor);
        recyclerView.setAdapter(activityRecyclerViewAdapter);



        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    private List<Activity> getAllActivityInfor()
    {
        List<Activity> allActivity = new ArrayList<>();

        allActivity. add(new Activity("Hari Interaksi","30"));
        allActivity. add(new Activity("Minggu Mesra Mahasiswa","30"));
        allActivity. add(new Activity("Minggu Mesra Mahasiswa","30"));
        allActivity. add(new Activity("Minggu Mesra Mahasiswa","30"));
        allActivity. add(new Activity("Minggu Mesra Mahasiswa","1"));
        allActivity. add(new Activity("Minggu Mesra Mahasiswa","130"));
        allActivity. add(new Activity("Minggu Mesra Mahasiswa","30"));
        allActivity. add(new Activity("Minggu Mesra Mahasiswa","30"));
        allActivity. add(new Activity("Minggu Mesra Mahasiswa","30"));
        allActivity. add(new Activity("Minggu Mesra Mahasiswa","30"));
        allActivity. add(new Activity("Minggu Mesra Mahasiswa","30"));
        allActivity. add(new Activity("Minggu Mesra Mahasiswa","30"));
        allActivity. add(new Activity("Minggu Mesra Mahasiswa","30"));
        allActivity. add(new Activity("Minggu Mesra Mahasiswa","30"));
        allActivity. add(new Activity("Minggu Mesra Mahasiswa","30"));




        return allActivity;
    }
}