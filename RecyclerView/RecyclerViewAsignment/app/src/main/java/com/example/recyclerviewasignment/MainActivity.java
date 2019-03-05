package com.example.recyclerviewasignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<MyContactsModel> myContactsModelList;
    private MyContactsAdapter contactsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerViewContactList = findViewById(R.id.recycler_view_list);
        recyclerViewContactList.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewContactList.setHasFixedSize(true);
        myContactsModelList = new ArrayList<>();

        contactsAdapter = new MyContactsAdapter(this, myContactsModelList);
        recyclerViewContactList.setAdapter(contactsAdapter);

        initData();
    }

    private void initData() {
        MyContactsModel myContactsModel;
        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        myContactsModelList.add(myContactsModel);
    }
}
