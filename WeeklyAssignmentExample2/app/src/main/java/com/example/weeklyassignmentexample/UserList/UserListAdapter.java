package com.example.weeklyassignmentexample.UserList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.weeklyassignmentexample.Model.Datum;
import com.example.weeklyassignmentexample.R;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UsersListViewHolder> {

    private List<Datum> userModelList;
    private IUserDetailsListener userDetailsListener;

    @NonNull
    @Override
    public UsersListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new UsersListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowitem_users_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final UsersListViewHolder usersListViewHolder, final int i) {
        final Datum userModel = userModelList.get(i);
        usersListViewHolder.tv_user_id.setText(String.valueOf(userModel.getId()));
        usersListViewHolder.tv_first_name.setText(userModel.getFirstName());
        usersListViewHolder.tv_last_name.setText(userModel.getLastName());
        Glide.with(usersListViewHolder.itemView.getContext())
                .load(userModel.getAvatar())
                .into(usersListViewHolder.iv_profile_image);
        Glide.with(usersListViewHolder.itemView.getContext())
                .asBitmap()
                .load(userModel.getAvatar())
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        usersListViewHolder.iv_profile_image.setImageBitmap(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
        usersListViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userDetailsListener != null) {
                    userDetailsListener.userDetailsClicked(userModel);
                }
            }
        });

        usersListViewHolder.iv_deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userDetailsListener != null) {
                    userDetailsListener.deleteUser(userModel.getId());
                    userModelList.remove(i);
                    notifyDataSetChanged();


                }

            }
        });
        usersListViewHolder.iv_shareImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userDetailsListener != null) {
                    userDetailsListener.shareUser(userModel);
                }
            }
        });
    }

    void setUserModelList(List<Datum> userModelList) {
        this.userModelList = userModelList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public void setUserDetailsListener(IUserDetailsListener userDetailsListener) {
        this.userDetailsListener = userDetailsListener;
    }


    class UsersListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_user_id, tv_first_name, tv_last_name;
        ImageView iv_deleteUser, iv_shareImage, iv_profile_image;

        public UsersListViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_user_id = itemView.findViewById(R.id.user_id_tv);
            tv_first_name = itemView.findViewById(R.id.first_name_tv);
            tv_last_name = itemView.findViewById(R.id.last_name_tv);
            iv_profile_image = itemView.findViewById(R.id.profile_image_iv);
            iv_deleteUser = itemView.findViewById(R.id.delete_icon);
            iv_shareImage = itemView.findViewById(R.id.share_icon);
        }
    }
}
