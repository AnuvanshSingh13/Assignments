package com.example.sharedpreferencesexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1;
    Intent in;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Password = "passkey";
    public static final String Email = "emailKey";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1= findViewById(R.id.editText);
        ed2= findViewById(R.id.editText2);
        ed3= findViewById(R.id.editText3);
        b1= findViewById(R.id.button);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n  = ed1.getText().toString();
                String ph  = ed2.getText().toString();
                String e  = ed3.getText().toString();
                if (n.isEmpty()||ph.isEmpty()||e.isEmpty()){
                Toast.makeText(MainActivity.this, "Fill all the field", Toast.LENGTH_SHORT).show();
            }else{

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, n);
                editor.putString(Password, ph);
                editor.putString(Email, e);
                editor.apply();
                editor.commit();

                in = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(in);
            }
            }
        });
    }
}
