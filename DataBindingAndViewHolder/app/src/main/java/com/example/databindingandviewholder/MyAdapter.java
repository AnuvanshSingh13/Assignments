package com.example.databindingandviewholder;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.databindingandviewholder.databinding.RowItemBinding;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<DataModal> items;
    RowItemBinding binding;


    public MyAdapter(List<DataModal> items) {
        this.items = items;
    }

//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        Context context =viewGroup.getContext();
//        LayoutInflater inflater=LayoutInflater.from(context);
//        View statusContainer=inflater.inflate(R.layout.activity_main,viewGroup,false);
//
//        return new MyViewHolder(statusContainer);
//    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=(LayoutInflater)viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding= DataBindingUtil.inflate(inflater, R.layout.row_item, viewGroup, false);
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        DataModal status= items.get(i);
        myViewHolder.bind(status);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
