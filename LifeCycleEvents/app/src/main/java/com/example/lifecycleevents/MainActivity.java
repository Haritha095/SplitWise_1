package com.example.lifecycleevents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.widget.Button;


/**
 * Navigating from one screen to other on a button click
 * activity lifecycle methods to show change in states on navigation
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "On Create Main_activity");
        Button button_main = (Button) findViewById(R.id.button_main);
        button_main.setOnClickListener(view -> gotoActivity2());


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "On Start Main_activity");
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        Log.d(TAG, "On Restart Main_activity");
    }

    @Override
    protected void onResume() {

        super.onResume();
        Log.d(TAG, "On Resume Main_activity");
    }

    @Override
    protected void onPause() {

        super.onPause();
        Log.d(TAG, "On Pause Main_activity");
    }

    @Override
    protected void onStop() {

        super.onStop();
        Log.d(TAG, "On Stop Main_activity");
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.d(TAG, "On Destroy Main_activity");
    }

    public void gotoActivity2() {
        Log.d(TAG, "Button clicked");
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}