package com.example.webserviceexample;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResponseHandler<T extends BaseResponseModel>implements Callback<T> {
    private SuccessAPICallback successAPICallback=null;
    private FailureAPICallback failureAPICallback=null;
    private Context context=null;
    private Call mCall;

    public ResponseHandler(Context context){
        this.context=context;
    }
    public ResponseHandler(SuccessAPICallback successAPICallback,FailureAPICallback failureAPICallback,Context context){
        this.successAPICallback=successAPICallback;
        this.failureAPICallback=failureAPICallback;
        this.context=context;
    }


    @Override
    public void onResponse(Call<T> call, Response<T> response) {
    if (response.isSuccessful()&&successAPICallback!=null){
        successAPICallback.onResponse(response.body());
    }else {
        failureAPICallback.onFailure(response.body(),response.body());
    }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        String errorMesseage=t.toString();
        if (t instanceof UnknownHostException || t instanceof ConnectException)
            showNetworkDialog();
        Log.e("ResponseHandler",errorMesseage);

    }

    private void showNetworkDialog() {
        Toast.makeText(context, "Network Dialog", Toast.LENGTH_SHORT).show();    }

}
