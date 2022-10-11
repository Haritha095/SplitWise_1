package com.example.operations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText number1;
    EditText number2;
    TextView result;
    Button buttonAdd, buttonSub, buttonMulti, buttonDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = findViewById(R.id.number_1);
        number2 = findViewById(R.id.number_2);

        result = findViewById(R.id.text_result);
        buttonAdd = findViewById(R.id.button_add);
        buttonSub = findViewById(R.id.button_subtract);
        buttonMulti = findViewById(R.id.button_multi);
        buttonDiv = findViewById(R.id.button_div);
        buttonAdd.setOnClickListener(view -> {

            OperationUtility operationUtility;
            operationUtility = new OperationUtility(MainActivity.this);
            operationUtility.add(number1, number2);
        });
        buttonSub.setOnClickListener(view -> {

            OperationUtility operationUtility;
            operationUtility = new OperationUtility(MainActivity.this);
            operationUtility.sub(number1, number2);
        });
        buttonMulti.setOnClickListener(view -> {

            OperationUtility operationUtility;
            operationUtility = new OperationUtility(MainActivity.this);
            operationUtility.multi(number1, number2);
        });
        buttonDiv.setOnClickListener(view -> {

            OperationUtility operationUtility;
            operationUtility = new OperationUtility(MainActivity.this);
            operationUtility.div(number1, number2);
        });

    }
}