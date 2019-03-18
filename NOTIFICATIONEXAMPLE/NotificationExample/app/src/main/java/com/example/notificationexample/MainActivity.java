package com.example.notificationexample;

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

    public void mtaskdef(View view) {   //will fire intent for default notifiction
        Intent i=new Intent(this,Ques2Activity.class);
        startActivity(i);
    }

    public void mtaskwork(View v) { //will fire intent for low notification
        Intent i=new Intent(MainActivity.this,Ques4Activity.class);
        startActivity(i);
    }
}
