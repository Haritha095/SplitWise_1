package com.example.splitwise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseExp extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DBExp";
    public static final String TABLE_NAME = "AmountDetails";
    private static final String AMOUNT_COL = "amount";
    private static final String REMARK_COL = "remark";





    public DatabaseExp(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase dbase) {
        String query = "CREATE TABLE " + TABLE_NAME+ " ("
                + AMOUNT_COL + " INTEGER , "  + REMARK_COL + " TEXT )";

        // at last we are calling a exec sql
        // method to execute above sql query
        dbase.execSQL(query);

    }


    public void insertValues(String amount, String remark) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AMOUNT_COL, amount);
        contentValues.put(REMARK_COL, remark);

        db.insert(TABLE_NAME, null, contentValues);
        db.close();

    }


    public ArrayList<Expense> readDataList() {
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorData = db.rawQuery("SELECT * FROM " + TABLE_NAME ,null);

        // on below line we are creating a new array list.
        ArrayList<Expense> cursorDataList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorData.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                cursorDataList.add(new Expense(cursorData.getString(0),
                        cursorData.getString(1)
                ));
            } while (cursorData.moveToNext());
            // moving our cursor to next.
        }
        cursorData.close();
        return cursorDataList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }


}
