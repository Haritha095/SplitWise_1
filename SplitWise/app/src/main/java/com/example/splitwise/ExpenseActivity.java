package com.example.splitwise;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class ExpenseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] users = {"Food", "Investment", "Family", "Daily Necessities", "Debt and Loan", "Budget Balance"};
    Button button;
    EditText remark, amount;

    private DatabaseExp helper;
    private DatabaseHelper help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
        remark = findViewById(R.id.edit_remark);
        amount = findViewById(R.id.edit_amount);
        button = findViewById(R.id.button_save);
        helper = new DatabaseExp(ExpenseActivity.this);
        help = new DatabaseHelper(ExpenseActivity.this);
        button.setOnClickListener(view -> {
            String remarks = remark.getText().toString();
            String amounts = amount.getText().toString();
            String ids = spin.toString();
            //String nums=String.valueOf(num);
            // validating if the text fields are empty or not.
            if (remarks.isEmpty() && amounts.isEmpty()) {
                Toast.makeText(ExpenseActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                return;
            }
            if (users[0] == "Food") {
                helper.insertValues(remarks, amounts);
                Toast.makeText(ExpenseActivity.this, "added", Toast.LENGTH_SHORT).show();
                // remark.setText("");
                // amount.setText("");
                //  DatabaseHelper db = new DatabaseHelper(IncomeActivity.this);
            } else if (users[1] == "Investment") {
                help.insertValues_1(remarks, amounts);
                Toast.makeText(ExpenseActivity.this, "added", Toast.LENGTH_SHORT).show();
                // remark.setText("");
                // amount.setText("");
                //  DatabaseHelper db = new DatabaseHelper(IncomeActivity.this);
            }

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        String remarks = remark.getText().toString();
        String amounts = amount.getText().toString();


        Toast.makeText(getApplicationContext(), "Selected User: " + users[position], Toast.LENGTH_SHORT).show();
        remark.setText("");
        amount.setText("");

    }



    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}