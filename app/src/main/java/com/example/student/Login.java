package com.example.student;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Login");

    }


    public void loginPressed(View view) {
        Intent intent = new Intent(this, AuthenticatedHome.class);
        startActivity(intent);
    }

    public void backButtonPressed(View view) {
        finish();
    }
}
