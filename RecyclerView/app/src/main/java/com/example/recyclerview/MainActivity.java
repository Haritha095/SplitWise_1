package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] name;
    int[] image = {R.drawable.beagle, R.drawable.golden, R.drawable.dog, R.drawable.labrador, R.drawable.pomeranian};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        recyclerView = findViewById(R.id.recycler_main);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = getResources().getStringArray(R.array.Dog_Breeds);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, name, image);
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}