package com.example.dlarb.a2b2o2.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dlarb.a2b2o2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button RC = findViewById(R.id.random);
        RC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RCintent = new Intent(MainActivity.this,RandomChatting.class);
                startActivityForResult(RCintent,123);

            }
        });
    }
}
