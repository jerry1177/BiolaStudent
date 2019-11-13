package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class AuthenticatedHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticated_home);
        // set height and width of image view dynamically
        ImageView image = (ImageView) findViewById(R.id.imageView2);
        image.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        Display window = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        window.getSize(size);
        int height = size.y;
        height /= 3;
        image.getLayoutParams().height = height;
    }

    public void linkPressed(View view) {
        switch (Integer.parseInt(view.getTag().toString())) {
            case 1:
                Toast.makeText(getApplicationContext(),"Map", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(),"Cafeteria", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(),"My Account", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(getApplicationContext(),"Presence", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(getApplicationContext(),"Directory", Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(getApplicationContext(),"Canvas", Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(getApplicationContext(),"Torrey", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(),"Default error!", Toast.LENGTH_SHORT).show();

        }
    }
}
