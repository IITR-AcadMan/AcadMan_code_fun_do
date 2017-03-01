package com.a000webhostapp.acadman.acadman;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        web=(WebView) findViewById(R.id.web);
        String batch=vars.batch;
        web.loadUrl(vars.domain+"schedule.php?batch="+batch+"&table=rs");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selected=item.getItemId();
        if (selected==R.id.edit)
        {
            Intent edit=new Intent(Dashboard.this, Edit.class);
            startActivity(edit);

        return  true;}

        if (selected==R.id.refresh)
        {Intent refresh = new Intent (Dashboard.this,Dashboard.class);
            startActivity(refresh);
            finish();


            return  true;}
        if (selected==R.id.us)
        {Intent us = new Intent (Dashboard.this,Upcoming.class);
            startActivity(us);

            return  true;}
         if (selected==R.id.ds)
        {Intent ds = new Intent (Dashboard.this,Default.class);
            startActivity(ds);

            return  true;}
        if (selected==R.id.prof)
        {
            Intent login=new Intent(Dashboard.this, Profile.class);
            startActivity(login);

            return  true;}
        if (selected==R.id.logout)
        {
             Intent login=new Intent(Dashboard.this, Login.class);
              startActivity(login);
            finish();

            return  true;}
        if (selected==R.id.abtus)
        {
            Intent login=new Intent(Dashboard.this, AboutUs.class);
            startActivity(login);

            return  true;}
        if (selected==R.id.regbatch)
        {
            Intent lon=new Intent(Dashboard.this, Regbatch.class);
            startActivity(lon);

            return  true;}
        return super.onOptionsItemSelected(item);}


}