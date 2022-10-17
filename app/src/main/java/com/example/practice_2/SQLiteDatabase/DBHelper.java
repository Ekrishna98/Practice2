package com.example.practice_2.SQLiteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "SQLite_InsertData";
    public static final String TABLE_NAME = "InsertData";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FIRSTNAME";
    public static final String COL_3 = "LASTNAME";
    public static final String COL_4 = "COURSE";
    public static final String COL_5 = "EMAIL";
    public static final String COL_6 = "PHONE";

    //Constructor
    public DBHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("Create table " + TABLE_NAME  + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT, LASTNAME TEXT, COURSE Text, EMAIL TEXT,PHONE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db);
    }

    public void InsertData(String firstName, String LastName, String Course, String Email, String Phone){
        SQLiteDatabase dbb = this.getWritableDatabase();
        ContentValues con = new ContentValues();
        con.put(COL_2,firstName);
        con.put(COL_3,LastName);
        con.put(COL_4,Course);
        con.put(COL_5,Email);
        con.put(COL_6,Phone);
        dbb.insert(TABLE_NAME,null,con);
      //  dbb.close();
    }

    public ArrayList<EmployeeModel> fetchData() {
        SQLiteDatabase dbb = this.getReadableDatabase();
        Cursor cursor = dbb.rawQuery(" SELECT * FROM " + TABLE_NAME, null);

        ArrayList<EmployeeModel> arrayList = new ArrayList<>();

        while (cursor.moveToNext()) {

            EmployeeModel employeeModel = new EmployeeModel();
            employeeModel.ID = cursor.getInt(0);
            employeeModel.FirstName = cursor.getString(1);
            employeeModel.LastName = cursor.getString(2);
            employeeModel.Course = cursor.getString(3);
            employeeModel.Mail = cursor.getString(4);
            employeeModel.Phone = cursor.getString(5);

            arrayList.add(employeeModel);
        }
        return arrayList;
    }

}
