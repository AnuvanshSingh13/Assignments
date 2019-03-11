package com.example.databaseexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.databaseexample.R;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public ImageView deleteEmployee;
    public  ImageView editEmployee;
    public EmployeeViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.employee_name);
        deleteEmployee = itemView.findViewById(R.id.delete_employee);
        editEmployee = itemView.findViewById(R.id.edit_employee);
    }
}