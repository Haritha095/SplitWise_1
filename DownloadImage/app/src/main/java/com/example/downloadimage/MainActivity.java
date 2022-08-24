package com.example.downloadimage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button button;
    String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_main);
        button = findViewById(R.id.button_click);
        button.setOnClickListener(this);
        imageUrl = "https://burst.shopifycdn.com/photos/poochie-party-treats.jpg?width=4460&height=4460&exif=1&iptc=1&attachment=poochie-party-treats.jpgd";
    }

    @Override
    public void onClick(View view) {
        // new ImageDownloader().execute("https://burst.shopifycdn.com/photos/poochie-party-treats.jpg?width=4460&height=4460&exif=1&iptc=1&attachment=poochie-party-treats.jpg");
        Glide.with(this)
                .load(imageUrl)
                .into(imageView);
    }

    @SuppressLint("StaticFieldLeak")
    private class ImageDownloader extends AsyncTask<String, Void, Bitmap> {

        HttpURLConnection httpURLConnection;

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                Bitmap temp = BitmapFactory.decodeStream(inputStream);
                return temp;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                httpURLConnection.disconnect();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                Toast.makeText(getApplicationContext(), "Download Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Download not Successful", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}