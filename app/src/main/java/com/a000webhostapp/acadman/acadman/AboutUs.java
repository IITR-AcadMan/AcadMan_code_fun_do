package com.a000webhostapp.acadman.acadman;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {
TextView link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
      link=(TextView) findViewById(R.id.link);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open("http://acadman.herobo.com");
            }
        });
    }
    public void open (String inUrl){
        Intent a = new Intent (Intent.ACTION_VIEW, Uri.parse(inUrl));
    startActivity(a);
    }

}
