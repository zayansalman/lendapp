package com.khan.zayan.lendapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.Locale;

public class UserActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_area);

        NumberPicker.Formatter formatter = new NumberPicker.Formatter(){
            @Override
            public String format(int i) {
                return NumberFormat.getCurrencyInstance(Locale.UK).format((long)i).toString();
            }
        };

        final NumberPicker np = findViewById(R.id.numberPicker);
        np.setMinValue(30);
        np.setMaxValue(300);

        NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Toast.makeText(UserActivity.this,
                        "selected number "+ np.getValue(), Toast.LENGTH_SHORT);
            }
        };
        Button lendBtn = findViewById(R.id.lendBtn);
        lendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder( UserActivity.this);

                builder.setTitle("Are you sure?");
                builder.setMessage("When paid back within 7 days of loan, no interested is incurred." +
                        "7.5% applies to payments between 30 days." +
                        "An auto-chargeback will be attempted on final payment date.");
                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference myRef = database.getReference("Name845");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                        myRef.setValue(np.getValue()); //value here
                        setContentView(R.layout.loaned_area);
                        //dialog.dismiss();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();

            }
        });



    }
}
