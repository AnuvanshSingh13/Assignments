package com.example.layoutassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class LoginLinearLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_linear_layout);
        Toast.makeText(this, "Login page using Linear Layout", Toast.LENGTH_SHORT).show();
    }
}
