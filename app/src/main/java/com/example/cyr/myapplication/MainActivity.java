package com.example.cyr.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=(Button) findViewById(R.id.current_location_btn);
        Button b2=(Button) findViewById(R.id.search_coordinate_btn);
        Button b3=(Button) findViewById(R.id.search_country_btn);
        Button b4=(Button) findViewById(R.id.exit_btn);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
//        Uri mUri = Uri.parse("geo:0,0?q=Beijing");
//        Intent mIntent = new Intent(Intent.ACTION_VIEW,mUri);
//        startActivity(mIntent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.current_location_btn: {
                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                Uri mUri = Uri.parse("geo:"+location.getLatitude()+","+location.getLongitude());
                Intent mIntent = new Intent(Intent.ACTION_VIEW,mUri);
                startActivity(mIntent);
                break;
            }
            case R.id.search_coordinate_btn:{
                Intent intent=new Intent(MainActivity.this,SearchCoordinateActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.search_country_btn:{
                Intent intent=new Intent(MainActivity.this,SelectContinetActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.exit_btn :{
                finish();
                break;
            }
        }
    }

}
