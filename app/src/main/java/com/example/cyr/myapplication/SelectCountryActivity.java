package com.example.cyr.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by yang li on 2016/10/9.
 */
public class SelectCountryActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] aisaCountries={"China","Japan","Korea","Thailand"};
    private String[] euCountries={"Germany","Greece","Italy","France"};
    private String[] naCountries={"Canada","Greenland","Mexico","United States"};
    private String[] saCountries={"Colombia","Chile","Brazil","Peru"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_country);
        String continent= getIntent().getStringExtra("continent");
        RadioGroup countriesRadioGroup = (RadioGroup) findViewById(R.id.countries_rdg);
        String[] countries=getCountriesByContinent(continent);
        for(int i=0;i<4;i++){
            RadioButton radioButton= new RadioButton(this);
            radioButton.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            radioButton.setText(countries[i]);
            countriesRadioGroup.addView(radioButton);
        }
        Button b1=(Button) findViewById(R.id.select_countries_ok_btn);
        Button b2=(Button) findViewById(R.id.select_countries_exit_btn);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select_countries_ok_btn: {
                RadioGroup countriesRadioGroup = (RadioGroup) findViewById(R.id.countries_rdg);
                RadioButton radioButton =(RadioButton) findViewById(countriesRadioGroup.getCheckedRadioButtonId());
                Uri mUri = Uri.parse("geo:0,0?q="+radioButton.getText());
                Intent mIntent = new Intent(Intent.ACTION_VIEW,mUri);
                startActivity(mIntent);
                break;
            }
            case R.id.select_countries_exit_btn:{
                finish();
                break;
            }
        }
    }

    private String[] getCountriesByContinent(String cname)
    {
        if(cname.equals("Asia")){
            return aisaCountries;
        }
        if(cname.equals("Europe")){
            return euCountries;
        }
        if(cname.equals("North America")){
            return  naCountries;
        }
        return  saCountries;
    }
}
