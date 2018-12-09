package com.khan.zayan.lendapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class EmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        new Timer().schedule(new TimerTask(){
            public void run() {
                EmailActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        startActivity(new Intent(EmailActivity.this, BankActivity.class));
                    }
                });
            }
        }, 4000);
        super.onStart();
    }
}
