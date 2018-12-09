package com.khan.zayan.lendapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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



    }
}
