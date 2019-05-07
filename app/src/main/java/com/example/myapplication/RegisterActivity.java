package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.util.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;


        Button register,login;
        EditText email, userName, password, phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        openHelper = new DatabaseHelper(this);

        register = (Button) findViewById(R.id.register_btn);
        login = (Button) findViewById(R.id.login_btn);

        email = (EditText) findViewById(R.id.email_text);
        userName = (EditText) findViewById(R.id.username_text);
        password = (EditText) findViewById(R.id.password_text);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber_text);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("register btn pressed");
                if ((email.getText().length()>0) && (userName.getText().length()>0) && (password.getText().length()>0)) {

                    registerBtnOnPress(String.valueOf(email.getText()), String.valueOf(userName.getText()), String.valueOf(password.getText()));
                } else {
                    Toast.makeText(getApplicationContext(),"All form data are Mandatory to be filled",Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToLogin();
            }
        });

    }

    private void registerBtnOnPress(String email, String userName, String password) {
        db = openHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2 , userName);
        contentValues.put(DatabaseHelper.COL_4, password);
        contentValues.put(DatabaseHelper.COL_5, email);
        contentValues.put(DatabaseHelper.COL_6,"");

        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
        System.out.println(">>>> "+id);

        if (id > 0) {
            Toast.makeText(getApplicationContext(),"User Registered Successfully ",Toast.LENGTH_SHORT).show();
            backToLogin();
        } else {
            Toast.makeText(getApplicationContext(),"User Registration Failed This email was Already used! please direct to login",Toast.LENGTH_SHORT).show();

        }
    }

    public void backToLogin() {
        Intent backToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(backToLogin);
    }

}
