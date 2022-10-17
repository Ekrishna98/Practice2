package com.example.practice_2.SnackBar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practice_2.R;
import com.google.android.material.snackbar.Snackbar;

public class SnackBar extends AppCompatActivity implements View.OnClickListener {
    private Button b1, b2, b3, b4, b5;
    LinearLayout linearlayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        linearlayout = findViewById(R.id.LinearLayout1);

        b1 = findViewById(R.id.snackBar1);
        b1.setOnClickListener(this);

        b2 = findViewById(R.id.snackBar2);
        b2.setOnClickListener(this);

        b3 = findViewById(R.id.snackBar3);
        b3.setOnClickListener(this);

        b4 =  findViewById(R.id.snackBar4);
        b4.setOnClickListener(this);

        b5 =  findViewById(R.id.snackBar5);
        b5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.snackBar1:
                showSnackBarSingleLine();
                break;
            case R.id.snackBar2:
                showSnackBarMultipleLine();
                break;
            case R.id.snackBar3:
                showSnackBarSingleLineWithActionButton();
                break;
            case R.id.snackBar4:
                showSnackBarMultipleLineWithActionButton();
                break;
            case R.id.snackBar5:
                showCustomSnackBar();
                break;
        }

    }

    private void showSnackBarSingleLine() {
        Snackbar snackbar = Snackbar.make(linearlayout, "SnackBar Single Line", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    private void showSnackBarMultipleLine() {
        Snackbar snackbar = Snackbar.make(linearlayout, "SnackBar Multiple Line \n Krishna Kumar", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    private void showSnackBarSingleLineWithActionButton() {
        Snackbar snackbar = Snackbar.make(linearlayout, "Want to delete  file", Snackbar.LENGTH_INDEFINITE);

        snackbar.setAction("Yes", new View.OnClickListener() {@Override
        public void onClick(View view) {
            Toast.makeText(SnackBar.this, "Your file is deleted  ", Toast.LENGTH_SHORT).show();
        }
        });
        snackbar.show();
    }

    private void showSnackBarMultipleLineWithActionButton() {
        Snackbar snackbar = Snackbar.make(linearlayout, "Are you sure Wanted to delete the  file , it is a simple multiple line snackBar ", Snackbar.LENGTH_INDEFINITE);

        snackbar.setAction("Yes", new View.OnClickListener() {@Override
        public void onClick(View view) {
            Toast.makeText(SnackBar.this, "Your file is deleted  ", Toast.LENGTH_SHORT).show();
        }
        });
        snackbar.show();
    }

    private void showCustomSnackBar() {

        Snackbar snackbar = Snackbar.make(linearlayout, "You are not connected to internet ", Snackbar.LENGTH_LONG).setAction("RETRY", new View.OnClickListener() {@Override
        public void onClick(View view) {
            Toast.makeText(SnackBar.this, "Waiting for connection ", Toast.LENGTH_SHORT).show();

        }
        });
        //setting action text color o red
        snackbar.setActionTextColor(Color.RED);
        View sbView = snackbar.getView();
        //getting the textview of the SnackBar
        TextView textView = (TextView) sbView.findViewById(com.google.android.material.R.id.snackbar_text);
        //setting SnackBar text color to green
        textView.setTextColor(Color.GREEN);
        snackbar.show();
}
}