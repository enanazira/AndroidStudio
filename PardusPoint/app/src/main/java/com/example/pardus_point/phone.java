package com.example.pardus_point;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class phone extends AppCompatActivity implements View.OnClickListener {

    ImageButton imgws1, imgws2, imgws3, imgws4, imgcall1,imgcall2, imgcall3,imgcall4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        imgws1 = findViewById(R.id.img_ws_1);
        imgws2 = findViewById(R.id.img_ws_2);
        imgws3 = findViewById(R.id.img_ws_3);
        imgws4 = findViewById(R.id.img_ws_4);

        imgcall1 = findViewById(R.id.img_call_1);
        imgcall2 = findViewById(R.id.img_call_2);
        imgcall3 = findViewById(R.id.img_call_3);
        imgcall4 = findViewById(R.id.img_call_4);


        imgws1.setOnClickListener(this);
        imgws2.setOnClickListener(this);
        imgws3.setOnClickListener(this);
        imgws4.setOnClickListener(this);
        imgcall1.setOnClickListener(this);
        imgcall2.setOnClickListener(this);
        imgcall3.setOnClickListener(this);
        imgcall4.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.img_call_1:
                Intent callIntent1 = new Intent(Intent.ACTION_DIAL);
                callIntent1.setData(Uri.parse("tel: 0112345343"));

                if(callIntent1.resolveActivity(getPackageManager())!=null) {
                    startActivity(callIntent1);
                }
                else{
                    Toast.makeText(phone.this, "Sorry, no app can handle this action and data",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.img_call_2:
                Intent callIntent2 = new Intent(Intent.ACTION_DIAL);
                callIntent2.setData(Uri.parse("tel: 0192626142"));

                if(callIntent2.resolveActivity(getPackageManager())!=null) {
                    startActivity(callIntent2);
                }
                else{
                    Toast.makeText(phone.this, "Sorry, no app can handle this action and data",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.img_call_3:
                Intent callIntent3 = new Intent(Intent.ACTION_DIAL);
                callIntent3.setData(Uri.parse("tel: 0129198250"));

                if(callIntent3.resolveActivity(getPackageManager())!=null) {
                    startActivity(callIntent3);
                }
                else{
                    Toast.makeText(phone.this, "Sorry, no app can handle this action and data",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.img_call_4:
                Intent callIntent4 = new Intent(Intent.ACTION_DIAL);
                callIntent4.setData(Uri.parse("tel: 0173192735"));

                if(callIntent4.resolveActivity(getPackageManager())!=null) {
                    startActivity(callIntent4);
                }
                else{
                    Toast.makeText(phone.this, "Sorry, no app can handle this action and data",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.img_ws_1:
                Uri whatsapp1 = Uri.parse("https://api.whatsapp.com/send?phone=60112345343");
                Intent wsIntent1 = new Intent(Intent.ACTION_VIEW,whatsapp1);
                if(wsIntent1.resolveActivity(getPackageManager()) != null){
                    startActivity(wsIntent1);
                }
                else{
                    Toast.makeText(phone.this, "Sorry, no app can handle this action and data",Toast.LENGTH_SHORT).show();

                }

                break;
            case R.id.img_ws_2:
                Uri whatsapp2 = Uri.parse("https://api.whatsapp.com/send?phone=60192626142");
                Intent wsIntent2 = new Intent(Intent.ACTION_VIEW,whatsapp2);
                if(wsIntent2.resolveActivity(getPackageManager()) != null){
                    startActivity(wsIntent2);
                }
                else{
                    Toast.makeText(phone.this, "Sorry, no app can handle this action and data",Toast.LENGTH_SHORT).show();

                }

                break;
            case R.id.img_ws_3:
                Uri whatsapp3 = Uri.parse("https://api.whatsapp.com/send?phone=60129198250");
                Intent wsIntent3 = new Intent(Intent.ACTION_VIEW,whatsapp3);
                if(wsIntent3.resolveActivity(getPackageManager()) != null){
                    startActivity(wsIntent3);
                }
                else{
                    Toast.makeText(phone.this, "Sorry, no app can handle this action and data",Toast.LENGTH_SHORT).show();

                }

                break;
            case R.id.img_ws_4:
                Uri whatsapp4 = Uri.parse("https://api.whatsapp.com/send?phone=60173192735");
                Intent wsIntent4 = new Intent(Intent.ACTION_VIEW,whatsapp4);
                if(wsIntent4.resolveActivity(getPackageManager()) != null){
                    startActivity(wsIntent4);
                }
                else{
                    Toast.makeText(phone.this, "Sorry, no app can handle this action and data",Toast.LENGTH_SHORT).show();

                }

                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
