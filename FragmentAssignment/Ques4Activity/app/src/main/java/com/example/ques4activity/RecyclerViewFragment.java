package com.example.ques4activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFragment extends Fragment {

    RecyclerView recyclerView;
    ClickHandler clickHandler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<String> items = new ArrayList();
        items.add("aman");
        items.add("anuvansh");
        items.add("aditya");
        items.add("ashutosh");
        items.add("aparna");
        items.add("anuja");
        items.add("pallavi");
        items.add("vidit");
        CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(items, clickHandler);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        clickHandler = (ClickHandler) context;
    }
}
