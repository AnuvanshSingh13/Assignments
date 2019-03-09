package com.example.fragmentassignment.Ques3;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragmentassignment.R;



public class FragmentDiag extends DialogFragment {

    Button btnCancel, btnSubmit;
    EditText editTextName, editTextPhone;

    public FragmentDiag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_diag, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCancel = view.findViewById(R.id.btn_cancel);
        btnSubmit = view.findViewById(R.id.btn_submit);
        editTextName = view.findViewById(R.id.et_name);
        editTextPhone = view.findViewById(R.id.et_phone);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone) || !TextUtils.isDigitsOnly(phone)) {
                    Toast.makeText(getActivity(), "Invalid data entry", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Name: " + name + "\nPhone: " + phone, Toast.LENGTH_SHORT).show();
                    getDialog().dismiss();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
    }
}