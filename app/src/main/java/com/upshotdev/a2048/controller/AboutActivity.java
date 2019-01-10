package com.upshotdev.a2048.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.upshotdev.a2048.R;
import com.upshotdev.a2048.halper.UpshotLink;
import com.upshotdev.a2048.halper.Utility;


public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_back_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void instagramPage(View view) {
        Utility.instagramPage(this, UpshotLink.instagram);
    }
    public void sendEmail(View view) {
        Utility.sendEmail(this,UpshotLink.gmail);
    }
}
