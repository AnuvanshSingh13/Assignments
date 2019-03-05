package com.example.recyclerviewasignment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class MyContactsAdapter extends RecyclerView.Adapter<MyContactsAdapter.ViewHolder>  {

    private List<MyContactsModel> contactNamesList;
    private Context context;

    public MyContactsAdapter(Context context, List<MyContactsModel> contactNamesList) {
        this.contactNamesList = contactNamesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.recycleviewapp, parent, false);
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
        return  contactNamesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView address;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.textView);
            address=itemView.findViewById(R.id.textView2);


        }
    }
}
