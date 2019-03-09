package com.example.fragmentassignment.Ques3;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.fragmentassignment.R;


public class Task3Activity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    private static final String PREF_FRAG = "preference fragment";
    private static final String DIAG_FRAG = "dialog fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);
        fragmentManager = getFragmentManager();
    }

    public void showPrefFrag(View view) {
        FragmentPref fragmentPref = new FragmentPref();
        if (fragmentManager.findFragmentByTag(PREF_FRAG) == null) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.frame_activity_task3, fragmentPref, PREF_FRAG);
            fragmentTransaction.commit();
        }
    }

    public void showDiagFrag(View view) {
        FragmentDiag fragmentDiag=new FragmentDiag();
        fragmentDiag.show(fragmentManager,DIAG_FRAG);
    }
}