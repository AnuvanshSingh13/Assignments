package com.example.weeklyassignmentexample;

import android.Manifest;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weeklyassignmentexample.Login.IDetailsListener;
import com.example.weeklyassignmentexample.Login.LoginScreen;
import com.example.weeklyassignmentexample.Model.Datum;
import com.example.weeklyassignmentexample.UserList.IDataChangeListener;
import com.example.weeklyassignmentexample.UserList.UserListScreen;
import com.example.weeklyassignmentexample.add_user_dialog.AddUserDialogFragment;
import com.example.weeklyassignmentexample.add_user_dialog.IAddUserDetails;
import com.example.weeklyassignmentexample.data_manager.DataManager;
import com.example.weeklyassignmentexample.data_manager.IResponseListener;
import com.example.weeklyassignmentexample.database_helper.DBHelper;
import com.example.weeklyassignmentexample.network_state_receiver.IOnNetworkStateChanged;
import com.example.weeklyassignmentexample.network_state_receiver.NetworkStateReceiver;
import com.example.weeklyassignmentexample.user_deatils.UserDetailsScreenFragment;

import java.util.List;

import static com.example.weeklyassignmentexample.Constants.ADD_USER_REQUEST;
import static com.example.weeklyassignmentexample.Constants.LOGIN_REQUEST;
import static com.example.weeklyassignmentexample.Constants.SIGNUP_REQUEST;

public class MainActivity extends AppCompatActivity implements IDetailsListener, IResponseListener, IDataChangeListener, IAddUserDetails, IOnNetworkStateChanged {
    public static final int SPLASH_SCREEN_TIMEOUT = 3000;
    SharedPreferences preferences;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    LoginScreen loginScreen;
    UserListScreen userListScreen;
    DataManager dataManager;
    DBHelper dbHelper;
    SQLiteDatabase database;
    UserDetailsScreenFragment userDetailsScreenFragment;
    NetworkStateReceiver networkStateReceiver;
    ConstraintLayout mainActivityConstraintLayout;

    int pageNo;
    boolean isConnected;

