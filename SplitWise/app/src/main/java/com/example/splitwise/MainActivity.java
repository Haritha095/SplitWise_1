package com.example.splitwise;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener   {
    private String message;
    private List<String> list;
    View ChildView;
    int RecyclerViewItemPosition;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
        Button button_inc,button_exp;
        RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        list = Arrays.asList(getResources().getStringArray(R.array.Options));
        RecyclerAdapter adapter = new RecyclerAdapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        navigationView = findViewById(R.id.nav_view);
        setNavigationViewListener();
        button_inc = findViewById(R.id.button);
        button_exp = findViewById(R.id.button2);
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Home()).commit();
            navigationView.setCheckedItem(R.id.fragment_about);

        }
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
                        Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, message);
                        startActivity(intent);
                    } else if (RecyclerViewItemPosition == 1) {
                        Intent intent = new Intent(MainActivity.this, InvestmentActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, message);
                        startActivity(intent);

                    } else if (RecyclerViewItemPosition == 2) {
                        Intent intent = new Intent(MainActivity.this, FamilyActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, message);
                        startActivity(intent);

                    } else if (RecyclerViewItemPosition == 3) {
                        Intent intent = new Intent(MainActivity.this, DailyActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, message);
                        startActivity(intent);

                    } else if (RecyclerViewItemPosition == 4) {
                        Intent intent = new Intent(MainActivity.this, DebtActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, message);
                        startActivity(intent);

                    } else if (RecyclerViewItemPosition == 5) {
                        Intent intent = new Intent(MainActivity.this, BudgetActivity.class);
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

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you want to exit ?");
        builder.setTitle("Alert !");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (dialog, which) -> finish());
        builder.setNegativeButton("No", (dialog, which) -> dialog.cancel());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void setNavigationViewListener() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        button_inc = findViewById(R.id.button);
        button_exp = findViewById(R.id.button2);
        RecyclerView recyclerView = findViewById(R.id.recycler);


        switch (item.getItemId()) {
            case R.id.about: {

               // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
               //         new About()).commit();
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                                break;
            }
            case R.id.home: {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                break;
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
