package com.example.mytoolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

      //  ActionBar myActionBar = getSupportActionBar();
      //  myActionBar.setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_notification:
                Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"Notification",Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_setting:
                intent = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"Setting",Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_sync:
                intent = new Intent(MainActivity.this,SyncActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"Sync",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);

    }
}
