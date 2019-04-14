package com.example.weeklyassignmentexample.UserList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Toast;

import com.example.weeklyassignmentexample.Login.IDetailsListener;
import com.example.weeklyassignmentexample.Model.Datum;
import com.example.weeklyassignmentexample.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.weeklyassignmentexample.Constants.ADD_USER_REQUEST;
import static com.example.weeklyassignmentexample.Constants.UPDATE_USER_REQUEST;

public class UserListScreen extends Fragment implements IUserDetailsListener {
    RecyclerView usersListRV;
    UserListAdapter usersListAdapter;
    List<Datum> usersData;
    LinearLayoutManager linearLayoutManager;
    IDataChangeListener dataChangeListener;
    boolean isScrolling = false;

    public void setDataChangeListener(IDataChangeListener dataChangeListener) {
        this.dataChangeListener = dataChangeListener;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_user_list_screen, container, false);
        buildUsersList(view);
        return view;
    }
    private void buildUsersList(View view) {
        usersListRV = view.findViewById(R.id.users_list_rv);
        linearLayoutManager = new LinearLayoutManager(view.getContext());
        usersListRV.setLayoutManager(linearLayoutManager);
        usersListAdapter = new UserListAdapter();
        usersListAdapter.setUserDetailsListener(this);
        usersData = new ArrayList<>();
        usersListAdapter.setUserModelList(usersData);
        usersListRV.setAdapter(usersListAdapter);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        usersListRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int totalItems = linearLayoutManager.getItemCount();
                int visibleItems = linearLayoutManager.getChildCount();
                int scrolledOutItems = linearLayoutManager.findFirstVisibleItemPosition();
                if (isScrolling && visibleItems + scrolledOutItems == totalItems) {
                    isScrolling = false;
                    dataChangeListener.getMoreData();
                }
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dataChangeListener.getMoreData();
    }

    public void setUsersData(List<Datum> usersModelList) {
        usersData.addAll(usersModelList);
        usersListAdapter.setUserModelList(usersData);
        usersListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_list_screen, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_menu_add_user:
                Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_SHORT).show();
                dataChangeListener.addUpdateUserNameJob(ADD_USER_REQUEST);
                break;
            case R.id.option_menu_update_user:
                Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_SHORT).show();
                dataChangeListener.addUpdateUserNameJob(UPDATE_USER_REQUEST);
                break;
            case R.id.option_menu_logout_user:
                Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_SHORT).show();
                confirmLogout(getActivity());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void userDetailsClicked(Datum usersModel) {
        if (dataChangeListener != null) {
            dataChangeListener.showUserDetails(usersModel);
        }
    }

    @Override
    public void deleteUser(int user_id) {
        if (dataChangeListener != null) {
            dataChangeListener.deleteUserDetails(user_id);
        }
    }

    @Override
    public void shareUser(Datum usersModel) {
        if (dataChangeListener != null) {
            dataChangeListener.shareUserDetails(usersModel);
        }
    }

    private void confirmLogout(Context context) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        dataChangeListener.logoutUser();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Do you really want to Logout?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }




}
