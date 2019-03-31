package com.example.databindingandviewholder;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.databindingandviewholder.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    List<DataModal>dataModals=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        populateData();
        MyAdapter myAdapter =new MyAdapter(dataModals);
        activityMainBinding.recyclerView.setAdapter(myAdapter);


    }

    private void populateData() {

        dataModals.add(new DataModal("Anuvansh","anuvanshingh@gmail.com",961671600));
        dataModals.add(new DataModal("Aman","amaningh@gmail.com",961671601));
        dataModals.add(new DataModal("Ashu","ashutosh@gmail.com",961671602));
        dataModals.add(new DataModal("Aditya","aditya@gmail.com",961671603));
        dataModals.add(new DataModal("Aparna","aparna@gmail.com",961671604));
        dataModals.add(new DataModal("Mandeep","mandeep@gmail.com",961671607));
        dataModals.add(new DataModal("Yash","yash@gmail.com",961671608));
        dataModals.add(new DataModal("Anuvansh","anuvanshingh@gmail.com",961671600));
        dataModals.add(new DataModal("Aman","amaningh@gmail.com",961671601));
        dataModals.add(new DataModal("Ashu","ashutosh@gmail.com",961671602));
        dataModals.add(new DataModal("Aditya","aditya@gmail.com",961671603));
        dataModals.add(new DataModal("Aparna","aparna@gmail.com",961671604));
        dataModals.add(new DataModal("Mandeep","mandeep@gmail.com",961671607));
        dataModals.add(new DataModal("Yash","yash@gmail.com",961671608));

    }
}
