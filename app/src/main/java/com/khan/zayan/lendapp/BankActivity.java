package com.khan.zayan.lendapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                        startActivity(new Intent(BankActivity.this, UserActivity.class));
                    }
                });
            }
        }, 4000);
        super.onStart();

        Button lendButton = findViewById(R.id.lendButton);


        lendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BankActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
    }
}
