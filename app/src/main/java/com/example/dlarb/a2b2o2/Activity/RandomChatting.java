package com.example.dlarb.a2b2o2.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.dlarb.a2b2o2.Adapter.ListViewAdapter;
import com.example.dlarb.a2b2o2.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class RandomChatting extends AppCompatActivity{
    private Socket mSocket;

    ImageView button;
    EditText edit;
    private ListView listview;
    private List<JSONObject> items = new ArrayList<>();
    private ListViewAdapter adapterChatInside;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_chatting);

        edit = (EditText) findViewById(R.id.text);
        button = findViewById(R.id.send);


//        listview = (ListView) findViewById(R.id.);
//        listview.setFooterDividersEnabled(false);
//        listview.setHeaderDividersEnabled(false);
//        listview.setDividerHeight(0);
//        adapterChatInside = new ListViewAdapter(items, this);
//        listview.setAdapter(adapterChatInside);
        mSocket.connect();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = edit.getText().toString();
                mSocket.emit("chat message", msg);
                JSONObject json = new JSONObject();
                try {
                    json.put("who", "me");
                    json.put("msg", msg);
                    addChat(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                edit.setText("");
            }
        });
        mSocket.on("send message", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject) args[0];
                JSONObject json = new JSONObject();
                try {
                    json.put("who", "other");
                    json.put("msg", data.getString("msg"));
                    addChat(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void addChat(JSONObject json) {
        items.add(json);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapterChatInside.notifyDataSetChanged();
            }
        });
    }


    {
        try {
            mSocket = IO.socket("http://iwin247.kr");
        } catch (URISyntaxException e) {
        }
    }

}