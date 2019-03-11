package com.example.databaseexample;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.databaseexample.adapter.EmployeeAdapter;
import com.example.databaseexample.database.Employee;
import com.example.databaseexample.database.SqliteDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private SqliteDatabase mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout fLayout = findViewById(R.id.activity_to_do);
        RecyclerView EmployeeView  = findViewById(R.id.employee_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        EmployeeView.setLayoutManager(linearLayoutManager);
        EmployeeView.setHasFixedSize(true);
        mDatabase = new SqliteDatabase(this);
        List<Employee> allProducts = mDatabase.listProducts();
        if(allProducts.size() > 0){
            EmployeeView.setVisibility(View.VISIBLE);
            EmployeeAdapter mAdapter = new EmployeeAdapter(this, allProducts);
            EmployeeView.setAdapter(mAdapter);
        }else {
            EmployeeView.setVisibility(View.GONE);
            Toast.makeText(this, "There is no employee in the database. Start adding now", Toast.LENGTH_LONG).show();
        }
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add new quick task
                addTaskDialog();
            }
        });
    }
    private void addTaskDialog(){
        LayoutInflater inflater = LayoutInflater.from(this);
        View subView = inflater.inflate(R.layout.add_employee_layout, null);
        final EditText nameField = subView.findViewById(R.id.enter_name);
        final EditText salaryField = subView.findViewById(R.id.enter_salary);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add new Employee");
        builder.setView(subView);
        builder.create();
        builder.setPositiveButton("Add Employee", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String name = nameField.getText().toString();
                final String quan=salaryField.getText().toString();
                final int salary = Integer.parseInt(quan);
                if(name.isEmpty()|| salary <= 0 ){
                    Toast.makeText(MainActivity.this, "Something went wrong. Check your input values", Toast.LENGTH_LONG).show();
                }
                else{

                    Employee newProduct = new Employee(name, salary);
                    mDatabase.addProduct(newProduct);
                    //refresh the activity
                    finish();
                    startActivity(getIntent());
                }
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Task cancelled", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mDatabase != null){
            mDatabase.close();
        }
    }
}