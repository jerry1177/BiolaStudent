package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toast.makeText(this, "login",Toast.LENGTH_SHORT);
    }


    public void loginPressed(View view) {
        // TODO: clear text box texts
        Intent intent = new Intent(this, AuthenticatedHome.class);
        startActivity(intent);

    }

    @Override
    protected void onStart() {
        super.onStart();
        // clear text
        ((EditText)findViewById(R.id.netid)).setText("");
        ((EditText)findViewById(R.id.password)).setText("");
    }
}
