package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;


public class    MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onClickShowBroadcast(View view) {

        EditText editSend = findViewById(R.id.editText);
        Intent intent = new Intent();
        intent.putExtra("msg", (CharSequence)editSend.getText().toString());
        intent.setAction("com.CUSTOM_INTENT");
        sendBroadcast(intent);



    }


}