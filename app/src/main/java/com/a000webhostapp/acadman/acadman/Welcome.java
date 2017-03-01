package com.a000webhostapp.acadman.acadman;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Welcome extends AppCompatActivity {

ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
      //  SharedPreferences sharedPref = Welcome.this.getPreferences(Context.MODE_PRIVATE);
      //  String id = sharedPref.getString(vars.id, "0");
        getSupportActionBar().hide();
progress = (ProgressBar) findViewById(R.id.progressBar);
        new CountDownTimer(2000,1){
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {   Intent passed=new Intent(Welcome.this,Login.class);
                startActivity(passed);
                finish();
            }
        }.start();
    }
  public void check () {
        SQLiteDatabase login = openOrCreateDatabase("login", MODE_PRIVATE, null);
        login.execSQL("CREATE TABLE IF NOT EXISTS login(id VARCHAR,pwd VARCHAR);");
        Cursor resultSet = login.rawQuery("Select * from login", null);
        resultSet.moveToFirst();
        String id = resultSet.getString(0);
        String pwd = resultSet.getString(1);
        if (id.equals(""))
        {Intent passed=new Intent(Welcome.this,Login.class);
        startActivity(passed);
  }
        else
        {
            Intent failed=new Intent(Welcome.this,Dashboard.class);
            startActivity(failed);
            Toast.makeText(this, "kaishu101sahu", Toast.LENGTH_SHORT).show();
        }
    }}