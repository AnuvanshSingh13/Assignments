package com.example.activityintentassignment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {
    TextView name, email, phone;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        name = findViewById(R.id.text);
        email = findViewById(R.id.text2);
        phone = findViewById(R.id.text3);
        image = findViewById(R.id.image);

        Intent recievedIntent = getIntent();
        name.setText(recievedIntent.getExtras().getString("name"));
        email.setText(recievedIntent.getExtras().getString("email"));
        phone.setText(recievedIntent.getExtras().getString("phone"));
        image.setImageBitmap((Bitmap) recievedIntent.getExtras().getParcelable("image"));

    }
}
