package com.example.dlarb.a2b2o2.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dlarb.a2b2o2.R;
import com.example.dlarb.a2b2o2.Server.JSONService;
import com.example.dlarb.a2b2o2.Server.NetworkHelper;
import com.example.dlarb.a2b2o2.Server.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText id;
    EditText passwd;
    Button register;
    ProgressDialog progress_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        id = findViewById(R.id.id);
        passwd = findViewById(R.id.passwd);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress_dialog = new ProgressDialog(LoginActivity.this);
                progress_dialog.setMessage("로그인 중입니다");
                progress_dialog.show();
                Call<User> call = NetworkHelper.getInstance().signin(id.getText().toString(), passwd.getText().toString());
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.e("error", response.message() +"     "+ response.code());
                        if (response.code() == 200) {
                            User user = response.body();
                            if (user != null) {
                                Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
                                Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                                loginIntent.putExtra("name", user.id);
                                loginIntent.putExtra("id", id.getText().toString());
                                startActivity(loginIntent);
                            }
                        } else if (response.code() == 404) {
                            Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        progress_dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "요청 실패", Toast.LENGTH_SHORT).show();
                    }

                });
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerintent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerintent);
            }
        });
    }
}
