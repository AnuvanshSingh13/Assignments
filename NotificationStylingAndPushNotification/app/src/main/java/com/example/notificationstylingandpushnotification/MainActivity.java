package com.example.notificationstylingandpushnotification;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.notificationstylingandpushnotification.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    String quesdesc;

    public String getQuesdesc() {
        return quesdesc;
    }

    public void setQuesdesc(String quesdesc) {
        this.quesdesc = quesdesc;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setActivity(this);
        String desc="Create two activity.\n" +
                "\n" +
                "Send Notification through fcm, clicking on which should load ItemScreen\n" +
                "\n" +
                "Item price and image url will be sent through fcm and display the image and price there.\n" +
                "\n" +
                "Also if the notification is expanded the image should be shown there.";
        setQuesdesc(desc);
    }
}
