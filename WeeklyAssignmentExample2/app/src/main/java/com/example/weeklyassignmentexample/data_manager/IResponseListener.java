package com.example.weeklyassignmentexample.data_manager;

import com.example.weeklyassignmentexample.Model.Datum;

import java.util.List;

public interface IResponseListener {
    void onLoginRegisterResponseReceived(boolean response_successful, int sent_by);

    void onUsersListReceived(List<Datum> usersModelList);

    void onAddUserResponseReceived(boolean response_successful, int sent_by);

    void onDeleteUserResponseReceived(boolean response_successful);
}
