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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.dnp.sieta.R;
import com.dnp.sieta.adapter.GridViewAdapter;
import com.dnp.sieta.object.ItemObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MartActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.gridview)
    GridView gridview;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.static_spinner)
    Spinner staticSpinner;
    Activity context = this;

    private boolean canExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mart);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        List<ItemObject> allItems = getAllItemObject();
        GridViewAdapter customAdapter = new GridViewAdapter(MartActivity.this, allItems);
        gridview.setAdapter(customAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(HomeActivity.this, "Position: " + position, Toast.LENGTH_SHORT).show();
                if(position==0){
                    startActivity(new Intent(getApplicationContext(), MartDetailActivity.class));
                    finish();
                }
                else if(position==1){
                    startActivity(new Intent(getApplicationContext(), MartDetailActivity.class));
                    finish();
                }
                else if(position==2){
                    startActivity(new Intent(getApplicationContext(), MartDetailActivity.class));
                    finish();
                }
                else if(position==3){
                    startActivity(new Intent(getApplicationContext(), MartDetailActivity.class));
                    finish();
                }
                else if(position==4){
                    startActivity(new Intent(getApplicationContext(), MartDetailActivity.class));
                    finish();
                }
                else if(position==5){
                    startActivity(new Intent(getApplicationContext(), MartDetailActivity.class));
                    finish();
                }
            }
        });

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.kategori_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);

    }



    private List<ItemObject> getAllItemObject(){
        ItemObject itemObject = null;
        List<ItemObject> items = new ArrayList<>();
        items.add(new ItemObject("Mistica 730ml", "mistica"));
        items.add(new ItemObject("Klorofil", "klorofil"));
        items.add(new ItemObject("Proargi", "proargi"));
        items.add(new ItemObject("Calcium Mag", "calcium"));
        items.add(new ItemObject("Mistica 730ml", "mistica"));
        return items;
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
            Toast.makeText(MartActivity.this, "Fitur ini belum tersedia", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
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
