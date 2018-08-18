package com.example.dlarb.a2b2o2.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dlarb.a2b2o2.R;
import com.example.dlarb.a2b2o2.Server.Chat;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    List<JSONObject> items = new ArrayList<>();
    Context mContext;

    public ListViewAdapter(List<JSONObject> items,Context context) {
        this.items = items;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        JSONObject jsonItem = items.get(position);
        Drawable background = null;
        String msg = "";

        View view = LayoutInflater.from(mContext).inflate(R.layout.chat, null);
        LinearLayout container = (LinearLayout) view.findViewById(R.id.container);
        TextView chat_card = (TextView) view.findViewById(R.id.chat_box);

        try{
            if(jsonItem.getString("who").equals("me")){
                container.setGravity(Gravity.RIGHT);
                background = container.getResources().getDrawable(R.mipmap.right, mContext.getTheme());
            } else {
                background = container.getResources().getDrawable(R.mipmap.left, mContext.getTheme());
            }
            msg = jsonItem.getString("msg");
        } catch (JSONException e){
            e.printStackTrace();
        }
        chat_card.setBackground(background);
        chat_card.setText(msg);

        return view;
    }
}
