package com.example.fragmentassignment.Ques3;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.fragmentassignment.R;

public class FragmentPref extends PreferenceFragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_screen);

    }
}