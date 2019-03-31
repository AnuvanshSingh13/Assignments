package com.example.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class UserRepository {
    private UserDao userDao;
    private LiveData<List<User>> allNote;
    public UserRepository(Application application){
        UserDatabase database = UserDatabase.getInstance(application);
        userDao =database.noteDao();
        allNote= userDao.getAllNotes();
    }
    public void insert(User user){
        new InsertNoteAsyncTask(userDao).execute(user);

    }
    public void update(User user){
        new UpdateNoteAsyncTask(userDao).execute(user);
    }
    public void delete(User user){
        new DeleteNoteAsyncTask(userDao).execute(user);

    }
    public void deleteAllNotes(){
        new DeleteAllNotesAsyncTask(userDao).execute();
    }

    public LiveData<List<User>> getAllNote() {
        return allNote;
    }
    private static class InsertNoteAsyncTask extends AsyncTask<User,Void,Void>{
        private UserDao userDao;
        private InsertNoteAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }
        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }
    private static class UpdateNoteAsyncTask extends AsyncTask<User,Void,Void>{
        private UserDao userDao;
        private UpdateNoteAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }
        @Override
        protected Void doInBackground(User... users) {
            userDao.update(users[0]);
            return null;
        }
    }
    private static class DeleteNoteAsyncTask extends AsyncTask<User,Void,Void>{
        private UserDao userDao;
        private DeleteNoteAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }
        @Override
        protected Void doInBackground(User... users) {
            userDao.delete(users[0]);
            return null;
        }
    }
    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void,Void,Void>{
        private UserDao userDao;
        private DeleteAllNotesAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            userDao.deleteAllNotes();
            return null;
        }
    }
}






















