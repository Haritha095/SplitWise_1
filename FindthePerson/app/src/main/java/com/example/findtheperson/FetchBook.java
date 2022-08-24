package com.example.findtheperson;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class FetchBook extends AsyncTask<String, Void, String> {
    private WeakReference<TextView> titleText_main;
    private WeakReference<TextView> titleAuthor_main;
    FetchBook(TextView titleText, TextView authorText) {
        this.titleText_main = new WeakReference<>(titleText);
        this.titleAuthor_main = new WeakReference<>(authorText);
    }
    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getBookInfo(strings[0]);
    }
    @Override
    protected void onPostExecute(String string1) {
        super.onPostExecute(string1);

    }
}
