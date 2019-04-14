package com.example.weeklyassignmentexample.UserList;

import com.example.weeklyassignmentexample.Model.Datum;

public interface IDataChangeListener {
    void getMoreData();

    void showUserDetails(Datum usersModel);

    void addUpdateUserNameJob(int sent_by);

    void deleteUserDetails(int user_id);

    void shareUserDetails(Datum usersModel);

    void logoutUser();

}
