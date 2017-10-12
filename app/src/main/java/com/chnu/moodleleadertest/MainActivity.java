package com.chnu.moodleleadertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button btnStartShort;
    private Button btnStartLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btnStartLong = (Button)findViewById(R.id.main_btn_start_long);
        btnStartShort = (Button)findViewById(R.id.main_btn_start_short);

        btnStartShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PrewordActivity.class);
                intent.putExtra(TestQuestionActivity.MODE, TestQuestionActivity.MODE_SHORT);
                startActivity(intent);
            }
        });
        btnStartLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PrewordActivity.class);
                intent.putExtra(TestQuestionActivity.MODE, TestQuestionActivity.MODE_LONG);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_short_test) {
            Intent intent = new Intent(MainActivity.this, PrewordActivity.class);
            intent.putExtra(TestQuestionActivity.MODE, TestQuestionActivity.MODE_SHORT);
            startActivity(intent);
        } else if (id == R.id.nav_long_test) {
            Intent intent = new Intent(MainActivity.this, PrewordActivity.class);
            intent.putExtra(TestQuestionActivity.MODE, TestQuestionActivity.MODE_LONG);
            startActivity(intent);
        } else if (id == R.id.nav_results) {
            Intent intent = new Intent(MainActivity.this, ResultsListActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_about_test) {
            Intent intent = new Intent(this, AboutTestActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_descriptions) {
            Intent intent = new Intent(this, DescriptorsListActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_person_types) {
            Intent intent = new Intent(this, PersonTypesListActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_about_app) {
            Intent intent = new Intent(this, AboutAppActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
