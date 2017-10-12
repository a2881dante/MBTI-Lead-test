package com.chnu.moodleleadertest;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.chnu.moodleleadertest.app.DBHelper;
import com.chnu.moodleleadertest.dao.Result;
import com.chnu.moodleleadertest.data.ResultObject;

import java.util.ArrayList;

public class ResultsListActivity extends AppCompatActivity {

    private ListView lstResults;

    private DBHelper dbHelper;
    private ArrayList<Integer> ids;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_list);

        dbHelper = new DBHelper(this);
        lstResults = (ListView)findViewById(R.id.results_lists);
        ids = new ArrayList<>();
        list = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.TABLE_RESULTS
                , new String[]{"e","i","s","n","t","f","j","p","page","person","id","user"}
                , null
                , null
                , null
                , null
                , null);
        while (cursor.moveToNext()) {
            ids.add(cursor.getInt(cursor.getColumnIndex("id")));
            list.add(cursor.getInt(cursor.getColumnIndex("id"))
                    + ". "
                    + cursor.getString(cursor.getColumnIndex("user"))
                    + " - "
                    + cursor.getString(cursor.getColumnIndex("person")));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this
                , android.R.layout.simple_list_item_1, list);
        lstResults.setAdapter(adapter);

        lstResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                Cursor cursor = db.query(DBHelper.TABLE_RESULTS
                        , new String[]{"e","i","s","n","t","f","j","p","page","person","id"}
                        , "id= ?"
                        , new String[]{ids.get(i)+""}
                        , null
                        , null
                        , null);
                while(cursor.moveToNext()){
                    ResultObject.result = new Result();
                    ResultObject.result.resValue[0][0] = cursor.getInt(cursor.getColumnIndex("e"));
                    ResultObject.result.resValue[0][1] = cursor.getInt(cursor.getColumnIndex("i"));
                    ResultObject.result.resValue[1][0] = cursor.getInt(cursor.getColumnIndex("s"));
                    ResultObject.result.resValue[1][1] = cursor.getInt(cursor.getColumnIndex("n"));
                    ResultObject.result.resValue[2][0] = cursor.getInt(cursor.getColumnIndex("t"));
                    ResultObject.result.resValue[2][1] = cursor.getInt(cursor.getColumnIndex("f"));
                    ResultObject.result.resValue[3][0] = cursor.getInt(cursor.getColumnIndex("j"));
                    ResultObject.result.resValue[3][1] = cursor.getInt(cursor.getColumnIndex("p"));
                    ResultObject.result.page = cursor.getInt(cursor.getColumnIndex("page"));
                    ResultObject.result.type = cursor.getString(cursor.getColumnIndex("person"));
                }
                Intent intent = new Intent(ResultsListActivity.this, ResultActivity.class);
                intent.putExtra(ResultActivity.MODE, ResultActivity.MODE_OLD);
                startActivity(intent);
            }
        });
    }
}
