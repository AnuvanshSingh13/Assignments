package com.example.notificationexample;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ques2Activity extends AppCompatActivity {
    //Definining the channel id
    private static final String CHANNEL_DEF = "channel_id";
   private static final String CHANNEL_MIN="channel_min";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques2);
    }

    public void mNotify(View view) { //Onclick method to call the notification thread

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //Executer service to perform notification in Sequencial way
        try{
            //thread will work till 10 times
            for (int i=0;i<10;i++){
            executorService.execute(t1);
        executorService.execute(t2);}
          }
        finally {
            //exiting the executor service
            executorService.shutdown();
        }
    }

    void mNotificationDefault() {       //notification for notification whose importance and priority is high, as it will perform sound
        String channelName = "Channel_Default";     //channel name for sound notification
        String channelDescription = "Channel shows Def. Notification";  //channel description for sound notification
        String title = "Default Notification";  //setting title for for sound notification
        String text = "Sound Enable";   //setting text for sound notification
        if (Build.VERSION.SDK_INT >= 26) {  //checks the sdk version
            int importance = NotificationManager.IMPORTANCE_HIGH;   //setting importance
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_DEF, channelName, importance);    //setting notification channel
            notificationChannel.setDescription(channelDescription);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_DEF) //setting notification builder that will define UI of notification
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(text)
                .setVibrate(new long[]{200,500,200})
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);   //setting notification manager
        notificationManagerCompat.notify(121,builder.build());
    }



    void mNotificationMinimum(){            //notification for notification whose importance and priority is min
        String channelName="Channel_Minimum";       //channel name for min notification
        String channelDescription ="Channel shows Min. Notification";       //channel description for min notification
        String title="Minimum Notification";      //setting title for for min notification
        String text="Sound Disabled";       //setting text for min notification
        if (Build.VERSION.SDK_INT >= 26) {      //checks the sdk version
            int importance = NotificationManager.IMPORTANCE_LOW;        //setting importance
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_MIN, channelName, importance);        //setting notification channel
            notificationChannel.setDescription(channelDescription);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_MIN)     //setting notification builder that will define UI of notification
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_LOW);

        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);   //setting notification manager
        notificationManagerCompat.notify(125,builder.build());

    }
    Thread t1=new Thread(new Runnable() {
        @Override
        public void run() { //thread to execute the sound notification
            mNotificationDefault();
            try {
                Thread.sleep(60*1000);  //sleep for 1 min
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    Thread t2=new Thread(new Runnable() {
        @Override
        public void run() { //thread to execute min notification
            mNotificationMinimum();
            try {
                Thread.sleep(60*1000);      //sleep for 1 min
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
}
