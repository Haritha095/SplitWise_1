package com.example.findtheperson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText input_book;
    private TextView text_title;
    private TextView author_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_book = (EditText)findViewById(R.id.bookInput);
        text_title = (TextView)findViewById(R.id.titleText);
        author_text = (TextView)findViewById(R.id.authorText);
    }

    public void searchBooks(View view) {

        String queryString = input_book.getText().toString();
        new FetchBook(text_title, author_text).execute(queryString);
    }
}