package com.example.databindingandviewholder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.databindingandviewholder.viewModel.Main2Activity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void dataBinding(View view) {
        Intent intent=new Intent(StartActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void viewModel(View view) {
        Intent i=new Intent(StartActivity.this, Main2Activity.class);
        startActivity(i);

    }
}
