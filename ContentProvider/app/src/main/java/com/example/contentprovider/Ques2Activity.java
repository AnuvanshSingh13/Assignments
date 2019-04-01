package com.example.contentprovider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ques2Activity extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques2);
    }

    public void mShareInternalFile(View view) {
        try {
            //storing dumy file into internal storage area
            Bitmap bitmapInternal = BitmapFactory.decodeResource(getResources(), R.drawable.dumy1);
            File internalRootDirectory = getFilesDir();
            File internalSavingDir = new File(internalRootDirectory, "dumy_images");
            if (!internalSavingDir.exists())
                internalSavingDir.mkdirs();

            File fileInternal = new File(internalSavingDir, "dumy.jpg");
            if (fileInternal.exists()) {
                fileInternal.delete();
            }
            fileInternal.createNewFile();
            OutputStream outputStreamInternal = new FileOutputStream(fileInternal);
            bitmapInternal.compress(Bitmap.CompressFormat.JPEG, 25, outputStreamInternal);
            outputStreamInternal.flush();
            outputStreamInternal.close();

            //sharing file using file provider
            Intent shareIntentInternal = new Intent();
            shareIntentInternal.setAction(Intent.ACTION_SEND);
            shareIntentInternal.setType("image/*");
            shareIntentInternal.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", fileInternal));
            shareIntentInternal.putExtra(Intent.EXTRA_TEXT, "Sharing image from app's internal memory space");
            shareIntentInternal.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(shareIntentInternal, "Share using"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mShareExternalFile(View view) {
        try {
            //storing dumy file into external storage area
            Bitmap bitmapExternal = BitmapFactory.decodeResource(getResources(), R.drawable.dumy2);
            File externalRootDirectory = Environment.getExternalStorageDirectory();
            File externalSavingDir = new File(externalRootDirectory, "dumy_images");
            if (!externalSavingDir.exists())
                externalSavingDir.mkdirs();
            File fileExternal = new File(externalSavingDir, "dumy.jpg");
            if (fileExternal.exists()) {
                fileExternal.delete();
            }
            fileExternal.createNewFile();
            OutputStream outputStreamExternal = new FileOutputStream(fileExternal);
            bitmapExternal.compress(Bitmap.CompressFormat.JPEG, 25, outputStreamExternal);
            outputStreamExternal.flush();
            outputStreamExternal.close();

            //sharing file using fileprovider
            Intent shareIntentExternal = new Intent();
            shareIntentExternal.setAction(Intent.ACTION_SEND);
            shareIntentExternal.setType("image/*");
            shareIntentExternal.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", fileExternal));
            shareIntentExternal.putExtra(Intent.EXTRA_TEXT, "Sharing image from app's external memory space");
            shareIntentExternal.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(shareIntentExternal, "Share using"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