    private static final int PERMISSIONS_READ_WRITE_EXTERNAL_STORAGE = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        starters();
        if (!isFirstTime()) {
            showSplashScreen();

        } else {
            if (isSignedIn()) {
                showUserListScreen();

            } else {
                showLoginScreen();
            }
        }


    }

    private void showUserListScreen() {
        userListScreen = new UserListScreen();
        userListScreen.setDataChangeListener(this);    // Connecting IOnDataChangeListener
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame, userListScreen).addToBackStack(null).commit();

    }

    private void starters() {
        preferences = getSharedPreferences("Mocky", MODE_PRIVATE);
        fragmentManager = getSupportFragmentManager();
        dataManager = new DataManager();
        dataManager.setOnResponseListener(this);       // Connecting IOnDetailsListener
        dbHelper = new DBHelper(this);
        database = dbHelper.getWritableDatabase();
        networkStateReceiver = new NetworkStateReceiver();
        networkStateReceiver.setOnNetworkStateChanged(this);    // Connecting IOnNetworkStateChanged
        mainActivityConstraintLayout = findViewById(R.id.main_activity);
        if (pageNo == 0) {
            pageNo = 1;
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (pageNo == 0) {
            pageNo = 1;
        }
    }

    private boolean isFirstTime() {
        if (preferences.contains("First_time")) {
            return preferences.getBoolean("first_time", false);

        } else return false;
    }

    private boolean isSignedIn() {
        if (preferences.contains("signed_in")) {
            return preferences.getBoolean("signed_in", false);
        } else return false;
    }

    private void showSplashScreen() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame, new SplashScreen()).addToBackStack(null).commit();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fragmentManager.popBackStack();
                preferences.edit().putBoolean("first_time", true).apply();
                showLoginScreen();


            }
        }, SPLASH_SCREEN_TIMEOUT);
    }

    private void showLoginScreen() {
        loginScreen = new LoginScreen();
        loginScreen.setiDetailsListener(this);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame, loginScreen).addToBackStack(null).commit();

    }

    @Override
    public void onUsersListReceived(List<Datum> usersModelList) {
        if (usersModelList.size() != 0) {
            userListScreen.setUsersData(usersModelList);
            pageNo++;
        } else {
            Toast.makeText(this, "No Data Received!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAddUserResponseReceived(boolean response_successful, int sent_by) {
        if (sent_by == ADD_USER_REQUEST) {
            if (response_successful)
                Toast.makeText(this, "User Added Successfully!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Update User Request Failed!", Toast.LENGTH_SHORT).show();
        } else {
            if (response_successful)
                Toast.makeText(this, "User Updated Successfully!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Update User Request Failed!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDeleteUserResponseReceived(boolean response_successful) {
        if (response_successful)
            Toast.makeText(this, "User Deleted Successfully!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Delete User Request Failed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getMoreData() {
        Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();
        if (isConnected) dataManager.getUsersListRequest(pageNo, dbHelper, database);
        else dataManager.getUsersListFromDB(pageNo, dbHelper, database);
    }

    @Override
    public void showUserDetails(Datum usersModel) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("users_model", usersModel);
        userDetailsScreenFragment = new UserDetailsScreenFragment();
        userDetailsScreenFragment.setArguments(bundle);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(userListScreen);
        fragmentTransaction.add(R.id.frame, userDetailsScreenFragment).addToBackStack(null).commit();
    }

    @Override
    public void addUpdateUserNameJob(int sent_by) {
        AddUserDialogFragment addUserDialogFragment = new AddUserDialogFragment();
        addUserDialogFragment.setAddUserDetails(this);  // Connecting IAddUserDetails
        Bundle bundle = new Bundle();
        bundle.putInt("sent_by", sent_by);
        addUserDialogFragment.setArguments(bundle);
        addUserDialogFragment.show(getSupportFragmentManager(), null);
    }

    @Override
    public void deleteUserDetails(int user_id) {
        if (isConnected) dataManager.deleteUserRequest(user_id, dbHelper, database);
        else {
            dbHelper.deleteUserFromDB(user_id, database);
        }
    }

    @Override
    public void shareUserDetails(Datum usersModel) {
        if (isConnected) {
            askingPermissions();
            dataManager.shareUserRequest(this, usersModel);
        } else Toast.makeText(this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
    }

    private void askingPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSIONS_READ_WRITE_EXTERNAL_STORAGE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSIONS_READ_WRITE_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission Granted!", Toast.LENGTH_SHORT).show();
                } else {
                    askingPermissions();
                }
                break;
        }
    }

    @Override
    public void logoutUser() {
        preferences.edit().putBoolean("signed_in", false).apply();
        fragmentManager.popBackStack();
        showLoginScreen();
    }

    @Override
    public void onAddUserDetailsReceived(String name, String job, int sent_by) {
        dataManager.addUpdateUserRequest(name, job, sent_by);
    }

    @Override
    public void onDetailsReceived(String email, String password, int sent_by) {
        if (isConnected)
            dataManager.loginRegisterUserRequest(email, password, sent_by);
        else
            Toast.makeText(this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginRegisterResponseReceived(boolean response_successful, int sent_by) {
        if (sent_by == SIGNUP_REQUEST) {
            if (response_successful) {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
            }
        } else if (sent_by == LOGIN_REQUEST) {
            if (response_successful) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

                fragmentManager.popBackStack();
                preferences.edit().putBoolean("signed_in", true).apply();
                showUserListScreen();
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(networkStateReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(networkStateReceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
        database.close();
    }

    @Override
    public void isNetworkConnected(boolean network_state) {
        isConnected = network_state;
        showNetworkSnackBar(network_state);
    }

    private void showNetworkSnackBar(final boolean network_connected) {
        String networkConnected;
        Snackbar snackbar;
        TextView snackbarText;
        if (network_connected) {
            networkConnected = "You are Back Online!!";
            snackbar = Snackbar.make(mainActivityConstraintLayout, networkConnected, Snackbar.LENGTH_SHORT);
            View view = snackbar.getView();
            snackbarText = view.findViewById(android.support.design.R.id.snackbar_text);
            view.setBackgroundColor(Color.argb(255, 0, 150, 100));
        } else {
            networkConnected = "No Internet Connection!";
            snackbar = Snackbar.make(mainActivityConstraintLayout, networkConnected, Snackbar.LENGTH_INDEFINITE);
            View view = snackbar.getView();
            snackbarText = view.findViewById(android.support.design.R.id.snackbar_text);
            view.setBackgroundColor(Color.argb(255, 178, 34, 34));
        }
        snackbarText.setTextSize(15);
        snackbar.show();
    }


}

