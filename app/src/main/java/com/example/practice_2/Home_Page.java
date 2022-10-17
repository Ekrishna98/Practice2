package com.example.practice_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.practice_2.Spinner_Demo.Spinner_Demo;

public class Home_Page extends AppCompatActivity implements View.OnClickListener {
    Button SnackBar , ListView , SpinnerDemo , Navigation, Navi_Drawer, SQLite_Insert, FirebaseToken;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        ListView = findViewById(R.id.BtnListView);
        ListView.setOnClickListener(this);

        SnackBar = findViewById(R.id.BtnSnackBar);
        SnackBar.setOnClickListener(this);

        SpinnerDemo = findViewById(R.id.BtnSpinnerDemo);
        SpinnerDemo.setOnClickListener(this);

        Navigation = findViewById(R.id.BtnNavigation);
        Navigation.setOnClickListener(this);

        Navi_Drawer = findViewById(R.id.BtnNavi_Drawer);
        Navi_Drawer.setOnClickListener(this);

        SQLite_Insert = findViewById(R.id.BtnSQLite_InsertData);
        SQLite_Insert.setOnClickListener(this);

        FirebaseToken = findViewById(R.id.BtnFirebaseToken);
        FirebaseToken.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BtnSnackBar:
                startActivity(new Intent(Home_Page.this, com.example.practice_2.SnackBar.SnackBar.class));
                break;
            case R.id.BtnListView:
                startActivity(new Intent(Home_Page.this, com.example.practice_2.ListView.ListView_Main.class));
                break;
            case R.id.BtnSpinnerDemo:
                startActivity(new Intent(Home_Page.this, Spinner_Demo.class));
                break;
            case R.id.BtnNavigation:
                startActivity(new Intent(Home_Page.this, Navigation_Topic.class));
                break;
            case R.id.BtnNavi_Drawer:
                startActivity(new Intent(Home_Page.this, Navigation_Drawer.class));
                break;
            case R.id.BtnSQLite_InsertData:
                startActivity(new Intent(Home_Page.this, com.example.practice_2.SQLiteDatabase.SQLite_InsertData.class));
                break;
            case R.id.BtnFirebaseToken:
                startActivity(new Intent(Home_Page.this, com.example.practice_2.Firebase.Firebase_Main.class));
                break;
        }
    }
}





//    @Override
//    protected void onResume() {
//        super.onResume();
//        // Hide StatusBar & Navigation Bar..........
//        View windowDecorView = getWindow().getDecorView();
//        windowDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//
//    }



/**
 toolbar = findViewById(R.id.Home_ToolBar);
 setSupportActionBar(toolbar);
 toolbar.setTitle("Practice 2");
 Log.v("", "ToolBar Show setting");
 if (toolbar != null) {
 getSupportActionBar().setDisplayShowHomeEnabled(true);
 getSupportActionBar().setDisplayHomeAsUpEnabled(true);
 }
 }

 @Override
 public boolean onSupportNavigateUp() {
 onBackPressed();
 finish();
 return true;
 }       // End BackButton ActionBar......... **/