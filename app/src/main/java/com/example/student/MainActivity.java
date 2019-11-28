package com.example.student;


import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;

    private static final int MY_PERMISSION_REQUEST_INTERNET = 0;

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // set image view height and width  dynamiclly
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        Display window = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        window.getSize(size);
        int height = size.y;
        height /= 3;
        image.getLayoutParams().height = height;

        //        (new ViewGroup.MarginLayoutParams
        //                (100, ViewGroup.LayoutParams.MATCH_PARENT));
        /*
        TextView myView = findViewById(R.id.textView);
        String student = BuildConfig.ApiKey;
        myView.setText(student);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.sign_in_button) {
                    signIn();
                }
            }
        });
        */

    }

    public void buttonPressed(View view) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "Internet permission not granted!", Toast.LENGTH_SHORT).show();
        } else {
            // Permission has already been granted


            // if map was clicked
            if (Integer.parseInt(view.getTag().toString()) == 1) {
                Intent intent = new Intent(this, WebActivity.class);
                intent.putExtra("url", getString(R.string.maplink));
                startActivity(intent);


                // if cafeteria was clicked
            } else if (Integer.parseInt(view.getTag().toString()) == 2) {

                Intent intent = new Intent(this, WebActivity.class);
                intent.putExtra("url", getString(R.string.caflink));
                startActivity(intent);
                // if login button was clicked
            } else {
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
            }
        }

    }


    private void signIn() {
        Log.w(TAG,"google button pressed");
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {

        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Log.w(TAG, "success");
            // Signed in successfully, show authenticated UI.
            //updateUI(account);
            Log.w(TAG, "Display name: " + account.getDisplayName());
            Log.w(TAG, "Email: " + account.getEmail());
            Log.w(TAG, "Given name: " + account.getGivenName());
            Log.w(TAG, "Family name: " + account.getFamilyName());
            Log.w(TAG, "User ID Token: " + account.getIdToken());
            Log.w(TAG, "UserUD is: " + account.getId());
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            //updateUI(null);
        }

    }
    @Override
    protected void onStop() {
        // call the superclass method first
        super.onStop();
        Log.w(TAG, "signout!");
        FirebaseAuth.getInstance().signOut();
    }

}
