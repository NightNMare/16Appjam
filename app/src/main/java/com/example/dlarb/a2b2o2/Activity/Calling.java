package com.example.dlarb.a2b2o2.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dlarb.a2b2o2.R;

import java.net.URI;
import java.net.URL;

public class Calling extends AppCompatActivity {

    TextView One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Zero, shop, star;
    ImageView call;
    TextView number;
    ImageView remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);
        One = findViewById(R.id.TV_one);
        Two = findViewById(R.id.TV_two);
        Three = findViewById(R.id.TV_three);
        Four = findViewById(R.id.TV_four);
        Five = findViewById(R.id.TV_five);
        Six = findViewById(R.id.TV_six);
        Seven = findViewById(R.id.TV_seven);
        Eight = findViewById(R.id.TV_eight);
        Nine = findViewById(R.id.TV_nine);
        Zero = findViewById(R.id.TV_zero);
        call = findViewById(R.id.call_bt);
        star = findViewById(R.id.TV_star);
        shop = findViewById(R.id.TV_shop);
        number = findViewById(R.id.callingtext);
        remove = findViewById(R.id.remove);

        One.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String str = number.getText().toString();
                number.setText(str + "1");
            }
        });
        Two.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String str = number.getText().toString();
                number.setText(str + "2");
            }
        });
        Three.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String str = number.getText().toString();
                number.setText(str + "3");
            }
        });
        Four.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String str = number.getText().toString();
                number.setText(str + "4");
            }
        });
        Five.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String str = number.getText().toString();
                number.setText(str + "5");
            }
        });
        Six.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String str = number.getText().toString();
                number.setText(str + "6");
            }
        });
        Seven.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String str = number.getText().toString();
                number.setText(str + "7");
            }
        });
        Eight.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String str = number.getText().toString();
                number.setText(str + "8");
            }
        });
        Nine.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String str = number.getText().toString();
                number.setText(str + "9");
            }
        });
        Zero.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String str = number.getText().toString();
                number.setText(str + "0");
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("hernum", MODE_PRIVATE);
                String str1 = prefs.getString("hernum", "");
                if (number.getText().toString().equals(str1)) {
                    Intent intentrd = new Intent(Calling.this, RandomChatting.class);
                    startActivity(intentrd);
                    finish();
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number.getText().toString()));
                    Log.e("Error", "Failure phone before");

                }
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = number.getText().toString();
                if(str.length()==0){

                }else {
                    number.setText(str.substring(0, str.length() - 1));
                }
            }
        });


    }
}
