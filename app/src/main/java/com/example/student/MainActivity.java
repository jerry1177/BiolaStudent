package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView myView = findViewById(R.id.textView);
        String student = BuildConfig.ApiKey;
        myView.setText(student);
    }

    public void jerr(View view){
        String student = BuildConfig.ApiKey;
    }
}
