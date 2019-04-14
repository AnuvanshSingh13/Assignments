package com.example.weeklyassignmentexample.RetrofitCallbacks;

import android.content.Context;

import com.example.weeklyassignmentexample.Model.BaseResponseModel;

import java.net.ConnectException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Response;

public class ResponseHandler <T extends BaseResponseModel> implements retrofit2.Callback<T> {
    private SuccessAPICallback succesAPICallback = null;
    private FailureAPICallback failureAPICallback = null;
    private Context context;

    public ResponseHandler(Context context) {
        this.context = context;
    }
    public ResponseHandler(Context context,
                           SuccessAPICallback successAPICallback,
                           FailureAPICallback failureAPICallback){
        this.context=context;
        this.failureAPICallback=failureAPICallback;
        this.succesAPICallback=successAPICallback;

    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()){
            if (succesAPICallback!=null&& response.isSuccessful()){
                succesAPICallback.onResponse(response.body());
            }else {
                if (failureAPICallback!=null&& response.isSuccessful()){
                    failureAPICallback.onFailure(response.body(),response.body());
                }
            }
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        String errorMessage = t.toString();
        if (t instanceof UnknownHostException || t instanceof ConnectException){
            //showNetworkDialog();
        }


    }
}