package com.example.roomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.NoteHolder> {
    private List<User> users =new ArrayList<>();
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item,parent,false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        User currentUser = users.get(position);
        holder.textViewTitle.setText(currentUser.getTitle());
        holder.textViewDescription.setText(currentUser.getDescripton());
        holder.textViewPriority.setText(String.valueOf(currentUser.getPriority()));

    }

    @Override
    public int getItemCount() {
        return users.size();
    }
public void setUsers(List<User> users){
        this.users = users;
        notifyDataSetChanged();

}
public User getNoteAt(int position){
        return users.get(position);
}
    class NoteHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewPriority;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle=itemView.findViewById(R.id.text_view_title);
            textViewDescription=itemView.findViewById(R.id.text_view_description);
            textViewPriority=itemView.findViewById(R.id.text_view_priority);
        }
    }
}
