package com.example.webserviceexample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String baseUrl="https://storage.googleapis.com/network-security-conf-codelab.appspot.com/v2/";

    public static Retrofit getRetrofitInstance(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }return retrofit;
    }
}
