package com.example.notificationstylingandpushnotification;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.notificationstylingandpushnotification.databinding.ActivityItemBinding;

public class ItemActivity extends AppCompatActivity {
    ItemScreenViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        viewModel= ViewModelProviders.of(this).get(ItemScreenViewModel.class);
        ActivityItemBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_item);
        binding.setViewModel(viewModel);
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            viewModel.setImageUrl(bundle.getString("imageUrl"));
            viewModel.setPrice(bundle.getString("price"));
        }
    }
}
