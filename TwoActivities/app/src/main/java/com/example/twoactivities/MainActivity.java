package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * TwoActivity method to show how to navigate from one activity
 * to other on button click
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button_main);
        button.setOnClickListener(view -> secondActivity());
    }

    public void secondActivity() {
        Log.d(TAG, "Button clicked!!!");
        Intent intent = new Intent(this, secondActivity.class);
        startActivity(intent);


    }

    public void secondActivity(View view) {
    }
}