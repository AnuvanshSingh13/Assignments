package com.example.databindingandviewholder;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.databindingandviewholder.databinding.RowItemBinding;

public class MyViewHolder extends RecyclerView.ViewHolder {
    RowItemBinding binding;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        binding=DataBindingUtil.bind(itemView);
    }

    public void bind(DataModal item){
        binding.setModal(item);
    }
}
