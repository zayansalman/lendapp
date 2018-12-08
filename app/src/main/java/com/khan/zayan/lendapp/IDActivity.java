package com.khan.zayan.lendapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.microblink.MicroblinkSDK;


public class IDActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_id);

        MicroblinkSDK.setLicenseKey("sRwAAAAWY29tLmtoYW4uemF5YW4ubGVuZGFwcOuU+whudalOF3c/xj0p+PmcLbphBj72OIYLcqtuHwjC5TZihjMWf4+AqH0c0tfsAK7GuWQOjapMLazowj0yURzfmLCoSFL076cVMCP8YlULWVsvE9UA1a7ldgC52lo0m3hifYe/KSl9fok0P1mj3tuHxBlitS6WPS8C66dmN2ZL24t01Q+v++6jE8Yj68oboj9g+Y+gKCBSS0iqFc9mpT5L7J4zlD8njuOmEnCTQZ5EIfPe2qcDUt8h", this);
    }
}
