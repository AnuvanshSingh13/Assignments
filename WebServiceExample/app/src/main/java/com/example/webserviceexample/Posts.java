package com.example.webserviceexample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Posts extends BaseResponseModel {
    @SerializedName("posts")
    private List<Modal>list;
    public List<Modal>getList(){
        return list;
    }
}
