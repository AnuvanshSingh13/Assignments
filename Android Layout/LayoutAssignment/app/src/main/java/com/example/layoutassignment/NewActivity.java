package com.example.layoutassignment;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
    }
    void exer(View view){
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finish();

    }

    public void cise(View view) {
        Intent n=new Intent(this,LoginLinearLayout.class);
        startActivity(n);
        finish();
    }

    public void don(View view) {
        Intent s=new Intent(this,RelativeLayout.class);
        startActivity(s);
        finish();
    }


    public void fone(View view) {
        Intent g=new Intent(this,ContraintLayout.class);
        startActivity(g);
        finish();
    }
}
