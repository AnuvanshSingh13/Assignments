package com.example.notificationstylingandpushnotification;

import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ItemScreenViewModel extends ViewModel {
    private String imageUrl;
    private String price;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @BindingAdapter("bind:imageSrc")
    public static void setImage(ImageView view,String image_url){
        Glide.with(view.getContext())
                .load(image_url)
                .into(view);
    }


}
