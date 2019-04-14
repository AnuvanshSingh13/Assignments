package com.example.weeklyassignmentexample.RetrofitCallbacks;

public interface SuccessAPICallback<T> {
    void onResponse(T t);
}
