package com.example.ques4activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;



public class CustomRecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView rowText;
    public CustomRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        rowText=itemView.findViewById(R.id.txt_row);
    }
}
