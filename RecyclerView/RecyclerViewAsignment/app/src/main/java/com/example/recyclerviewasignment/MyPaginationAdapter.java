package com.example.recyclerviewasignment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class MyPaginationAdapter extends RecyclerView.Adapter<MyPaginationAdapter.ViewHolder> {
    private List<MyContactsModel> contactNamesList;
    private Context context;


    public MyPaginationAdapter(Context context, List<MyContactsModel> mList) {
        this.contactNamesList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleviewapp, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MyContactsModel myContactsModel = contactNamesList.get(i);
        viewHolder.title.setText(myContactsModel.getTitle());
        viewHolder.address.setText(myContactsModel.getAddress());
    }

    @Override
    public int getItemCount() {
        return contactNamesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView);
            address = itemView.findViewById(R.id.textView2);
        }
    }
}
