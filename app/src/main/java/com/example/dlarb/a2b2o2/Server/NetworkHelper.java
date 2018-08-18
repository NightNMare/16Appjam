package com.example.dlarb.a2b2o2.Server;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkHelper
{
    final static String url = "http://iwin247.kr";
    final static int port = 3033;

    public static Retrofit retrofit;

    public static JSONService getInstance(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url+":"+port)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(JSONService.class);
    }

}