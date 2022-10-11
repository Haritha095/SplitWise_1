package com.example.splitwise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapaterExpense extends RecyclerView.Adapter<AdapaterExpense.ViewHolder> {

    // variable for our array list and context
    private ArrayList<Expense> expenseList;
    private Context context;

    // constructor
    public AdapaterExpense(ArrayList<Expense> expenseList, Context context) {
        this.expenseList = expenseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new AdapaterExpense.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapaterExpense.ViewHolder holder, int position) {
        Expense expense = expenseList.get(position);
        holder.amount.setText(expense.getAmount());
        holder.remark.setText(expense.getRemark());


    }



    @Override
    public int getItemCount() {
        // returning the size of our array list
        return expenseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView amount, remark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            remark = itemView.findViewById(R.id.remark_main);
            amount = itemView.findViewById(R.id.amount_main);

        }
    }

}
