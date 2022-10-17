package com.example.practice_2.SQLiteDatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practice_2.R;

import java.util.ArrayList;

public class SQLite_InsertData extends AppCompatActivity {

    EditText FName, LName, Course, Mail, Phone;
    Button Submit , SendData;
    DBHelper Db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_insert_data);
        FName = findViewById(R.id.FirstName);
        LName = findViewById(R.id.LastName);
        Course = findViewById(R.id.Course);
        Mail = findViewById(R.id.EtMail);
        Phone = findViewById(R.id.PhoneNumber);
        Submit = findViewById(R.id.SQLSubmit);
        SendData = findViewById(R.id.SQLSend);
        Db = new DBHelper(SQLite_InsertData.this);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertDataMain();
            }
        });

        SendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendData1();
            }
        });



    }

    private void SendData1() {
        DBHelper db = new DBHelper(this);
        ArrayList<EmployeeModel> InsertData = db.fetchData();
        for(int i=0; i<InsertData.size();i++){
            Log.d(" CONTACT INFO " ," Name: " + InsertData.get(i).FirstName + ", phone no: " + InsertData.get(i).Phone);
        }

    }

    private void InsertDataMain() {
        String efn = FName.getText().toString();
        String eln = LName.getText().toString();
        String course = Course.getText().toString();
        String email = Mail.getText().toString();
        String phone = Phone.getText().toString();

        if (efn.isEmpty() | eln.isEmpty() && course.isEmpty() | email.isEmpty() | phone.isEmpty()) {
            Toast.makeText(SQLite_InsertData.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
            return;
        }else {

            Db.InsertData(efn, eln, course, email, phone);
            Toast.makeText(SQLite_InsertData.this, "Course Added...", Toast.LENGTH_SHORT).show();
            FName.setText("");
            LName.setText("");
            Course.setText("");
            Mail.setText("");
            Phone.setText("");
        }


    }
}