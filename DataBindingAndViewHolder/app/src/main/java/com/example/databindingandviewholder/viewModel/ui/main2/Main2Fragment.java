package com.example.databindingandviewholder.viewModel.ui.main2;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.databindingandviewholder.R;

import java.util.Random;

public class Main2Fragment extends Fragment {
    private ConstraintLayout layout;
    private Button button;


    private Main2ViewModel mViewModel;

    public static Main2Fragment newInstance() {
        return new Main2Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main2_fragment, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button=view.findViewById(R.id.btn);
        layout=view.findViewById(R.id.main2);
        mViewModel = ViewModelProviders.of(this).get(Main2ViewModel.class);
        layout.setBackgroundColor(mViewModel.color);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getColor();
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // layout.setBackgroundColor(mViewModel.color);

    }

    public void getColor(){
        Random random=new Random();
        int color= Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
        mViewModel.color=color;
        layout.setBackgroundColor(color);
    }

}
