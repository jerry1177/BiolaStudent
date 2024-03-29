package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class AuthenticatedHome extends AppCompatActivity {
    private boolean isToggled = false;
    private Button wardrobeButton;
    private ImageView image;
    private Display window;
    private Point size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticated_home);
        // hide actionbar
        getSupportActionBar().hide();

        window = getWindowManager().getDefaultDisplay();

        // set height and width of image view dynamically
        image = (ImageView) findViewById(R.id.imageView2);
        image.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        size = new Point();
        window.getSize(size);

        adjustImageHeight(3);

        // set wardrobe button height
        wardrobeButton = (Button)findViewById(R.id.wardrobe);

        int height = size.y;
        height = (height*3)/20; // 15% of screen height
        wardrobeButton.getLayoutParams().height = height;

        // set wardrobe button invisible
        wardrobeButton.setVisibility(View.GONE);

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
                break;
            case 7:
                //Toast.makeText(getApplicationContext(),"Torrey", Toast.LENGTH_SHORT).show();
                goToWebPage(getString(R.string.wardrobelink));

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

    public void wardrobeToggle(View view) {
        // if wardrobe button is vizible
        if (isToggled) {
            // make button invisible
            wardrobeButton.setVisibility(View.GONE);
            isToggled = false;

            adjustImageHeight(3);
        } else {
            // make button visible
            wardrobeButton.setVisibility(View.VISIBLE);
            isToggled = true;

            adjustImageHeight(4);
        }

    }

    private void adjustImageHeight (int screenDividedBy) {
        // adjust image height

        int height = size.y;
        height /= screenDividedBy;
        image.getLayoutParams().height = height;
    }

}
