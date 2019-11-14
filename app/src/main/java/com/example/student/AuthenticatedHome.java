package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                goToWebPage(getString(R.string.maplink));
                break;
            case 2:
                goToWebPage(getString(R.string.caflink));
                break;
            case 3:
<<<<<<< HEAD
                goToWebPage("https://myaccount.biola.edu");
                break;
            case 4:
                goToWebPage("https://biola.presence.io/");
                break;
            case 5:
                goToWebPage("https://www.biola.edu/directory");
                break;
            case 6:
                goToWebPage("https://canvas.biola.edu/");
=======
                //Toast.makeText(getApplicationContext(),"My Account", Toast.LENGTH_SHORT).show();
                goToWebPage(getString(R.string.myaccount));
                break;
            case 4:
                //Toast.makeText(getApplicationContext(),"Presence", Toast.LENGTH_SHORT).show();
                goToWebPage(getString(R.string.presencelink));
                break;
            case 5:
                //Toast.makeText(getApplicationContext(),"Directory", Toast.LENGTH_SHORT).show();
                goToWebPage(getString(R.string.dirlink));
                break;
            case 6:
                //Toast.makeText(getApplicationContext(),"Canvas", Toast.LENGTH_SHORT).show();
                goToWebPage(getString(R.string.canvaslink));
>>>>>>> 4cd03b6f131bfa5060c4ed890550200636e44bc6
                break;
            case 7:
                //Toast.makeText(getApplicationContext(),"Torrey", Toast.LENGTH_SHORT).show();

                break;
            default:
                Toast.makeText(getApplicationContext(),"Default error!", Toast.LENGTH_SHORT).show();

        }
    }
    private void goToWebPage(String url) {
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    public void signOut(View view) {
        finish();
    }
}
