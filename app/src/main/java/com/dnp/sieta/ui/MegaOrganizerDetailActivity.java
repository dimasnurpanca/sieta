package com.dnp.sieta.ui;

import android.app.Activity;
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
import android.widget.Toast;

import com.dnp.sieta.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MegaOrganizerDetailActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    Activity context = this;

    private boolean canExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mega_organizerdetail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            Toast.makeText(MegaOrganizerDetailActivity.this, "Fitur ini belum tersedia", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MegaOrganizerActivity.class));
        finish();
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch(item.getItemId()) {
            case R.id.nav_item_account:
                startActivity(new Intent(getApplicationContext(), MyAccountActivity.class));
                finish();
                break;
            case R.id.nav_item_mart:
                startActivity(new Intent(getApplicationContext(), MartActivity.class));
                finish();
                break;
            case R.id.nav_item_video:
                startActivity(new Intent(getApplicationContext(), VideoActivity.class));
                finish();
                break;
            case R.id.nav_item_event:
                startActivity(new Intent(getApplicationContext(), EventActivity.class));
                finish();
                break;
            case R.id.nav_item_komunitas:
                startActivity(new Intent(getApplicationContext(), KomunitasActivity.class));
                finish();
                break;
            case R.id.nav_item_status:
                break;
            case R.id.nav_item_help:
                break;
            case R.id.nav_item_logout:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
