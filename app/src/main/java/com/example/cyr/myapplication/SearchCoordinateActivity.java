package com.example.cyr.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by yang li on 2016/10/9.
 */
public class SearchCoordinateActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_coordinate);
        Button b1=(Button) findViewById(R.id.sclayout_search_coordinate_btn);
        Button b2=(Button) findViewById(R.id.sclayout_exit_btn);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sclayout_search_coordinate_btn: {
                EditText la=(EditText) findViewById(R.id.latitude_edtx);
                EditText lo=(EditText) findViewById(R.id.longtitude_edtx);
                Uri mUri = Uri.parse("geo:"+la.getText().toString()+","+lo.getText().toString());
                Intent mIntent = new Intent(Intent.ACTION_VIEW,mUri);
                startActivity(mIntent);
                break;
            }
            case R.id.sclayout_exit_btn:{
                finish();
                break;
            }
        }
    }

}
