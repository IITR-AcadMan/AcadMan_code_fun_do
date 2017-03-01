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

public class Default extends AppCompatActivity {
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
        web=(WebView) findViewById(R.id.web);
        String batch=vars.batch;
        web.loadUrl(vars.domain+"schedule.php?batch="+batch+"&table=ds");

    }
    private void setupWebViewClient() {
        web.setWebViewClient(new WebViewClient() {
            private int running = 0; // Could be public if you want a timer to check.


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                running = Math.max(running, 1); // First request move it to 1.
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if(--running == 0) {
                    // Toast.makeText(Dashboard.this, "kkkk", Toast.LENGTH_SHORT).show();
                    /*String status=web.getTitle();
                    if (status.equals("1")) {
                        Intent dashboard = new Intent(Login.this, Dashboard.class);
                        startActivity(dashboard);
                        finish();
                    }
                    else if (status.equals("0")) {
                        Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Login.this, "Check Connectivity", Toast.LENGTH_SHORT).show();
                    }*/
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ds,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selected=item.getItemId();
        if (selected==R.id.edit)
        {
            Intent edit=new Intent(Default.this, Edit.class);
            startActivity(edit);

            return  true;}

        if (selected==R.id.refresh)
        {Intent refresh = new Intent (Default.this,Default.class);
            startActivity(refresh);
            finish();


            return  true;}
        if (selected==R.id.regbatch)
        {
            Intent lon=new Intent(Default.this, Regbatch.class);
            startActivity(lon);

            return  true;}
        if (selected==R.id.us)
        {Intent us = new Intent (Default.this,Upcoming.class);
            startActivity(us);

            return  true;}
        if (selected==R.id.rs)
        {Intent rs = new Intent (Default.this,Dashboard.class);
            startActivity(rs);

            return  true;}
        if (selected==R.id.prof)
        {
            Intent login=new Intent(Default.this, Profile.class);
            startActivity(login);

            return  true;}
        if (selected==R.id.logout)
        {
            Intent login=new Intent(Default.this, Login.class);
            startActivity(login);
            finish();

            return  true;}
        if (selected==R.id.abtus)
        {
            Intent login=new Intent(Default.this, AboutUs.class);
            startActivity(login);

            return  true;}
        return super.onOptionsItemSelected(item);}
}