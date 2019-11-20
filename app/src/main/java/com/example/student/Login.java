package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    public void loginPressed(View view) {
        // TODO: clear text box texts
        Intent intent = new Intent(this, AuthenticatedHome.class);
        startActivity(intent);

        // clear edittext
        EditText netid = (EditText) findViewById(R.id.netid);
        EditText password = (EditText) findViewById(R.id.password);

        netid.setText("");
        password.setText("");
    }
}
