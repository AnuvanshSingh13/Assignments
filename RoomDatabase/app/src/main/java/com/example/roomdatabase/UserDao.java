package com.example.roomdatabase;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);
    @Update
    void update(User user);
    @Delete
    void delete(User user);
    @Query("DELETE FROM user_table")
    void deleteAllNotes();
    @Query("SELECT * FROM user_table ORDER BY priority DESC")
    LiveData<List<User>> getAllNotes();
}
