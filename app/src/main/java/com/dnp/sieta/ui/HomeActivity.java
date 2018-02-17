package com.dnp.sieta.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.dnp.sieta.R;
import com.dnp.sieta.adapter.GridViewAdapter;
import com.dnp.sieta.object.ItemObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;



public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.gridview)
    GridView gridview;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    Activity context = this;

    private boolean canExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);



        List<ItemObject> allItems = getAllItemObject();
        GridViewAdapter customAdapter = new GridViewAdapter(HomeActivity.this, allItems);
        gridview.setAdapter(customAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(HomeActivity.this, "Position: " + position, Toast.LENGTH_SHORT).show();
                if(position==0){
                    startActivity(new Intent(getApplicationContext(), ProspectActivity.class));
                    finish();
                }else if(position==1){
                    startActivity(new Intent(getApplicationContext(), CallingActivity.class));
                    finish();
                }
                else if(position==2){
                    startActivity(new Intent(getApplicationContext(), OrderActivity.class));
                    finish();
                }
                else if(position==3){
                    startActivity(new Intent(getApplicationContext(), MegaActivity.class));
                    finish();
                }
                else if(position==4){
                    startActivity(new Intent(getApplicationContext(), CVActivity.class));
                    finish();
                }
                else if(position==5){
                    Toast.makeText(HomeActivity.this, "Fitur ini belum tersedia", Toast.LENGTH_LONG).show();
                }
            }
        });
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
            Toast.makeText(HomeActivity.this, "Fitur ini belum tersedia", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(canExit){
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        }
        else{
            canExit = true;
            Toast.makeText(getApplicationContext(), "Press again to exit!", Toast.LENGTH_SHORT).show();
        }
        mHandler.sendEmptyMessageDelayed(1, 2000/*time interval to next press in milli second*/);// if not pressed within 2seconds then will be setted(canExit) as false

    }

   public Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            switch (msg.what) {
                case 1:
                    canExit = false;
                    break;
                default:
                    break;
            }
            return canExit;
        }
    });



    private List<ItemObject> getAllItemObject(){
        ItemObject itemObject = null;
        List<ItemObject> items = new ArrayList<>();
        items.add(new ItemObject("ETA Prospect", "eta_prospect"));
        items.add(new ItemObject("ETA Calling", "eta_calling"));
        items.add(new ItemObject("ETA Order", "eta_order"));
        items.add(new ItemObject("ETA Mega Four", "eta_mega_four"));
        items.add(new ItemObject("ETA CV", "eta_cv"));
        items.add(new ItemObject("ETA Training", "eta_training"));
        return items;
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
