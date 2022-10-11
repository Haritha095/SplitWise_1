package com.example.splitwise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FoodActivity extends ExpenseActivity {
    private ArrayList<Expense> expenseList;
    private DatabaseExp dbHelper;
    private AdapaterExpense adapaterExpense;
    private RecyclerView recylerView;
    String[] users = {"Food", "Investment", "Family", "Daily Necessities", "Debt and Loan", "Budget Balance"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        String[] users = {"Food", "Investment", "Family", "Daily Necessities", "Debt and Loan", "Budget Balance"};
        int i = 0;
        // initializing our all variables.

        expenseList = new ArrayList<>();
        dbHelper = new DatabaseExp(FoodActivity.this);

        // getting our course array
        // list from db handler class.
        expenseList = dbHelper.readDataList();

        // on below line passing our array list to our adapter class.
        adapaterExpense = new AdapaterExpense(expenseList, FoodActivity.this);
        recylerView = findViewById(R.id.idFood);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FoodActivity.this, RecyclerView.VERTICAL, false);
        recylerView.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        recylerView.setAdapter(adapaterExpense);
    }}