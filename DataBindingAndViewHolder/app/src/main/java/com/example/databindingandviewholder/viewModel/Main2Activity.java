package com.example.databindingandviewholder.viewModel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.databindingandviewholder.R;
import com.example.databindingandviewholder.viewModel.ui.main2.Main2Fragment;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // Main2ViewModel main2ViewModel= ViewModelProviders.of(Main2Fragment.newInstance()).get(Main2ViewModel.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, Main2Fragment.newInstance())
                    .commitNow();
        }
    }
}
