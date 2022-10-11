package com.example.operations;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OperationUtility
{
    EditText num1;
    EditText num2;
    @SuppressLint("StaticFieldLeak")
    static TextView result;
    Button buttonAdd,buttonSub,buttonMulti,buttonDiv;
    public OperationUtility(MainActivity itemView) {
        num1 = (EditText) itemView.findViewById(R.id.number_1);
        num2 = (EditText) itemView.findViewById(R.id.number_2);
        result = (TextView) itemView.findViewById(R.id.text_result);
           }

      @SuppressLint("SetTextI18n")
        public static void add(EditText num1, EditText num2) {
            double n1 =  Double.parseDouble(num1.getText().toString());
           double n2 =  Double.parseDouble(num2.getText().toString());
            double sum = n1 + n2;
            result.setText(Double.toString(sum));

    }
    @SuppressLint("SetTextI18n")
    public void sub(EditText num1, EditText num2) {
        double n1 =  Double.parseDouble(num1.getText().toString());
        double n2 =  Double.parseDouble(num2.getText().toString());
        double diff = n1 - n2;
        result.setText(Double.toString(diff));


    }
    public static void multi(EditText num1, EditText num2) {
        double n1 =  Double.parseDouble(num1.getText().toString());
        double n2 =  Double.parseDouble(num2.getText().toString());
        double multi = n1 * n2;
        result.setText(Double.toString(multi));

    }
    public static void div(EditText num1, EditText num2) {

       double n1 =  Double.parseDouble(num1.getText().toString());
        double n2 =  Double.parseDouble(num2.getText().toString());
        double div = n1 / n2;
        result.setText(Double.toString(div));

    }


}
