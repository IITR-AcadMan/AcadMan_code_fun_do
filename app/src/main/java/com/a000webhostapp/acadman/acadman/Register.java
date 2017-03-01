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
import android.widget.Toast;

import static com.a000webhostapp.acadman.acadman.R.id.Register;
import static com.a000webhostapp.acadman.acadman.R.id.web;

public class Register extends AppCompatActivity {
   WebView webd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        webd=(WebView)findViewById(R.id.webd);
        Button login=(Button) findViewById(R.id.login);
        Button register=(Button)findViewById(R.id.reg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText pwd=(EditText) findViewById(R.id.regpwd);
                EditText cpwd=(EditText) findViewById(R.id.regpwd1);
                EditText name=(EditText) findViewById(R.id.name);
                EditText id=(EditText) findViewById(R.id.RegLoginID);
                EditText batch=(EditText) findViewById(R.id.batch);
                EditText sex=(EditText) findViewById(R.id.sex);
                EditText ph=(EditText) findViewById(R.id.ph);
                EditText email=(EditText) findViewById(R.id.email);
                EditText dob=(EditText) findViewById(R.id.dob);
                String a= String.valueOf(pwd.getText());
                String b= String.valueOf(cpwd.getText());
                if (a.equals(b)) {
                    webd.loadUrl(vars.domain + "register.php?name=" + String.valueOf(name.getText()) + "&id=" + String.valueOf(id.getText()) + "&pwd=" + String.valueOf(pwd.getText()) + "&batch=" + String.valueOf(batch.getText()) + "&sex=" + String.valueOf(sex.getText()) + "&ph=" + String.valueOf(ph.getText()) + "&email=" + String.valueOf(email.getText()) + "&dob=" + String.valueOf(dob.getText()));
                    setupWebViewClient();
                }
                else {
                    Toast.makeText(Register.this, "Password doesn't match", Toast.LENGTH_LONG).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login=new Intent(Register.this, Login.class);
                startActivity(login);
            }
        });


    }
    private void setupWebViewClient() {
        webd.setWebViewClient(new WebViewClient() {
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
                    String status=webd.getTitle();
                    try{if (status.equals("1")) {
                        Toast.makeText(Register.this, "Register Success", Toast.LENGTH_LONG).show();
                        Intent login = new Intent(Register.this, Login.class);
                        startActivity(login);
                        finish();}}
                    catch (Exception e)
                        {
                        Toast.makeText(Register.this, "Check Connectivity", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }}
