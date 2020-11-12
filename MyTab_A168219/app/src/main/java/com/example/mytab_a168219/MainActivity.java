package com.example.mytab_a168219;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mytab_a168219.adapter.DeviceFragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar_main);
        tabLayout = findViewById(R.id.tabs_main);
        viewPager = findViewById(R.id.view_pager_main);

        setSupportActionBar(toolbar);
        setupViewPager();
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_computer_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_phone_iphone_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_watch_black_24dp);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0 :
                        Toast.makeText(MainActivity.this,"Computer is selected",Toast.LENGTH_SHORT).show();
                        break;
                    case 1 :
                        Toast.makeText(MainActivity.this, "Phone is selected",Toast.LENGTH_SHORT).show();
                        break;
                    case 2 :
                        Toast.makeText(MainActivity.this,"Watch is selected",Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                /*switch (tab.getPosition()){
                    case 0 :
                        Toast.makeText(MainActivity.this,"Computer is unselected",Toast.LENGTH_SHORT).show();
                        break;
                    case 1 :
                        Toast.makeText(MainActivity.this, "Phone is unselected",Toast.LENGTH_SHORT).show();
                        break;
                    case 2 :
                        Toast.makeText(MainActivity.this,"Watch is unselected",Toast.LENGTH_SHORT).show();
                        break;
                }*/
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                /*switch (tab.getPosition()){
                    case 0 :
                        Toast.makeText(MainActivity.this,"Computer is Reselected",Toast.LENGTH_SHORT).show();
                        break;
                    case 1 :
                        Toast.makeText(MainActivity.this, "Phone is Reselected",Toast.LENGTH_SHORT).show();
                        break;
                    case 2 :
                        Toast.makeText(MainActivity.this,"Watch is Reselected",Toast.LENGTH_SHORT).show();
                        break;
                }*/
            }
        });

    }

    private void setupViewPager (){
        DeviceFragmentPagerAdapter adapter = new DeviceFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new ComputerFragment(),"Computer");
        adapter.addFrag(new PhoneFragment(),"Phone");
        adapter.addFrag(new WatchFragment(),"Watch");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
