package com.java_lang_programming.android_sqlite_demo;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.java_lang_programming.android_sqlite_demo.model.Dau;
import com.java_lang_programming.android_sqlite_demo.model.DauHelper;
import com.java_lang_programming.android_sqlite_demo.util.DBHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // create object
        Button createDbBtn = (Button)findViewById(R.id.create_db_btn);
        createDbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dBHelper = null;
                try {
                    dBHelper = new DBHelper(getApplicationContext());
                } catch(Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

        Button deleteDbBtn = (Button)findViewById(R.id.delete_db_btn);
        deleteDbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dBHelper = null;
                try {
                    dBHelper = new DBHelper(getApplicationContext());
                    boolean result = dBHelper.isDatabaseDelete(getApplicationContext());
                    Log.d(TAG, " delete result : " + result);
                } catch(Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

        Button selectBtn = (Button)findViewById(R.id.select_btn);
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent recyclerViewIntent = new Intent(MainActivity.this,
                        RecyclerViewActivity.class);
                startActivity(recyclerViewIntent);*/
                Dau dau = DauHelper.getDau(getApplicationContext(), "1");
                if (dau != null) {
                    Log.d(TAG, dau.toString());
                }
                List<Dau> list = DauHelper.getDauList(getApplicationContext());
                Log.d(TAG, " list result : " + list.size());
            }
        });

        Button insertBtn = (Button)findViewById(R.id.insert_btn);
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(Dau.COL.get(0) ,"2");
                contentValues.put(Dau.COL.get(1), "20160601");
                contentValues.put(Dau.COL.get(2), "7000");
                contentValues.put(Dau.COL.get(3), "7200");
                contentValues.put(Dau.COL.get(4), System.currentTimeMillis());
                contentValues.put(Dau.COL.get(5), System.currentTimeMillis());
                long result = DauHelper.insert(getApplicationContext(), contentValues);
                Log.d(TAG, " insert result : " + result);
            }
        });

        Button updateBtn = (Button)findViewById(R.id.update_btn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(Dau.COL.get(0) ,"2");
                contentValues.put(Dau.COL.get(1), "20160601");
                contentValues.put(Dau.COL.get(2), "7300");
                contentValues.put(Dau.COL.get(3), "8000");
                contentValues.put(Dau.COL.get(9), System.currentTimeMillis());
                long result = DauHelper.update(getApplicationContext(), contentValues, "1");
                Log.d(TAG, " update result : " + result);


                /*Intent recyclerViewIntent = new Intent(MainActivity.this,
                        RecyclerViewActivity.class);
                startActivity(recyclerViewIntent);*/
            }
        });

        Button deleteBtn = (Button)findViewById(R.id.delete_btn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long result = DauHelper.delete(getApplicationContext(), "2");
                Log.d(TAG, " delete result : " + result);
                /*Intent recyclerViewIntent = new Intent(MainActivity.this,
                        RecyclerViewActivity.class);
                startActivity(recyclerViewIntent);*/
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
