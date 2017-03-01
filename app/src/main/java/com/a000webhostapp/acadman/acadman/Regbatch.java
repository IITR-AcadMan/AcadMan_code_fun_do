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

public class Regbatch extends AppCompatActivity {
Button  asd;
    EditText asdf;String ll;
    WebView asdfg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regbatch);
    asd= (Button)findViewById(R.id.button2);
        asdfg = (WebView)findViewById(R.id.asdfg);
        asdf = (EditText)findViewById(R.id.editText);
        asd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll= String.valueOf(asdf.getText());
                asdfg.loadUrl(vars.domain+"batch.php?batch="+ll);
                getter();

            }
        });
    }
    private void getter() {
        asdfg.setWebViewClient(new WebViewClient() {
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
                        String status=asdfg.getTitle();
                        if (status.equals("1")) {
                            Toast.makeText(Regbatch.this, "Registered Sucessfully", Toast.LENGTH_LONG).show();
                    }
                    }
                    catch (Exception e){
                        Toast.makeText(Regbatch.this, "Check Connectivity", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }}
