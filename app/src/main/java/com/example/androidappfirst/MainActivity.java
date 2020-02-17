package com.example.androidappfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
public Button convert;
public EditText inr;
public static EditText usd;
public String ch;
public static String best;
public static String bn;
public Spinner sp;
public Spinner sp1;
public String s;
public String s1;

public String[] currency={"INRtoUSD","USDtoINR","INRtoUSD","EURtoUSD","INRtoEUR","USDtoEUR"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convert=findViewById(R.id.button);
        inr=findViewById(R.id.e2);
        usd=findViewById(R.id.e1);
        sp=findViewById(R.id.sp);
        sp1=findViewById(R.id.sp1);

        List<String> l=new ArrayList<>();
        l.add(0,"SELECT CURRENCY");
        l.add(1,"INR");
        l.add(2,"USD");
        l.add(3,"EUR");



        ArrayAdapter<String>a =new ArrayAdapter(this,android.R.layout.simple_spinner_item,l);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(a);
        sp1.setAdapter(a);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(sp.getSelectedItem()!="SELECT CURRENCY"){
                s = sp.getSelectedItem().toString();}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (sp1.getSelectedItem()!="SELECT CURRENCY"){
                s1=sp1.getSelectedItem().toString();}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(inr.equals(null)){
                 Toast toast=Toast.makeText(getApplicationContext(),"Please Enter Value",Toast.LENGTH_LONG);

            }

            String s3=s+"to"+s1;
            System.out.println(s3);
        bn=String.valueOf(inr.getText());
            back mytask= new back();
            ch= s3;
            switch (ch){
                case "EURtoINR":
                    mytask.execute("https://fcsapi.com/api/crypto/converter?pair1=INR&pair2=EUR&amount=200&access_key=zw3QWDE1DPKK74wx13mGF630WvlFxTTwU0rsEf3a01pC3JnMMb");
                    best="price_1x_INR";
                    break;
                case "USDtoINR":
                    mytask.execute("https://fcsapi.com/api/crypto/converter?pair1=INR&pair2=USD&amount=200&access_key=zw3QWDE1DPKK74wx13mGF630WvlFxTTwU0rsEf3a01pC3JnMMb");
                    best="price_1x_INR";
                    break;
                case "INRtoINR":
                    mytask.execute("https://fcsapi.com/api/crypto/converter?pair1=INR&pair2=INR&amount=200&access_key=zw3QWDE1DPKK74wx13mGF630WvlFxTTwU0rsEf3a01pC3JnMMb");
                    best="price_1x_INR";
                    break;
                case "USDtoUSD":
                    mytask.execute("https://fcsapi.com/api/crypto/converter?pair1=USD&pair2=USD&amount=200&access_key=zw3QWDE1DPKK74wx13mGF630WvlFxTTwU0rsEf3a01pC3JnMMb");
                    best="price_1x_USD";
                    break;
                case "INRtoUSD":
                    mytask.execute("https://fcsapi.com/api/crypto/converter?pair1=USD&pair2=INR&amount=200&access_key=zw3QWDE1DPKK74wx13mGF630WvlFxTTwU0rsEf3a01pC3JnMMb");
                    best="price_1x_USD";
                    break;
                case "EURtoUSD":
                    mytask.execute("https://fcsapi.com/api/crypto/converter?pair1=USD&pair2=EUR&amount=200&access_key=zw3QWDE1DPKK74wx13mGF630WvlFxTTwU0rsEf3a01pC3JnMMb");
                    best="price_1x_USD";
                    break;
                case "INRtoEUR":
                    mytask.execute("https://fcsapi.com/api/crypto/converter?pair1=EUR&pair2=INR&amount=200&access_key=zw3QWDE1DPKK74wx13mGF630WvlFxTTwU0rsEf3a01pC3JnMMb");
                    best="price_1x_EUR";
                    break;
                case "USDtoEUR":
                    mytask.execute("https://fcsapi.com/api/crypto/converter?pair1=EUR&pair2=USD&amount=200&access_key=zw3QWDE1DPKK74wx13mGF630WvlFxTTwU0rsEf3a01pC3JnMMb");
                    best="price_1x_EUR";
                    break;
                case "EURtoEUR":
                    mytask.execute("https://fcsapi.com/api/crypto/converter?pair1=EUR&pair2=EUR&amount=200&access_key=zw3QWDE1DPKK74wx13mGF630WvlFxTTwU0rsEf3a01pC3JnMMb");
                    best="price_1x_EUR";
                    break;

            }
        }
    });

    }


}
