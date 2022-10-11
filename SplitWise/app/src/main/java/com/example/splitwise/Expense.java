package com.example.splitwise;

public class Expense {
    private String amount;
    private String  remark;

    // creating getter and setter methods
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    // constructor
    public Expense(String remark, String amount) {
        this.remark = remark;
        this.amount = amount;



    }
}

