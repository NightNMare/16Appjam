package com.example.dlarb.a2b2o2.Server;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface JSONService {

    @FormUrlEncoded
    @POST("/signin")
    Call<User> signin(@Field("id") String id, @Field("passwd") String passwd);

    @FormUrlEncoded
    @POST("/signup")
    Call<User> signup(@Field("id") String id, @Field("passwd") String passwd, @Field("phone") String phone, @Field("her") String her);
}
