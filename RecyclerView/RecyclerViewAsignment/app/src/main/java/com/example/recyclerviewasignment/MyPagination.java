package com.example.recyclerviewasignment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyPagination extends AppCompatActivity {
    private LinearLayoutManager layoutManager;
    private MyPaginationAdapter myPaginationAdapter;
    private boolean isScrolling = false;
    private List<MyContactsModel> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.recycler_view_list);
        layoutManager=new LinearLayoutManager(this);
            mList=new ArrayList<>();
            myPaginationAdapter=new MyPaginationAdapter(this, mList);
            recyclerView.setAdapter(myPaginationAdapter);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.addOnScrollListener(recyclerViewPagination);
        initData();

    }

    private void initData() {
        MyContactsModel myContactsModel;
        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);

        myContactsModel=new MyContactsModel();
        myContactsModel.setTitle("Icecream Sunday");
        myContactsModel.setAddress("145,Mall of India");
        mList.add(myContactsModel);
    }

    private RecyclerView.OnScrollListener recyclerViewPagination=new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true;
            }
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int totalItems = layoutManager.getItemCount();
            int visibleItems = layoutManager.getChildCount();
            int scrolledOutItems = layoutManager.findFirstVisibleItemPosition();
            if (isScrolling && visibleItems + scrolledOutItems == totalItems) {
                Toast.makeText(MyPagination.this, "loading more...", Toast.LENGTH_SHORT).show();
                isScrolling = false;
                fetchData();
            }
        }
    };

    private void fetchData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MyContactsModel myContactsModel = new MyContactsModel();
                myContactsModel.setTitle("Icecream Sunday");
                myContactsModel.setAddress("145,Mall of India");
                mList.add(myContactsModel);

                myContactsModel = new MyContactsModel();
                myContactsModel.setTitle("Icecream Sunday");
                myContactsModel.setAddress("145,Mall of India");
                mList.add(myContactsModel);
                myPaginationAdapter.notifyDataSetChanged();
            }
        },2000);
    }
}
