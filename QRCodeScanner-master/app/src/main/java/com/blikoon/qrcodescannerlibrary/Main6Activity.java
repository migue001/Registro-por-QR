package com.blikoon.qrcodescannerlibrary;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main6Activity extends AppCompatActivity {
    private final int DURACION_SPLASH = 700;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Main6Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

        },DURACION_SPLASH);
    }
}
