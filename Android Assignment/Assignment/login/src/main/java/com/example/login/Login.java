package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Intent incomingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=findViewById(R.id.editText2);
        e2=findViewById(R.id.editText3);
        incomingIntent=getIntent();
    }
    public void login(View view){
        String userId=e1.getText().toString().trim();
        String passwd=e2.getText().toString().trim();
        if (userId.isEmpty() || passwd.isEmpty()){
            Toast.makeText(this, "Email or password is empty", Toast.LENGTH_SHORT).show();
        }else{
            switch (userId){
                case "abc@gmail.com": {
                    if (passwd.equals("12345"))
                        sendResult("abc@gmail.com");
                    break;
                }
                case "abcd":{
                    if (passwd.equals("12345"))
                        sendResult("abcd@gmail.com");
                    break;
                }
                case "abcde":{
                    if (passwd.equals("12345"))
                        sendResult("abcde@gmail.com");
                    break;
                }
                default:{
                    Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }

    private void sendResult(String userid) {
        Intent returnIntent=new Intent();
        returnIntent.putExtra("userid",userid);
        setResult(RESULT_OK,returnIntent);
        finish();
    }
}
