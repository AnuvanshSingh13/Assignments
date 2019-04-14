
package com.example.weeklyassignmentexample.Model;

import com.google.gson.annotations.SerializedName;

public class LoginRegisterUserModel extends BaseResponseModel {

    @SerializedName("email")
    private String mEmail;
    @SerializedName("password")
    private String mPassword;
    public LoginRegisterUserModel(String email,String password){
        this.mEmail=email;
        this.mPassword=password;
        
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

}
