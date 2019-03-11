package com.example.sharedpreferencesexample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {
    Button bu;
    Button bu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bu= findViewById(R.id.button2);
        bu2= findViewById(R.id.button3);
    }

    public  void logout(View view){
        SharedPreferences sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.apply();
        editor.commit();
        Intent intent=new Intent(SecondActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void close(View view){
        finish();
    }
}
