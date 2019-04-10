package com.example.sociallogin;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        GoogleSignInAccount account = getIntent().getParcelableExtra("data");

        TextView mName,mEmail;
        ImageView mImage;
        mName=findViewById(R.id.Name);
        mEmail=findViewById(R.id.Email);
        mImage=findViewById(R.id.image);

        if(account!=null){
            mName.setText(account.getDisplayName());
            mEmail.setText(account.getEmail());

            Glide.with(Details.this)
                    .load(account.getPhotoUrl())
                    .into(mImage);

        }
    }
}
