package com.example.dlarb.a2b2o2.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dlarb.a2b2o2.R;
import com.example.dlarb.a2b2o2.Server.NetworkHelper;
import com.example.dlarb.a2b2o2.Server.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText id;
    EditText passwd;
    EditText phone;
    EditText her;

    Button register;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        id = findViewById(R.id.regi_id);
        passwd = findViewById(R.id.regi_passwd);
        phone = findViewById(R.id.regi_phone);
        her = findViewById(R.id.regi_her);
        register = findViewById(R.id.regis_register);
        cancel = findViewById(R.id.regis_cancel);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<User> call = NetworkHelper.getInstance().signup(id.getText().toString(), passwd.getText().toString(), phone.getText().toString(), her.getText().toString());
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.e("error", response.message() +"     "+ response.code());
                        if (response.code() == 200) {
                            User user = response.body();
                            if (user != null) {
                                Toast.makeText(getApplicationContext(), "회원가입 완료", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        } else if (response.code() == 409) {
                            Toast.makeText(getApplicationContext(), "이미 사용중", Toast.LENGTH_SHORT).show();
                        } else if (response.code() == 400) {
                            Toast.makeText(getApplicationContext(), "회원가입 실패", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "나도 모르겠다", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "요청 실패", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
