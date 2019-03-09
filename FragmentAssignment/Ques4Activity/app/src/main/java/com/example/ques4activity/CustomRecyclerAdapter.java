package com.example.ques4activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerViewHolder> {
    private List<String> items;
    ClickHandler clickHandler;

    public CustomRecyclerAdapter(List<String> items, ClickHandler clickHandler) {
        this.items = items;
        this.clickHandler = clickHandler;
    }

    @NonNull
    @Override
    public CustomRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowitem, viewGroup, false);
        return new CustomRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerViewHolder customRecyclerViewHolder, final int i) {
        customRecyclerViewHolder.rowText.setText(items.get(i));
        customRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickHandler.onItemClickListener(items.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
