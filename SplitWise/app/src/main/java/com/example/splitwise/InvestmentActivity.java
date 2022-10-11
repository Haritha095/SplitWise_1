package com.example.splitwise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class InvestmentActivity extends AppCompatActivity {
    private ArrayList<Expense> expenseList;
    private DatabaseExp dbHelper;
    private AdapaterExpense adapaterExpense;
    private RecyclerView recylerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment);
        String[] users = {"Food", "Investment", "Family", "Daily Necessities", "Debt and Loan", "Budget Balance"};
        int i = 1;
        // initializing our all variables.

        expenseList = new ArrayList<>();
        dbHelper = new DatabaseExp(InvestmentActivity.this);

        // getting our course array
        // list from db handler class.
        expenseList = dbHelper.readDataList();

        // on below line passing our array lost to our adapter class.
        adapaterExpense = new AdapaterExpense(expenseList, InvestmentActivity.this);
        recylerView = findViewById(R.id.idInvestment);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(InvestmentActivity.this, RecyclerView.VERTICAL, false);
        recylerView.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        recylerView.setAdapter(adapaterExpense);
    }}