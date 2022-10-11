package com.example.trialapp;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class HomeFragment extends Fragment {

    private String message;
    private List<String> list;
    View ChildView;
    int RecyclerViewItemPosition;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    Button button_inc,button_exp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView = findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        list = Arrays.asList(getResources().getStringArray(R.array.Options));
        RecyclerAdapter adapter = new RecyclerAdapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        navigationView = findViewById(R.id.nav_view);
        button_inc = findViewById(R.id.button);
        button_exp = findViewById(R.id.button2);


        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return true;
                }

            });

            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView Recyclerview, @NonNull MotionEvent motionEvent) {
                ChildView = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (ChildView != null && gestureDetector.onTouchEvent(motionEvent)) {
                    RecyclerViewItemPosition = Recyclerview.getChildAdapterPosition(ChildView);
                    Toast.makeText(MainActivity.this, list.get(RecyclerViewItemPosition), Toast.LENGTH_SHORT).show();
                    if (RecyclerViewItemPosition == 0) {
                        Intent intent = new Intent(this, FoodActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, message);
                        startActivity(intent);

                    } else if (RecyclerViewItemPosition == 1) {
                        Intent intent = new Intent(HomeFragment.this, InvestmentActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, message);
                        startActivity(intent);

                    } else if (RecyclerViewItemPosition == 2) {
                        Intent intent = new Intent(HomeFragment.this, FamilyActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, message);
                        startActivity(intent);

                    } else if (RecyclerViewItemPosition == 3) {
                        Intent intent = new Intent(HomeFragment.this, DailyActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, message);
                        startActivity(intent);

                    } else if (RecyclerViewItemPosition == 4) {
                        Intent intent = new Intent(HomeFragment.this, DebtActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, message);
                        startActivity(intent);

                    } else if (RecyclerViewItemPosition == 5) {
                        Intent intent = new Intent(HomeFragment.this, BudgetActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, message);
                        startActivity(intent);

                    }


                }

                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView Recyclerview, @NonNull MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });


    }
    public void onClickIncome(View view) {
        Intent intent = new Intent(MainActivity.this, IncomeActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void onClickExpense(View view) {
        Intent intent = new Intent(MainActivity.this, ExpenseActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    }
}