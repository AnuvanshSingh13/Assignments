package com.example.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView=findViewById(R.id.textView2);
        intent=getIntent();
        textView.setText("Welcome " + intent.getStringExtra("LoggedInUser"));
    }
    @Override
    public void onBackPressed(){
        Toast.makeText(this, "you will be logged out in 1 sec", Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    finish();
                }

            }
        }).start();
    }
}
