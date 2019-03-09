package com.example.fragmentassignment.Ques2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.fragmentassignment.R;

public class Task2Activity extends AppCompatActivity {
    private static final String TAG = "task2-activity";
    private static final String FRG1 = "fragment1";
    private static final String FRG2 = "fragment2";
    Button addFragment1, removeFragment1, replaceWithFragment1;
    Button addFragment2, removeFragment2, replaceWithFragment2;
    Task2Fragment1 task2Fragment1;
    Task2Fragment2 task2Fragment2;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        Log.d(TAG, "Activity onCreate");
        addFragment1 = findViewById(R.id.addFragment1);
        removeFragment1 = findViewById(R.id.removeFragment1);
        replaceWithFragment1 = findViewById(R.id.replaceWithFragment1);
        addFragment2 = findViewById(R.id.addFragment2);
        removeFragment2 = findViewById(R.id.removeFragment2);
        replaceWithFragment2 = findViewById(R.id.replaceWithFragment2);
        task2Fragment1 = new Task2Fragment1();
        task2Fragment2 = new Task2Fragment2();
        fragmentManager = getSupportFragmentManager();


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Activity onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Activity onResume");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Activity onRestart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Activity onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Activity onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activity onDestroy");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "---------------onBackPressed----------------");
    }

    public void addFrg1(View view) {
        if (!task2Fragment1.isAdded()) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.frame_activity_task2, task2Fragment1, FRG1);
            fragmentTransaction.commit();
            Log.d(TAG, "*****Add Fragment 1*****");
        }
    }

    public void remFrg1(View view) {
        if (fragmentManager.findFragmentByTag(FRG1) != null) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(task2Fragment1);
            fragmentTransaction.commit();
            Log.d(TAG, "*****Remove Fragment 1*****");
        }
    }

    public void replaceWithFrg1(View view) {
        if (fragmentManager.findFragmentById(R.id.frame_activity_task2) != null && !task2Fragment1.isAdded()) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_activity_task2, task2Fragment1, FRG1);
            fragmentTransaction.commit();
            Log.d(TAG, "*****Replacing with Fragment 1*****");
        }
    }

    public void addFrg2(View view) {
        if (!task2Fragment2.isAdded()) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.frame_activity_task2, task2Fragment2, FRG2);
            fragmentTransaction.commit();
            Log.d(TAG, "*****Add Fragment 2*****");
        }
    }

    public void remFrg2(View view) {
        if (fragmentManager.findFragmentByTag(FRG2) != null) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(task2Fragment2);
            fragmentTransaction.commit();
            Log.d(TAG, "*****Remove Fragment 2*****");
        }
    }

    public void replaceWithFrg2(View view) {
        if (fragmentManager.findFragmentById(R.id.frame_activity_task2) != null && !task2Fragment2.isAdded()) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_activity_task2, task2Fragment2, FRG2);
            fragmentTransaction.commit();
            Log.d(TAG, "*****Replacing with Fragment 2*****");
        }
    }

    public void showFrg1(View view) {
        if (task2Fragment1.isAdded() && task2Fragment1.isHidden()) {
            Log.d(TAG, "*****Show Fragment 1*****");
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.show(task2Fragment1);
            fragmentTransaction.commit();
        }
    }

    public void hideFrg1(View view) {
        if (task2Fragment1.isAdded() && !task2Fragment1.isHidden()) {
            Log.d(TAG, "*****Hide Fragment 1*****");
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.hide(task2Fragment1);
            fragmentTransaction.commit();
        }
    }

    public void showFrg2(View view) {
        if (task2Fragment2.isAdded() && task2Fragment2.isHidden()) {
            Log.d(TAG, "*****Show Fragment 2*****");
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.show(task2Fragment2);
            fragmentTransaction.commit();
        }
    }

    public void hideFrg2(View view) {
        if (task2Fragment2.isAdded() && !task2Fragment2.isHidden()) {
            Log.d(TAG, "*****Hide Fragment 2*****");
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.hide(task2Fragment2);
            fragmentTransaction.commit();
        }

    }
}