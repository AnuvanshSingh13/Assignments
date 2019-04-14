package com.example.weeklyassignmentexample.UserList;

import com.example.weeklyassignmentexample.Model.Datum;

public interface IUserDetailsListener {
    void userDetailsClicked(Datum usersModel);

    void deleteUser(int user_id);

    void shareUser(Datum usersModel);
}
