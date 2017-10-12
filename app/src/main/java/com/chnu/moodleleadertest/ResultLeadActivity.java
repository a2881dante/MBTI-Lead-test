package com.chnu.moodleleadertest;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chnu.moodleleadertest.test.KuinKameronTest;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class ResultLeadActivity extends AppCompatActivity {

    private GraphView graph;
    private TextView txtLeader;
    private TextView txtEmploy;
    private Button btnLeader;
    private Button btnEmploy;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_lead);

        graph = (GraphView)findViewById(R.id.result_lead_graph);
        txtLeader = (TextView)findViewById(R.id.result_lead_l_txt);
        txtEmploy = (TextView)findViewById(R.id.result_lead_e_txt);
        btnLeader = (Button)findViewById(R.id.result_lead_leader);
        btnEmploy = (Button)findViewById(R.id.result_lead_employ);

        btnLeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultLeadActivity.this, ResultLeadDetailActivity.class);
                intent.putExtra(ResultLeadDetailActivity.TYPE, KuinKameronTest.TYPE_LEADER);
                startActivity(intent);
            }
        });
        btnEmploy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultLeadActivity.this, ResultLeadDetailActivity.class);
                intent.putExtra(ResultLeadDetailActivity.TYPE, KuinKameronTest.TYPE_EMPLOY);
                startActivity(intent);
            }
        });

        txtLeader.setText("Культура лидера: "
                + KuinKameronTest.getMainCulture(KuinKameronTest.TYPE_LEADER));
        txtEmploy.setText("Культура подчиненого: "
                + KuinKameronTest.getMainCulture(KuinKameronTest.TYPE_EMPLOY));

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(-100);
        graph.getViewport().setMaxX(100);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-100);
        graph.getViewport().setMaxY(100);
        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    return super.formatLabel(Math.abs(value), isValueX);
                } else {
                    // show currency for y values
                    return super.formatLabel(Math.abs(value), isValueX);
                }
            }
        });

        int[] points = KuinKameronTest.getCultures(KuinKameronTest.TYPE_LEADER);

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(-points[0], points[0]),
                new DataPoint(points[1], points[1])
        });
        series2.setColor(Color.RED);
        graph.addSeries(series2);
        if(points[1]<points[2]){
            series2 = new LineGraphSeries<>(new DataPoint[] {
                    new DataPoint(points[1], points[1]),
                    new DataPoint(points[2], -points[2])
            });
        }else{
            series2 = new LineGraphSeries<>(new DataPoint[] {
                    new DataPoint(points[2], -points[2]),
                    new DataPoint(points[1], points[1]),
            });
        }
        series2.setColor(Color.RED);
        graph.addSeries(series2);
        series2 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(-points[3], -points[3]),
                new DataPoint(points[2], -points[2])
        });
        series2.setColor(Color.RED);
        graph.addSeries(series2);
        if(-points[3]<-points[0]){
            series2 = new LineGraphSeries<>(new DataPoint[] {
                    new DataPoint(-points[3], -points[3]),
                    new DataPoint(-points[0], points[0])
            });
        }else{
            series2 = new LineGraphSeries<>(new DataPoint[] {
                    new DataPoint(-points[0], points[0]),
                    new DataPoint(-points[3], -points[3])
            });
        }
        series2.setColor(Color.RED);
        graph.addSeries(series2);

        points = KuinKameronTest.getCultures(KuinKameronTest.TYPE_EMPLOY);

        series2 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(-points[0], points[0]),
                new DataPoint(points[1], points[1])
        });
        series2.setColor(Color.BLUE);
        graph.addSeries(series2);
        if(points[1]<points[2]){
            series2 = new LineGraphSeries<>(new DataPoint[] {
                    new DataPoint(points[1], points[1]),
                    new DataPoint(points[2], -points[2])
            });
        }else{
            series2 = new LineGraphSeries<>(new DataPoint[] {
                    new DataPoint(points[2], -points[2]),
                    new DataPoint(points[1], points[1]),
            });
        }
        series2.setColor(Color.BLUE);
        graph.addSeries(series2);
        series2 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(-points[3], -points[3]),
                new DataPoint(points[2], -points[2])
        });
        series2.setColor(Color.BLUE);
        graph.addSeries(series2);
        if(-points[3]<-points[0]){
            series2 = new LineGraphSeries<>(new DataPoint[] {
                    new DataPoint(-points[3], -points[3]),
                    new DataPoint(-points[0], points[0])
            });
        }else{
            series2 = new LineGraphSeries<>(new DataPoint[] {
                    new DataPoint(-points[0], points[0]),
                    new DataPoint(-points[3], -points[3])
            });
        }
        series2.setColor(Color.BLUE);
        graph.addSeries(series2);
    }
}
