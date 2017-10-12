package com.chnu.moodleleadertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.chnu.moodleleadertest.data.Data;

public class PersonTypeActivity extends AppCompatActivity {

    public static final String ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_type);
        int id = getIntent().getIntExtra(ID, 0);
        ((TextView)findViewById(R.id.person_title)).setText(getResources()
                .getStringArray(R.array.persons_title)[id]);
        ((TextView)findViewById(R.id.person_text)).setText(getResources()
                .getStringArray(R.array.persons_text)[id]);
    }
}
