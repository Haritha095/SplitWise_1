package com.example.broadcastreceiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;



import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive() {
        {
           secondActivity_main(context,intent);
        }
    }



    private void secondActivity_main(Context context,Intent intent){
        CharSequence iData = intent.getCharSequenceExtra("msg");
        Toast.makeText(context, "Received Message: " +iData, Toast.LENGTH_LONG).show();

    }}


