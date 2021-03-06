package com.example.webserviceexample;

import com.google.gson.annotations.SerializedName;

public class Modal extends BaseResponseModel {
    @SerializedName("name")
    String name;
    @SerializedName("message")
    String message;
    @SerializedName("profileImage")
    String profileImage;

    public Modal(String name, String message, String profileImage) {
        this.name = name;
        this.message = message;
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}

