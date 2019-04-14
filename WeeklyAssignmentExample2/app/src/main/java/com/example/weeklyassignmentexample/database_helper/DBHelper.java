package com.example.weeklyassignmentexample.database_helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.weeklyassignmentexample.Model.Datum;

import java.util.List;

import static com.example.weeklyassignmentexample.Constants.COLUMN_AVATAR;
import static com.example.weeklyassignmentexample.Constants.COLUMN_FIRST_NAME;
import static com.example.weeklyassignmentexample.Constants.COLUMN_ID;
import static com.example.weeklyassignmentexample.Constants.COLUMN_LAST_NAME;
import static com.example.weeklyassignmentexample.Constants.COLUMN_PAGE_NO;
import static com.example.weeklyassignmentexample.Constants.CREATE_TABLE_COMMAND;
import static com.example.weeklyassignmentexample.Constants.DB_NAME;
import static com.example.weeklyassignmentexample.Constants.DB_VERSION;
import static com.example.weeklyassignmentexample.Constants.DELETE_DATA_COMMAND;
import static com.example.weeklyassignmentexample.Constants.DROP_TABLE_COMMAND;
import static com.example.weeklyassignmentexample.Constants.TABLE_NAME;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_COMMAND);
        onCreate(db);
    }

    public void insertDataIntoDB(SQLiteDatabase database, List<Datum> usersModelList, int page_no) {
        ContentValues contentValues;
        for (Datum usersModel : usersModelList) {
            contentValues = new ContentValues();
            contentValues.put(COLUMN_ID, usersModel.getId());
            contentValues.put(COLUMN_FIRST_NAME, usersModel.getFirstName());
            contentValues.put(COLUMN_LAST_NAME, usersModel.getLastName());
            contentValues.put(COLUMN_AVATAR, usersModel.getAvatar());
            contentValues.put(COLUMN_PAGE_NO, page_no);
            database.insert(TABLE_NAME, null, contentValues);
        }
    }

    public Cursor fetchDataFromDB(SQLiteDatabase database) {
        String[] columns = new String[]{COLUMN_ID, COLUMN_FIRST_NAME, COLUMN_LAST_NAME, COLUMN_AVATAR, COLUMN_PAGE_NO};
        Cursor cursor = database.query(TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public void deleteAllDataFromDB(SQLiteDatabase database) {
        database.execSQL(DELETE_DATA_COMMAND);
    }

    public void deleteUserFromDB(int user_id, SQLiteDatabase database) {
        database.delete(TABLE_NAME, COLUMN_ID + " = ?",
                new String[]{String.valueOf(user_id)});
    }
}
