package com.example.weeklyassignmentexample.Login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weeklyassignmentexample.R;

import java.util.regex.Pattern;

import static com.example.weeklyassignmentexample.Constants.EMAIL_REGEX;
import static com.example.weeklyassignmentexample.Constants.LOGIN_REQUEST;
import static com.example.weeklyassignmentexample.Constants.SIGNUP_REQUEST;

public class LoginScreen extends Fragment {

    EditText et_email,et_password;
    Button btn_login,btn_signUp;
    String email_text,password_text;
    IDetailsListener iDetailsListener;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et_email=view.findViewById(R.id.edit_text_email);
        et_password=view.findViewById(R.id.edit_text_password);
        btn_login=view.findViewById(R.id.button_login);
        btn_signUp=view.findViewById(R.id.button_signup);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extractText();
                if(checkNull()||validCheck()){
                    Toast.makeText(v.getContext(), "Please Wait..", Toast.LENGTH_SHORT).show();
                    iDetailsListener.onDetailsReceived(email_text,password_text,LOGIN_REQUEST);
                }else{
                    Toast.makeText(v.getContext(), "Email or password are incorrect", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extractText();
                if (checkNull()||validCheck()){
                    Toast.makeText(view.getContext(), "Please Wait..", Toast.LENGTH_SHORT).show();
                    iDetailsListener.onDetailsReceived(email_text,password_text,SIGNUP_REQUEST);
                }else {
                    Toast.makeText(view.getContext(), "Email or password are incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void extractText(){
        email_text=et_email.getText().toString();
        password_text=et_password.getText().toString();
        et_email.setText("");
        et_password.setText("");
    }
    private boolean checkNull(){
        return email_text!=null&& password_text!=null;
    }
    private boolean validCheck(){
        if (!email_text.isEmpty()&&!password_text.isEmpty()){
            Pattern pattern =Pattern.compile(EMAIL_REGEX);
        }
        return false;
    }
    public void setiDetailsListener(IDetailsListener detailsListener){
        this.iDetailsListener=detailsListener;
    }
}





