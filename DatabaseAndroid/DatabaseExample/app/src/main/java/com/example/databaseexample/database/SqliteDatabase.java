package com.example.databaseexample.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
public class SqliteDatabase extends SQLiteOpenHelper {
    private    static final int DATABASE_VERSION =    5;
    private    static final String    DATABASE_NAME = "product";
    private    static final String TABLE_EMPLOYEE = "products";
    private static final String COLUMN_ID = "_id";
    private static final   String COLUMN_EMPLOYEENAME = "productname";
    private static final String COLUMN_SALARY = "quantity";
    public SqliteDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_EMPLOYEE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_EMPLOYEENAME + " TEXT," + COLUMN_SALARY + " INTEGER" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        onCreate(db);
    }
    public List<Employee> listProducts(){
        String sql = "select * from " + TABLE_EMPLOYEE;
        SQLiteDatabase db = this.getReadableDatabase();
        List<Employee> storeProducts = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                int quantity = Integer.parseInt(cursor.getString(2));
                storeProducts.add(new Employee(id, name, quantity));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeProducts;
    }
    public void addProduct(Employee product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMPLOYEENAME, product.getName());
        values.put(COLUMN_SALARY, product.getQuantity());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_EMPLOYEE, null, values);
    }
    public void updateProduct(Employee product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMPLOYEENAME, product.getName());
        values.put(COLUMN_SALARY, product.getQuantity());
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_EMPLOYEE, values, COLUMN_ID    + "    = ?", new String[] { String.valueOf(product.getId())});
    }
    public Employee findProduct(String name){
        String query = "Select * FROM "    + TABLE_EMPLOYEE + " WHERE " + COLUMN_EMPLOYEENAME + " = " + "name";
        SQLiteDatabase db = this.getWritableDatabase();
        Employee mProduct = null;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            int id = Integer.parseInt(cursor.getString(0));
            String productName = cursor.getString(1);
            int productQuantity = Integer.parseInt(cursor.getString(2));
            mProduct = new Employee(id, productName, productQuantity);
        }
        cursor.close();
        return mProduct;
    }
    public void deleteProduct(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EMPLOYEE, COLUMN_ID    + "    = ?", new String[] { String.valueOf(id)});
    }
}
