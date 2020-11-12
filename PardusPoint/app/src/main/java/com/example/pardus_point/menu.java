package com.example.pardus_point;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class menu extends AppCompatActivity {

    ImageButton imgBtnProfile, imgBtnActivity, imgBtnTotalMerit, imgBtnPetaKUO, imgBtnOrganisasi, imgBtnCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imgBtnProfile = findViewById(R.id.imgBtn_profile);
        imgBtnActivity = findViewById(R.id.imgBtn_activity);
        imgBtnTotalMerit = findViewById(R.id.imgBtn_totalMerit);
        imgBtnPetaKUO = findViewById(R.id.imgBtn_map);
        imgBtnOrganisasi = findViewById(R.id.imgBtn_organization);
        imgBtnCall = findViewById(R.id.imgBtn_call);


        imgBtnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(menu.this, Profile.class);
                startActivity(profileIntent);
            }
        });
        imgBtnOrganisasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent organisasiIntent = new Intent(menu.this, pentadbiran.class);
                startActivity(organisasiIntent);
            }
        });



        imgBtnTotalMerit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent total = new Intent(menu.this, totalMerit.class);
                startActivity(total);
            }
        });

        imgBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(menu.this, phone.class);
                startActivity(call);
            }
        });
        imgBtnPetaKUO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(menu.this, peta_kuo.class);
                startActivity(map);
            }
        });
    }
}

