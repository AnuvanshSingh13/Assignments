package com.example.webserviceexample;

public interface SuccessAPICallback<T> {
    void onResponse(T t);
}
