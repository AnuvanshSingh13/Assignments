package com.example.roomdatabase;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class UserViewModel extends AndroidViewModel {
    private UserRepository repository;
    private LiveData<List<User>> allNotes;
    public UserViewModel(@NonNull Application application) {
        super(application);
        repository=new UserRepository(application);
        allNotes=repository.getAllNote();

    }
    public void insert(User user){
        repository.insert(user);
    }public void update(User user){
        repository.update(user);
    }public void delete(User user){
        repository.delete(user);
    }public void deleteAll(){
        repository.deleteAllNotes();
    }

    public LiveData<List<User>> getAllNotes() {
        return allNotes;
    }
}























