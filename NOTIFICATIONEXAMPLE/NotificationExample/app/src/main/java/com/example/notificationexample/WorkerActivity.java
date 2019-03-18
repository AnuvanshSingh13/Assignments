package com.example.notificationexample;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;

import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class WorkerActivity extends Worker {    //work manager demo
    public WorkerActivity(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() { //will state success of task
        displayNotification("To perform WorkManager Demo","Successfully Done");
        return Result.success();

    }
    private void displayNotification(String task,String desc){
        NotificationManager manager= (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);  //setting notification manager

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){ //version check
            NotificationChannel notificationChannel=new NotificationChannel("channel_def","channel_def",NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel); //setting up notification channel

        }//define the UI of notification
        NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext(),"channel_def")
                .setContentTitle(task)
                .setContentText(desc)
                .setSmallIcon(R.mipmap.ic_launcher);
        manager.notify(1,builder.build());
    }
}
