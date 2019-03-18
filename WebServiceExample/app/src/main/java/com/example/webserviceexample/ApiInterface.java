package com.example.webserviceexample;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("posts.json")
    Call<Posts> getPosts();
}
