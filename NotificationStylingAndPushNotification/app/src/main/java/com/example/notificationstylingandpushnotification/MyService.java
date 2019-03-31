package com.example.notificationstylingandpushnotification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyService extends FirebaseMessagingService {
private static final int REQCODE=1;
private static final String CHNL_ID="notification";
private static final int ID=2;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d("Service","DataFetched");

        if (remoteMessage.getData().size()>0){
            String imageUrl=remoteMessage.getData().get("imageUrl");
            String price=remoteMessage.getData().get("price");
            Intent intent=new Intent(getApplicationContext(),ItemActivity.class);
            Bundle bundle=new Bundle();
            bundle.putString("imageUrl",imageUrl);
            bundle.putString("price",price);
            intent.putExtras(bundle);
            PendingIntent pendingIntent=PendingIntent.getActivity(this,REQCODE,intent,PendingIntent.FLAG_ONE_SHOT);

            if (Build.VERSION.SDK_INT>Build.VERSION_CODES.O){
                CharSequence channelName="Firebase Notification";
                NotificationChannel notificationChannel=new NotificationChannel(CHNL_ID,channelName, NotificationManager.IMPORTANCE_HIGH);
                String channelDescription="Firebase Notification Description";
                notificationChannel.setDescription(channelDescription);

                NotificationManager notificationManager =getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(notificationChannel);

            }
            final NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHNL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(remoteMessage.getNotification().getTitle())
                    .setContentText(remoteMessage.getNotification().getBody())
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            Glide.with(this)
                    .asBitmap()
                    .load(imageUrl)
                    .centerCrop()
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                            NotificationCompat.BigPictureStyle bigPictureStyle =new NotificationCompat.BigPictureStyle().bigPicture(resource);
                            bigPictureStyle.setSummaryText("Image Description");
                            builder.setStyle(bigPictureStyle);
                            NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(getApplicationContext());
                            notificationManagerCompat.notify(ID,builder.build());

                        }
                    });


        }
    }
}
