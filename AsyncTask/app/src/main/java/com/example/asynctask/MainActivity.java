package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView textView;
    Button button;
    ProgressBar progressBar, progressIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_main);
        button = findViewById(R.id.button_main);
        progressBar = findViewById(R.id.progress_bar);
        progressIndicator = findViewById(R.id.progress_indicator);

    }

    public void uploadTask(View view) {
        Toast.makeText(this, "button", Toast.LENGTH_SHORT).show();
    UploadTask uploadTask=new UploadTask();
    uploadTask.execute();
    }


class UploadTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... voids) {
        Log.i(TAG, "Do in background" + Thread.currentThread().getName());
        for (int j = 0; j < 10; j++) {
            try {
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }}}


