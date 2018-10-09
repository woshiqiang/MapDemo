package com.example.cyr.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by yang li on 2016/10/9.
 */
public class SelectContinetActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_continents_layout);
        Button b1=(Button) findViewById(R.id.select_continents_ok_btn);
        Button b2=(Button) findViewById(R.id.select_continents_exit_btn);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select_continents_ok_btn: {
                RadioGroup radioGroup =(RadioGroup) findViewById(R.id.continents_rdg);
                RadioButton radioButton =(RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                Intent intent =new Intent(SelectContinetActivity.this,SelectCountryActivity.class);
                intent.putExtra("continent",radioButton.getText().toString());
                startActivity(intent);
                break;
            }
            case R.id.select_continents_exit_btn:{
                finish();
                break;
            }
        }
    }
}
