package com.example.practice_2.Spinner_Demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practice_2.R;

public class Spinner_Demo extends AppCompatActivity {

    Spinner classSpinner, DivSpinner;
    String selectedClass, selectedDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);
        classSpinner = findViewById(R.id.classSpinner);
        DivSpinner = findViewById(R.id.divSpinner);
        //set divSpinner Visibility to Visible


        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 selectedClass = parent.getItemAtPosition(position).toString();
                DivSpinner.setVisibility(View.VISIBLE);
                 switch (selectedClass){
                     case "Class 1":
                         DivSpinner.setAdapter(new ArrayAdapter<String>(Spinner_Demo.this,
                                 android.R.layout.simple_spinner_dropdown_item,
                                 getResources().getStringArray(R.array.items_div_class_1)));
                         break;
                     case "Class 2":
                         DivSpinner.setAdapter(new ArrayAdapter<String>(Spinner_Demo.this,
                                 android.R.layout.simple_spinner_dropdown_item,
                                 getResources().getStringArray(R.array.items_div_class_2)));
                         break;
                     case "Class 3":
                         DivSpinner.setAdapter(new ArrayAdapter<String>(Spinner_Demo.this,
                                 android.R.layout.simple_spinner_dropdown_item,
                                 getResources().getStringArray(R.array.items_div_class_3)));
                         break;
                     case "Class 4":
                         DivSpinner.setAdapter(new ArrayAdapter<String>(Spinner_Demo.this,
                                 android.R.layout.simple_spinner_dropdown_item,
                                 getResources().getStringArray(R.array.items_div_class_4)));
                         break;
                 }
                Log.v("","Visible SpinnerDiv");
                //set divSpinner Visibility to Visible
                DivSpinner.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        DivSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedDiv = parent.getItemAtPosition(position).toString();
                Log.v("","SpinnerDiv");
                Toast.makeText(Spinner_Demo.this, "\n Class: \t " + selectedClass +
                        "\n Div: \t" + selectedDiv, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}