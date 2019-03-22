package com.example.backgroundtaskexample;


import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;

public class ShowServiceImage
        extends AppCompatActivity implements NetReciever.INetStateChange {

    ImageView imageView;    //imageview to display image
    String downloadUrl;     //url to be used to download file
    ProgressDialog progressDialog;      //progressdialog object to be used
    NetReciever netStateReciever;      //reference variable to instantiate broadcast receiver
    public static final String FILE_NAME_SERVICE = "/DownloadService.jpeg";

    private BroadcastReceiver getLocalBroadcastResult;
    private BroadcastReceiver getLocalBroadcastProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_service_image);
        imageView = findViewById(R.id.imageview_service);

        //setting network connectivity listener and
        //initializing our broadcast receiver to keep track on network status changes
        NetReciever.setConnectivityListener(this);
        netStateReciever = new NetReciever();

        //initializing progress dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(100);
        progressDialog.setMessage("Downloading image.. Press back to cancel download.");
        progressDialog.setCancelable(true);     //allows user to dismiss progressbar using back button
        progressDialog.setCanceledOnTouchOutside(false);    //prevents cancellation when user clicks outside progressbar window
        //obtaining download url from received intent
        downloadUrl = getIntent().getStringExtra("downloadUrl");

        getLocalBroadcastResult = new BroadcastReceiver() {
            //local receiver to set image when it is received
            @Override
            public void onReceive(Context context, Intent intent) {
                //when result obtained is of resultant bitmap type
                Bitmap bitmap = intent.getParcelableExtra("imageBitmap");
                if (bitmap == null)
                    Log.d("download-result", "Bitmap is null");
                imageView.setImageBitmap(bitmap);
            }
        };

        getLocalBroadcastProgress = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //when result obtained is of progressbar's progress type
                int progress = intent.getIntExtra("progress", 0);
                //  Log.d("download-progress", String.valueOf(progress));
                progressDialog.setProgress(progress);
                if (progress >= 100 && progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();
        //binding our broadcast receiver dynamically
        this.registerReceiver(netStateReciever, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        LocalBroadcastManager.getInstance(this).registerReceiver(getLocalBroadcastResult, new IntentFilter("downloadResult"));
        LocalBroadcastManager.getInstance(this).registerReceiver(getLocalBroadcastProgress, new IntentFilter("downloadProgress"));

    }

    @Override
    protected void onStop() {
        super.onStop();
        //unbinding our broadcast receiver dynamically
        this.unregisterReceiver(netStateReciever);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(getLocalBroadcastProgress);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(getLocalBroadcastResult);
    }

    @Override
    protected void onDestroy() {
        //deleting file as soon as the user leaves the activity
        super.onDestroy();
        File file2 = new File(Environment.getExternalStorageDirectory(), FILE_NAME_SERVICE);

        boolean deletedFile2 = false;
        if (file2.exists())
            deletedFile2 = file2.delete();

        Log.d("MainActivity", "if deletedFile2 ?" + deletedFile2);
    }

    @Override
    public void mOnStateChange(boolean isConnected) {
        if (isConnected) {
            DownloadService.stoppedService = false;
            //starting service
            Intent intent = new Intent(this, DownloadService.class);
            intent.putExtra("downloadUrl", downloadUrl);
            startService(intent);
            progressDialog.show();
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    //It cancels the intent service using a thread safe variable in the service class
                    DownloadService.stoppedService = true;      //informing service to stop its execution
                }
            });
        } else {
            DownloadService.stoppedService = true;    //informing service to stop its execution
            if (progressDialog.isShowing())
                progressDialog.dismiss();
        }
    }
}
