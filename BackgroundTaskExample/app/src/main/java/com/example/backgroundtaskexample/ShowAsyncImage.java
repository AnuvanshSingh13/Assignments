package com.example.backgroundtaskexample;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ShowAsyncImage extends AppCompatActivity implements NetReciever.INetStateChange {


    private static final String TAG = "ShowImageUsingAsyncTask";
    ImageView imageView;
    ProgressDialog progressDialog;
    String downloadFileUrl;
    NetReciever netStateReciever;
    boolean resumeDownload = true;
    public static final String FILE_NAME_ASYNC = "/DownloadAsync.jpeg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_async_image);
        imageView = findViewById(R.id.imageview_async);
        NetReciever.setConnectivityListener(this);
        netStateReciever = new NetReciever();
        //initializing progress dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(100);
        progressDialog.setMessage("Downloading image.. Press back to cancel download.");
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);

        //obtaining download url string from received intent
        downloadFileUrl = getIntent().getStringExtra("downloadUrl");


    }

    //registering receiver
    @Override
    protected void onStart() {
        super.onStart();
        this.registerReceiver(netStateReciever, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    //unregistering receiver
    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(netStateReciever);
    }

    //Deleting file as soon as its user leaves activity
    @Override
    protected void onDestroy() {
        super.onDestroy();
        File file1 = new File(Environment.getExternalStorageDirectory(), FILE_NAME_ASYNC);
        boolean deletedFile1 = false;
        if (file1.exists())
            deletedFile1 = file1.delete();
        Log.d("MainActivity", "deletedFile1=" + deletedFile1);
    }


    @Override
    public void mOnStateChange(boolean isConnected) {
        if (isConnected && resumeDownload) {
            Toast.makeText(this, "Network available and connected", Toast.LENGTH_SHORT).show();
            //execute async task
            new DownloadFileTask().execute(downloadFileUrl);
        } else {
            Toast.makeText(this, "Network not available OR Download cancelled.", Toast.LENGTH_SHORT).show();
            if (progressDialog.isShowing())
                progressDialog.dismiss();
        }
        //pause downloading if network is not available
    }

    //Creating async task to download file
    private class DownloadFileTask extends AsyncTask<String, Integer, Bitmap> {
        //Async task with downloadUrl as input and Bitmap as the output
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //handling backpress when progressdialog is showing
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    cancel(true);
                    Log.d("ShowImageUsingAsyncTask", "cancel called");
                }
            });
            progressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... downloadUrl) {
            InputStream inputStream = null;
            OutputStream outputStream = null;
            HttpURLConnection httpURLConnection = null;
            Bitmap resultBitmap = null;
            int progress = 0;
            try {
                URL url = new URL(downloadUrl[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();

                File file = new File(Environment.getExternalStorageDirectory(), FILE_NAME_ASYNC);
                //downloaded is used to store size of local temporary file
                long downloaded = 0;

                //downloadFileSize is the size of data to be downloaded
                long downloadFileSize = url.openConnection().getContentLength();

                //checking if file exists and is not downloaded completely
                if (file.exists() && file.length() < downloadFileSize) {
                    downloaded = file.length();
                    httpURLConnection.setRequestProperty("Range", "bytes=" + downloaded + "-");

                } else if (file.exists() && file.length() == downloadFileSize) {
                    resultBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                    return resultBitmap;
                } else {
                    boolean ifcreatedFile = file.createNewFile();
                    //if file doesn't exists in the system, create a new file
                    Log.d(TAG, "if created new file? " + ifcreatedFile);
                }

                //establishing connection and obtaning input stream
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();

                if (downloaded > 0 && downloaded < downloadFileSize) {
                    outputStream = new FileOutputStream(file, true);
                    progress = (int) (downloaded * 100 / downloadFileSize);
                } else
                    outputStream = new FileOutputStream(file);


                //creating buffer of one kB
                byte[] data = new byte[1024];
                int receivedKB;
                long totalReceivedKB = 0;

                //reading 1024 bit of data in buffer 'data' until it reads till end of file
                while ((receivedKB = inputStream.read(data)) != -1) {
                    if (isCancelled()) {
                        //checking if async task execution has not been cancelled
                        resumeDownload = false;     //setting download to do not resume on connectivity status change
                        Log.d(TAG, "AsyncCancellationCheck " + "task cancelled");
                        break;
                    } else {
                        //writing buffer data into the output stream associated with file
                        outputStream.write(data, 0, receivedKB);
                        totalReceivedKB = totalReceivedKB + receivedKB;
                        publishProgress(progress + (int) (totalReceivedKB * 100 / downloadFileSize));
                    }

                }

                //releasing resources and closing streams
                outputStream.flush();
                outputStream.close();
                inputStream.close();
                httpURLConnection.disconnect();

                //obtainig bitmap from file
                resultBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return resultBitmap;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            progressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
            if (progressDialog.isShowing())
                progressDialog.dismiss();
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Toast.makeText(ShowAsyncImage.this, "Download is cancelled.", Toast.LENGTH_SHORT).show();
        }

    }

}
