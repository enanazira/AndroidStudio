package com.example.storage_link;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.storage_link.entities.Beverage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnSave , btnUpdate;
    EditText etName , etPrice;
    TextView tvBeverageId;
    ListView lvBeverage;

    ArrayAdapter<String> beverageListAdapter;
    ArrayList<String> beverageArray;
    ArrayList<Integer> beverageID;

    public static MyBeverageDB myBeverageDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btn_save);
        btnUpdate = findViewById(R.id.btn_update);
        etName = findViewById(R.id.et_name);
        etPrice = findViewById(R.id.et_price);
        tvBeverageId = findViewById(R.id.tv_becerage_id);
        lvBeverage = findViewById(R.id.lv_main);

        beverageListAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
        beverageArray = new ArrayList<String>();
        beverageID = new ArrayList<Integer>();

        myBeverageDB = Room.databaseBuilder(MainActivity.this,MyBeverageDB.class,"beverageDB").build();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextEmpty())
                    return;
                saveBeverage();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextEmpty())
                    return;
                updateBeverage();
            }
        });

        lvBeverage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvBeverageId.setText(beverageID.get(position).toString());
            }
        });

        lvBeverage.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("Remove Beverage");
                alertDialogBuilder.setMessage("Do you want to remove the Beverage: "+ beverageID.get(position) +"?");
                alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        toast(getApplicationContext(),"Action is Canceled");
                    }
                });
                alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Beverage beverage = new Beverage(Integer.parseInt(beverageID.get(position).toString()));
                        deleteBeverage(beverage);

                    }
                });
                alertDialogBuilder.show();
                return true;
            }
        });
    }

    public void saveBeverage(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                Beverage beverage = new Beverage(etName.getText().toString(),Float.parseFloat(etPrice.getText().toString()));
                myBeverageDB.beverageDao().insertBeverage(beverage);

                toast(getApplicationContext(),"Beverage Added");
                getAllBeverage();
            }
        }).start();

    }

    public void updateBeverage(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                Beverage beverage = new Beverage(Integer.parseInt(tvBeverageId.getText().toString()), etName.getText().toString(),Float.parseFloat(etPrice.getText().toString()));
                myBeverageDB.beverageDao().updateBeverage(beverage);
                toast(getApplicationContext(),"Beverage Updated");
                getAllBeverage();
            }
        }).start();


    }

    public void deleteBeverage(final Beverage beverage){

        new Thread(new Runnable() {
            @Override
            public void run() {
                myBeverageDB.beverageDao().deleteBeverage(beverage);
                toast(getApplicationContext(),"Beverage Deleted");
                getAllBeverage();
            }
        }).start();


    }

    public void getAllBeverage(){

        beverageID.clear();
        beverageArray.clear();
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Beverage> beverages = myBeverageDB.beverageDao().getAllBeverage();
                String beverageInfo;
                for (Beverage beverage:beverages)
                {
                    beverageInfo = "ID" + beverage.getBeverageID() +
                            "\n Name: "+ beverage.getBeverageName() +
                            " Price: " + beverage.getBeveragePrice();

                    beverageArray.add(beverageInfo);
                    beverageID.add(beverage.getBeverageID());
                }
                showDataListView();
            }
        }).start();


    }

    public void showDataListView(){
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                beverageListAdapter.clear();
                beverageListAdapter.addAll(beverageArray);
                lvBeverage.setAdapter(beverageListAdapter);
            }
        });


    }

    private boolean editTextEmpty(){

        if(TextUtils.isEmpty(etName.getText().toString())){

            etName.setError("Cannot be empty");
        }

        if ((TextUtils.isEmpty(etPrice.getText().toString()))){

            etPrice.setError("Cannot be Empty");
        }

        if ((TextUtils.isEmpty(etPrice.getText().toString())) || ((TextUtils.isEmpty(etName.getText().toString())))){

            return true;
        }

        else
            return false;


    }

    public void toast(final Context context, final String text){

        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        getAllBeverage();
    }
}
