package com.chnu.moodleleadertest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SpalshActivity extends AppCompatActivity {

    private static final int TIME_SEC = 2;
    private static final int MILISEC = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SpalshActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, MILISEC*TIME_SEC);
    }
}
