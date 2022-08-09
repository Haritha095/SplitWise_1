package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText e1, e2;
    TextView t1;
    int num1, num2;

    public void getNumbers() {
        TextView e1 = (TextView) findViewById(R.id.textInputEditText);
        TextView e2 = (TextView) findViewById(R.id.textInputEditText2);
        TextView t1 = (TextView) findViewById(R.id.editTextTextPersonName2);
        String s1 = e1.getText().toString();
        String s2 = e1.getText().toString();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView e1 = (EditText) findViewById(R.id.textInputEditText);
        TextView e2 = (EditText) findViewById(R.id.textInputEditText2);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        AppBarConfiguration appBarConfiguration = null;
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void doSum(View v) {

        // get the input numbers

        int sum = num1 + num2;
        t1.setText(Integer.toString(sum));


    }

    public void clearTextNum1(View v) {

        // get the input numbers
        e1.getText().clear();
    }

    public void clearTextNum2(View v) {

        // get the input numbers
        e2.getText().clear();
    }

    public void doPow(View v) {

        //checkAndClear();
        // get the input numbers

        double sum = Math.pow(num1, num2);
        t1.setText(Double.toString(sum));

    }

    // a public method to perform subtraction
    public void doSub(View v) {
        //checkAndClear();
        // get the input numbers

        int sum = num1 - num2;
        t1.setText(Integer.toString(sum));
    }


    // a public method to perform multiplication
    public void doMul(View v) {
        //checkAndClear();
        // get the input numbers

        int sum = num1 * num2;
        t1.setText(Integer.toString(sum));
    }


    // a public method to perform Division
    public void doDiv(View v) {
        //checkAndClear();
        // get the input numbers


        // displaying the text in text view assigned as t1
        double sum = num1 / (num2 * 1.0);
        t1.setText(Double.toString(sum));
    }

}
