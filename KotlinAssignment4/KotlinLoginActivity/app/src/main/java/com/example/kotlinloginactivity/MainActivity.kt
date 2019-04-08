package com.example.kotlinloginactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var et_userName= findViewById<EditText>(R.id.et_user_name)
        var et_password=findViewById<EditText>(R.id.et_password)
        var btn_reset=findViewById<Button>(R.id.btn_reset)
        var btn_submit=findViewById<Button>(R.id.btn_submit)
        btn_reset.setOnClickListener {
            et_userName.setText("")
            et_password.setText("")
        }
        btn_submit.setOnClickListener {
            val userName=et_userName.text
            val password=et_password.text
            if (userName.isEmpty() || password.isEmpty()){
                val message = "please fill data"
               Toast.makeText(this@MainActivity,"please fill all the details",Toast.LENGTH_SHORT).show()
            }else
            {
                val intent= Intent(this@MainActivity,NewActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
