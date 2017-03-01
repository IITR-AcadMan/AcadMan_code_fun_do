package com.a000webhostapp.acadman.acadman;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Edit extends AppCompatActivity {
    Spinner abcd,qwert,table;
    String slotid,text,cast,tab="rs",dat;
    EditText data;
    Button edit;
    WebView dummy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);data=(EditText) findViewById(R.id.editText2);
        edit=(Button) findViewById(R.id.button);
        abcd= (Spinner)findViewById(R.id.spinner6);
        qwert = (Spinner)findViewById(R.id.spinner3);
        dummy=(WebView)findViewById(R.id.dummy);
        table=(Spinner)findViewById(R.id.spinner5);
        table.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int positio, long id) {
                tab=(String)parent.getItemAtPosition(positio);
                if (tab.equals("Current Schedule")){tab="rs";}
                if (tab.equals("Upcoming Schedule")){tab="us";}
                if (tab.equals("Default Schedule")){tab="ds";}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
abcd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text=(String)parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});
        qwert.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int positin, long id) {
                cast=(String)parent.getItemAtPosition(positin);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
              dat= String.valueOf(data.getText());
                dummy.loadUrl(vars.domain+"edit.php?batch="+vars.batch+"&slot="+slotid+"&table="+tab+"&data="+dat);
               setupWebViewClient();

            }
        });
    }
public void call()
{if(text.equals("Monday")&&cast.equals("08AM-09AM")){slotid="m1";}
    if(text.equals("Monday")&&cast.equals("09AM-10AM")){slotid="m2";}
    if(text.equals("Monday")&&cast.equals("10AM-11AM")){slotid="m3";}
    if(text.equals("Monday")&&cast.equals("11AM-12PM")){slotid="m4";}
    if(text.equals("Monday")&&cast.equals("12PM-01PM")){slotid="m5";}
    if(text.equals("Monday")&&cast.equals("02PM-03PM")){slotid="m6";}
    if(text.equals("Monday")&&cast.equals("03PM-04PM")){slotid="m7";}
    if(text.equals("Monday")&&cast.equals("04PM-05PM")){slotid="m8";}
    if(text.equals("Monday")&&cast.equals("05PM-06PM")){slotid="m9";}





    if(text.equals("Tuesday")&&cast.equals("08AM-09AM")){slotid="t1";}
    if(text.equals("Tuesday")&&cast.equals("09AM-10AM")){slotid="t2";}
    if(text.equals("Tuesday")&&cast.equals("10AM-11AM")){slotid="t3";}
    if(text.equals("Tuesday")&&cast.equals("11AM-12PM")){slotid="t4";}
    if(text.equals("Tuesday")&&cast.equals("12PM-01PM")){slotid="t5";}
    if(text.equals("Tuesday")&&cast.equals("02PM-03PM")){slotid="t6";}
    if(text.equals("Tuesday")&&cast.equals("03PM-04PM")){slotid="t7";}
    if(text.equals("Tuesday")&&cast.equals("04PM-05PM")){slotid="t8";}
    if(text.equals("Tuesday")&&cast.equals("05PM-06PM")){slotid="t9";}








    if(text.equals("Wednesday")&&cast.equals("08AM-09AM")){slotid="w1";}
    if(text.equals("Wednesday")&&cast.equals("09AM-10AM")){slotid="w2";}
    if(text.equals("Wednesday")&&cast.equals("10AM-11AM")){slotid="w3";}
    if(text.equals("Wednesday")&&cast.equals("11AM-12PM")){slotid="w4";}
    if(text.equals("Wednesday")&&cast.equals("12PM-01PM")){slotid="w5";}
    if(text.equals("Wednesday")&&cast.equals("02PM-03PM")){slotid="w6";}
    if(text.equals("Wednesday")&&cast.equals("03PM-04PM")){slotid="w7";}
    if(text.equals("Wednesday")&&cast.equals("04PM-05PM")){slotid="w8";}
    if(text.equals("Wednesday")&&cast.equals("05PM-06PM")){slotid="w9";}









    if(text.equals("Thursday")&&cast.equals("08AM-09AM")){slotid="th1";}
    if(text.equals("Thursday")&&cast.equals("09AM-10AM")){slotid="th2";}
    if(text.equals("Thursday")&&cast.equals("10AM-11AM")){slotid="th3";}
    if(text.equals("Thursday")&&cast.equals("11AM-12PM")){slotid="th4";}
    if(text.equals("Thursday")&&cast.equals("12PM-01PM")){slotid="th5";}
    if(text.equals("Thursday")&&cast.equals("02PM-03PM")){slotid="th6";}
    if(text.equals("Thursday")&&cast.equals("03PM-04PM")){slotid="th7";}
    if(text.equals("Thursday")&&cast.equals("04PM-05PM")){slotid="th8";}
    if(text.equals("Thursday")&&cast.equals("05PM-06PM")){slotid="th9";}







    if(text.equals("Friday")&&cast.equals("08AM-09AM")){slotid="f1";}
    if(text.equals("Friday")&&cast.equals("09AM-10AM")){slotid="f2";}
    if(text.equals("Friday")&&cast.equals("10AM-11AM")){slotid="f3";}
    if(text.equals("Friday")&&cast.equals("11AM-12PM")){slotid="f4";}
    if(text.equals("Friday")&&cast.equals("12PM-01PM")){slotid="f5";}
    if(text.equals("Friday")&&cast.equals("02PM-03PM")){slotid="f6";}
    if(text.equals("Friday")&&cast.equals("03PM-04PM")){slotid="f7";}
    if(text.equals("Friday")&&cast.equals("04PM-05PM")){slotid="f8";}
    if(text.equals("Friday")&&cast.equals("05PM-06PM")){slotid="f9";}}
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
                    try{String status;
                        status=dummy.getTitle();
                        if (status.equals("1")) {
                            Toast.makeText(Edit.this, "Sucessfully Updated", Toast.LENGTH_LONG).show();
                        }
                       }
                    catch (Exception e)
                    {
                        Toast.makeText(Edit.this, "Check Connectivity", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
