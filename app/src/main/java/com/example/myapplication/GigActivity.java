package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.*;

public class GigActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView providerIcon, BackgroundImage;
    private TextView gig_name, provider_name, cost, address, description;
    private Button message_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gig2);
        Intent intent = getIntent();
        Toolbar toolbar = findViewById(R.id.toolbar);
        providerIcon = (ImageView) findViewById(R.id.providerIcon);
        BackgroundImage = (ImageView) findViewById(R.id.bgImage);

        gig_name = (TextView) findViewById(R.id.gigName);
        provider_name = (TextView) findViewById(R.id.provider_name);
        cost = (TextView) findViewById(R.id.costName);
        address = (TextView) findViewById(R.id.address);
        description = (TextView) findViewById(R.id.description);
        message_button = (Button) findViewById(R.id.msgButton);

        final String BackgroundimageId = intent.getStringExtra("backGround");
        final String gigName = intent.getStringExtra("gigName");
        final String providerName = intent.getStringExtra("providerName");
        final String description_text = intent.getStringExtra("description");
        final String costText =  intent.getStringExtra("cost");
        final String addressText = intent.getStringExtra("address");
        final String message_button_text = intent.getStringExtra("message");

        gig_name.setText(gigName);
        provider_name.setText(providerName);
        cost.setText(costText);
        address.setText(addressText);
        description.setText(description_text);


        switch (BackgroundimageId){
            case "1":
                BackgroundImage.setImageResource(R.drawable.lawnbg);
                providerIcon.setImageResource(R.drawable.isonkh);
                break;
            case "2":
                BackgroundImage.setImageResource(R.drawable.photoervices);
                providerIcon.setImageResource(R.drawable.dwayne);
                break;
            case "3":
                BackgroundImage.setImageResource(R.drawable.computerrepairbg);
                providerIcon.setImageResource(R.drawable.iconjen);
                break;
            case "4":
                BackgroundImage.setImageResource(R.drawable.carrepair);
                providerIcon.setImageResource(R.drawable.iconemma);
                break;
                default:
                    break;
        }

        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

        final String message = intent.getStringExtra("mobileNumber");



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", message);
                smsIntent.putExtra("sms_body","Hello There, I am in need of your services, Please reply to this message at your earliest convenience. \n Thank you");
                startActivity(smsIntent);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gig, menu);
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

        if (id == R.id.nav_home) {
            Intent backToMap = new Intent(GigActivity.this, MapsActivity.class);
            startActivity(backToMap);
//            onBackPressed();
        } else if (id == R.id.nav_gallery) {
            Intent backToMap = new Intent(GigActivity.this, MapsActivity.class);
            startActivity(backToMap);
//            onBackPressed();

        } else if (id == R.id.nav_slideshow) {
            Intent login = new Intent(GigActivity.this, LoginActivity.class);
            startActivity(login);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }
}
