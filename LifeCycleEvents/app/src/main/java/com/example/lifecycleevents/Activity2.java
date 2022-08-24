package com.example.lifecycleevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


public class Activity2 extends AppCompatActivity {
    private static final String Tag_1 = Activity2.class.getSimpleName();

    /**
     * Second activity lifecycle methods explained
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Tag_1, "On Start Second_Activity");
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        Log.d(Tag_1, "On Restart Second_Activity");
    }

    @Override
    protected void onResume() {

        super.onResume();
        Log.d(Tag_1, "On Resume Second_Activity");
    }

    @Override
    protected void onPause() {

        super.onPause();
        Log.d(Tag_1, "On Pause Second_Activity");
    }

    @Override
    protected void onStop() {

        super.onStop();
        Log.d(Tag_1, "On Stop Second_Activity");
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.d(Tag_1, "On Destroy Second_Activity");
    }
}