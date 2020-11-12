package com.example.labmycafeapp_a168219;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class OrderedDetailActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imgBtnCall, imgBtnWeb, imgBtnEmail;
    TextView tvName, tvQuantity;
    String name;
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordered_detail);

        imgBtnCall = findViewById(R.id.img_btn_call_order);
        imgBtnEmail = findViewById(R.id.img_btn_email_order);
        imgBtnWeb = findViewById(R.id.img_btn_web_order);

        tvName = findViewById(R.id.tv_name_order);
        tvQuantity = findViewById(R.id.tv_quantity_order);


        Intent intent = getIntent();
        quantity = intent.getIntExtra("quantity",0);
        name = intent.getStringExtra("name");
        tvName.setText(name);
        tvQuantity.setText(""+quantity);

        imgBtnWeb.setOnClickListener(this);
        imgBtnEmail.setOnClickListener(this);
        imgBtnCall.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.img_btn_call_order:
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel: 012345678"));

                if(callIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(callIntent);
                }
                else{
                    Toast.makeText(OrderedDetailActivity.this, "Sorry, no app can handle this action and data", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.img_btn_email_order:
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your Order from MyCafeApp");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Email message: Information about order.");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mycafeapp@company.com"});
                if (emailIntent.resolveActivity(getPackageManager())!= null){ //verify that an app exist to run the intent
                    startActivity(emailIntent);}
                else {
                    Toast.makeText(OrderedDetailActivity.this,
                            "Sorry, no app can handle this action and data",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.img_btn_web_order:
                Uri webPage = Uri.parse("http://www.google.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW,webPage);
                if (webIntent.resolveActivity(getPackageManager())!= null){ //verify that an app exist to run the intent
                    startActivity(webIntent);}
                else {
                    Toast.makeText(OrderedDetailActivity.this,
                            "Sorry, no app can handle this action and data",Toast.LENGTH_SHORT).show();
                }

                break;

        }
    }
}
