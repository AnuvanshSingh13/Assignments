package com.example.activityintentassignment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int CAMERA_REQUEST = 101;
    public static final int CAMERA_PERMISSION_CODE = 101;
    EditText name,email,phone,password;
    Button imagecapture,submit;
    ImageView imageView;
    private Bitmap imageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.edittext);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.password);
        imageView=findViewById(R.id.image);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            imageBitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(imageBitmap);
        }


    }

    public void capture(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
            } else {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        } else {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        }


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Camera permission granted.", Toast.LENGTH_SHORT).show();
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            } else {
                Toast.makeText(this, "Please provide camera permission.", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void submit(View view) {
       String ename=name.getText().toString();
       String eemail=email.getText().toString();
       String ephone=phone.getText().toString();
       String epassword=password.getText().toString();
       if (ename.isEmpty()||eemail.isEmpty()||ephone.isEmpty()||epassword.isEmpty()){
           Toast.makeText(this, "Fill All the Fields", Toast.LENGTH_SHORT).show();
       }else if (!TextUtils.isDigitsOnly(ephone)){
           Toast.makeText(this, "Enter Correct phone No.", Toast.LENGTH_SHORT).show();
       }else if (!eemail.contains("@")){
           Toast.makeText(this, "Enter valid email", Toast.LENGTH_SHORT).show();
       }else if (false){

       }else{
           Bundle bundle=new Bundle();
           bundle.putString("name",ename);
           bundle.putString("email",eemail);
           bundle.putString("phone",ephone);

           bundle.putParcelable("image", imageBitmap);

            Intent intent=new Intent(MainActivity.this,ShowActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);

       }
    }
}
