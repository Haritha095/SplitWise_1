package com.example.splitwise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class IncomeActivity extends AppCompatActivity {
    Button  readbtn;
    EditText remark, date, amount;
    private DatabaseExp helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        date = findViewById(R.id.editTextDate);
        remark = findViewById(R.id.editTextTextPersonName);
        amount = findViewById(R.id.editTextNumber);
        readbtn = findViewById(R.id.button3);
        helper=new DatabaseExp(IncomeActivity.this);
        readbtn.setOnClickListener(view -> {

            String remarks = remark.getText().toString();
            String amounts = amount.getText().toString();
            // validating if the text fields are empty or not.
            if (remarks.isEmpty() && amounts.isEmpty()) {
                Toast.makeText(IncomeActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                return;
            }
          //  DatabaseHelper db = new DatabaseHelper(IncomeActivity.this);
            helper.insertValues(remarks, amounts);
            Toast.makeText(IncomeActivity.this, "added", Toast.LENGTH_SHORT).show();
            remark.setText("");
            amount.setText("");

        });
    }
}


