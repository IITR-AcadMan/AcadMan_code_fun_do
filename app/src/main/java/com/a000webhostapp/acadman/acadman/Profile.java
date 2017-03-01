package com.a000webhostapp.acadman.acadman;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import static com.a000webhostapp.acadman.acadman.R.id.prof;
import static com.a000webhostapp.acadman.acadman.R.id.web;

public class Profile extends AppCompatActivity {
    WebView prof,dummy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        prof=(WebView) findViewById(R.id.prof);
        dummy=(WebView) findViewById(R.id.dummy);
        prof.loadUrl(vars.domain+"profile.php?id="+vars.id);
        Button del=(Button) findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dummy.loadUrl(vars.domain+"del.php?id="+vars.id);
                setupWebViewClient();
            }
        });
    }
    private void setupWebViewClient() {
        dummy.setWebViewClient(new WebViewClient() {
            private int running = 0; // Could be public if you want a timer to check.

            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String urlNewString) {
                running++;
                webView.loadUrl(urlNewString);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                running = Math.max(running, 1); // First request move it to 1.
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if(--running == 0) {
                    try{
                        String status;
                        status=dummy.getTitle();
                        if (status.equals("1")) {
                        Toast.makeText(Profile.this, "Deleted Sucessfully", Toast.LENGTH_LONG).show();
                        Intent del=new Intent(Profile.this,Login.class);
                        startActivity(del);
                        finish();}
                        }
                    catch (Exception e)
                    {
                        Toast.makeText(Profile.this, "Check Connectivity", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }
  }
