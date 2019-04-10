package com.example.sociallogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);
        TextView mName,mEmail;
        ImageView mImage;
        mName=findViewById(R.id.Name);
        mEmail=findViewById(R.id.Email);
        mImage=findViewById(R.id.image);
        Intent intent=getIntent();
        mName.setText(intent.getStringExtra("name"));
        mEmail.setText(intent.getStringExtra("email"));
        Glide.with(this).load(intent.getStringExtra("profile")).into(mImage);
    }
}
