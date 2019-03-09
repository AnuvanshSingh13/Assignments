package com.example.ques4activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;



public class Task4Activity extends AppCompatActivity implements ClickHandler {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);
        fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransactionRecycler = fragmentManager.beginTransaction();
        RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();
        fragmentTransactionRecycler.add(R.id.frame1, recyclerViewFragment);
        fragmentTransactionRecycler.commit();

    }

    @Override
    public void onItemClickListener(String string) {
        FragmentTransaction fragmentTransactionDisplay = fragmentManager.beginTransaction();
        DisplayFragment displayFragment = DisplayFragment.newInstance(string);
        fragmentTransactionDisplay.replace(R.id.frame2, displayFragment);
        fragmentTransactionDisplay.commit();
    }
}
