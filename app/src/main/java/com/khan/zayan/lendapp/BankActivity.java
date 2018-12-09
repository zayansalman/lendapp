package com.khan.zayan.lendapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class BankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

        new Timer().schedule(new TimerTask(){
            public void run() {
                BankActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        startActivity(new Intent(BankActivity.this, LoanedActivity.class));
                    }
                });
            }
        }, 2000);
        super.onStart();
    }
}
