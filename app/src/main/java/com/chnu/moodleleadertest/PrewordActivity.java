package com.chnu.moodleleadertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrewordActivity extends AppCompatActivity {

    private Button btnNext;
    private int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preword);
        mode = getIntent().getIntExtra(TestQuestionActivity.MODE, 0);

        btnNext = (Button)findViewById(R.id.preword_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrewordActivity.this, TestQuestionActivity.class);
                intent.putExtra(TestQuestionActivity.MODE, mode);
                startActivity(intent);
                finish();
            }
        });
    }
}
