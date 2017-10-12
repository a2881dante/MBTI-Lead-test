package com.chnu.moodleleadertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.chnu.moodleleadertest.data.ResultObject;
import com.chnu.moodleleadertest.test.KuinKameronTest;

public class ResultLeadDetailActivity extends AppCompatActivity {

    public static final String TYPE = "type";

    private TextView txtC;
    private TextView txtM;
    private TextView txtA;
    private TextView txtB;
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_lead_detail);

        int type = getIntent().getIntExtra(TYPE, 0);

        txtC = (TextView)findViewById(R.id.lead_c);
        txtM = (TextView)findViewById(R.id.lead_m);
        txtA = (TextView)findViewById(R.id.lead_a);
        txtB = (TextView)findViewById(R.id.lead_b);
        txt1 = (TextView)findViewById(R.id.lead_1);
        txt2 = (TextView)findViewById(R.id.lead_2);
        txt3 = (TextView)findViewById(R.id.lead_3);
        txt4 = (TextView)findViewById(R.id.lead_4);

        int[] data = KuinKameronTest.getCultures(type);
        txtC.setText(data[0]+"%");
        txtM.setText(data[2]+"%");
        txtA.setText(data[1]+"%");
        txtB.setText(data[3]+"%");
        data = KuinKameronTest.getAxes(type);
        txt1.setText(data[0]+"%");
        txt2.setText(data[1]+"%");
        txt3.setText(data[2]+"%");
        txt4.setText(data[3]+"%");
    }
}
