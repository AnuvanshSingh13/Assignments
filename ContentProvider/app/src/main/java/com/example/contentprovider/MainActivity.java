package com.example.contentprovider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int QUES2_PERMISSION_REQ_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void mQues1(View view) {
        startActivity(new Intent(MainActivity.this,Ques1Activity.class));
    }

    public void mQues2(View view) {
        checkAndRequestPermission();
    }
    void checkAndRequestPermission() {
        //if device used is running on android 23 or above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, QUES2_PERMISSION_REQ_CODE);
            } else {
                //permission granted
                startActivity(new Intent(MainActivity.this, Ques2Activity.class));
            }
        } else {
            //permission granted for devices below 23
            startActivity(new Intent(MainActivity.this, Ques2Activity.class));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == QUES2_PERMISSION_REQ_CODE
                && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED
                && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
            //both permission granted
            startActivity(new Intent(MainActivity.this, Ques2Activity.class));
        } else {
            //permission not granted
            Toast.makeText(this, "READ/WRITE STORAGE PERMISSION REQUIRED", Toast.LENGTH_SHORT).show();
        }
    }
}
