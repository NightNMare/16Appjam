package com.example.dlarb.a2b2o2.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.dlarb.a2b2o2.R;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class RandomChatting extends AppCompatActivity {

    Socket mSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_chatting);


        try {
            mSocket = IO.socket("http://iwin247.kr");
            mSocket.connect();
        } catch(URISyntaxException e) {
            e.printStackTrace();
        }
    }
}