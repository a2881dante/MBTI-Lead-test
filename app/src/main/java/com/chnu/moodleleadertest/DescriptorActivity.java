package com.chnu.moodleleadertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.chnu.moodleleadertest.data.Data;

public class DescriptorActivity extends AppCompatActivity {

    public static final String ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptor);
        int id = getIntent().getIntExtra(ID, 0);
        ((ImageView)findViewById(R.id.descriptor_image)).setImageResource(Data.descriptorCards[id].getImg());
        ((TextView)findViewById(R.id.descriptor_title)).setText(getResources()
                .getStringArray(R.array.descriptor_title)[id]);
        ((TextView)findViewById(R.id.descriptor_text)).setText(getResources()
                .getStringArray(R.array.descriptor_text)[id]);
    }
}
