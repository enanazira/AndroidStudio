package com.example.lablocation_a168219;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    TextView tvLocation;
    FusedLocationProviderClient mFusedLocationClient;
    LocationRequest mLocationRequest;
    LocationCallback mLocationCallback;

    LocationSettingsRequest.Builder mlocationSettingBuilder;
    SettingsClient clients;
    Task<LocationSettingsResponse> task;
    private static final int REQUEST_CHECK_SETTINGS = 0x1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLocation = findViewById(R.id.tv_location);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(MainActivity.this);
        mLocationCallback = new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null){
                    return;
                }else
                    tvLocation.append("\n"+"Latitude: "+locationResult.getLastLocation().getLatitude()+" Longitude: "
                    +locationResult.getLastLocation().getLongitude());
            }
        };

        setLocationRequestSettings();

    }

    @Override
    protected void onResume() {
        super.onResume();
       // startLocationUpdates();
        requestLocationUpdate();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mFusedLocationClient != null){
            mFusedLocationClient.removeLocationUpdates(mLocationCallback);
            Toast.makeText(MainActivity.this,"Listener is Removed",Toast.LENGTH_SHORT).show();
        }
    }

    private void requestLocationUpdate(){
        mlocationSettingBuilder = new LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest);
        clients = LocationServices.getSettingsClient(MainActivity.this);
        task = clients.checkLocationSettings(mlocationSettingBuilder.build());
        task.addOnSuccessListener(MainActivity.this, new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                startLocationUpdates();
            }
        });
        task.addOnFailureListener(MainActivity.this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ResolvableApiException){
                    try {
                        ResolvableApiException resolvable = (ResolvableApiException) e;
                        resolvable.startResolutionForResult(MainActivity.this,REQUEST_CHECK_SETTINGS);

                    }catch (IntentSender.SendIntentException sendEx){

                    }
                }
            }
        });
    }

    private void setLocationRequestSettings(){
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setInterval(3000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

    }

    private void startLocationUpdates(){
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                showExplaination();
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        0);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            mFusedLocationClient.requestLocationUpdates(mLocationRequest,mLocationCallback,null);
            Toast.makeText(MainActivity.this,"Location Permission was granted",Toast.LENGTH_SHORT).show();
        }
    }

    private void showExplaination(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Requires Location Permission");
        builder.setMessage("This app needs location permission to get the location information");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Sorry, this function cannot be worked until permission is granted",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}
