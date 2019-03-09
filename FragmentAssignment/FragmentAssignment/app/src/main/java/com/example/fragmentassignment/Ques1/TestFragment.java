package com.example.fragmentassignment.Ques1;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentassignment.R;

public class TestFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        return inflater.inflate(R.layout.activity_testfragment,container,false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("TAG","onActivityCreated Called");
}
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("TAG","onViewCreated Called");

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("TAG","onAttach Called");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG","onCreate Called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG","onDestroy Called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("TAG","onDestroyView Called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("TAG","onDetach Called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG","onPause Called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG","onResume Called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG","onStart Called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG","onStop Called");
    }

}
