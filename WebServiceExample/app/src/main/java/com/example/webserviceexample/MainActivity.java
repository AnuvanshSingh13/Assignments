package com.example.webserviceexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mglide(View view) {
        Intent i=new Intent(MainActivity.this,GlideExample.class);
        startActivity(i);
    }

    public void mhttpurl(View view) {
        Intent m=new Intent(MainActivity.this,ActivityTask2.class);
        startActivity(m);
    }

    public void mretrofit(View view) {
        Intent intent=new Intent(MainActivity.this,ActivityTask2.class);
        startActivity(intent);
    }
}
