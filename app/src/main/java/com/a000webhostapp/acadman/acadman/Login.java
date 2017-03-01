package com.a000webhostapp.acadman.acadman;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    WebView web,getbatch;
    ProgressBar opened;
Button loginbtn, signup;
    String idtext,got;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText id=(EditText) findViewById(R.id.loginid);
        final EditText pwd=(EditText) findViewById(R.id.loginpwd);
        opened = (ProgressBar) findViewById(R.id.progressBar3);
        signup=(Button)findViewById(R.id.regisbtn);
        loginbtn=(Button)findViewById(R.id.Loginbtn);
        web=(WebView) findViewById(R.id.web);
        getbatch=(WebView)findViewById(R.id.batch);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idtext= String.valueOf(id.getText());
                String pwdtext= String.valueOf(pwd.getText());
                opened.setVisibility(View.VISIBLE);
                web.loadUrl(vars.domain+"login.php?id="+idtext+"&pwd="+pwdtext);
                setupWebViewClient();

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup=new Intent(Login.this,Register.class);
               startActivity(signup);
            }



    });
}
    private void setupWebViewClient() {
        web.setWebViewClient(new WebViewClient() {
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
                if(--running == 0) {   opened.setVisibility(View.INVISIBLE);
                    try{String status;
                    status=web.getTitle();
                    if (status.equals("1")) {
                        vars.id=idtext;
                        getbatch.loadUrl(vars.domain+"getbatch.php?slot=batch&table=users&id="+idtext);
                        getter();
                        Intent dashboard = new Intent(Login.this, Dashboard.class);
                        startActivity(dashboard);
                        finish();
                    }
                    else if (status.equals("0")) {
                        Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_LONG).show();
                    }}
                    catch (Exception e)
                        {
                        Toast.makeText(Login.this, "Check Connectivity", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    private void getter() {
        getbatch.setWebViewClient(new WebViewClient() {
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
                   try{got=getbatch.getTitle();
                   vars.batch=got;}
                   catch (Exception e){

                   }
                }
            }
        });
    }}