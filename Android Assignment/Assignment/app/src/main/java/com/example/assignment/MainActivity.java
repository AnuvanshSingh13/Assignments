package com.example.assignment;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.login.Login;


public class MainActivity extends AppCompatActivity {
    final int REQCODE=1001;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivityForResult(new Intent(getApplicationContext(),Login.class),REQCODE);
                }
            }
        });
        thread.start();


}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==RESULT_OK){
            userId=data.getStringExtra("userid");
            Toast.makeText(this,"Logged in as" + userId,Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
            intent.putExtra("LoggedInUser", userId);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "Could'nt Log In..Please try Again", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
