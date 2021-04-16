package com.app.zozm.activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.app.zozm.BuildConfig;
import com.app.zozm.R;
import com.google.android.material.navigation.NavigationView;

// pushing code form qazi ammar mac
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout drawerLayout;
    View layertwo, layerthree, layerone;
    TextView version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNavigationDrawer();

    }

    public void initNavigationDrawer() {

        layerone = findViewById(R.id.layerone);
        layerthree = findViewById(R.id.layerthree);
        layertwo = findViewById(R.id.layertwo);
        layertwo.setOnClickListener(this);
        layerthree.setOnClickListener(this);
        layerone.setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View termCondition = navigationView.findViewById(R.id.tv_termcondition);
        View bankView = navigationView.findViewById(R.id.tv_bank);
        View phoneView = navigationView.findViewById(R.id.tv_phone);
        View verisonView = navigationView.findViewById(R.id.tv_version);
        phoneView.setOnClickListener(this);
        bankView.setOnClickListener(this);
        termCondition.setOnClickListener(this);
        verisonView.setOnClickListener(this);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                return true;
            }
        });
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.isDrawerOpen(Gravity.RIGHT);
        drawerLayout.closeDrawer(Gravity.RIGHT);

        version = navigationView.findViewById(R.id.version);
        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(this.getPackageName(), 0);
            String versionName = pInfo.versionName;
            version.setText("v " + versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    drawerLayout.closeDrawer(Gravity.RIGHT);
                } else {
                    drawerLayout.openDrawer(Gravity.RIGHT);
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.setting_icon) {
            if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                drawerLayout.closeDrawer(Gravity.RIGHT);
            } else {
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        } else {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.layerone:

                Intent intentItem = new Intent(this, ItemCatagoryActivity.class);
                startActivity(intentItem);

                break;
            case R.id.layertwo:

                Intent intent = new Intent(this, TermofUseActivity.class);
                startActivity(intent);

                break;

            case R.id.layerthree:

                Intent intent1 = new Intent(this, ContactUsActivity.class);
                startActivity(intent1);

                break;

            case R.id.tv_termcondition:

                Intent intent2 = new Intent(MainActivity.this, TermConditionActivity.class);
                startActivity(intent2);
                drawerLayout.closeDrawers();

                break;

            case R.id.tv_bank:
                Intent intentbank = new Intent(MainActivity.this, BankDetailActivity.class);
                startActivity(intentbank);
                drawerLayout.closeDrawers();
                break;
            case R.id.tv_phone:
                Intent intentPhone = new Intent(MainActivity.this, ContactUsActivity.class);
                startActivity(intentPhone);
                drawerLayout.closeDrawers();
                break;
            case R.id.tv_version:
                Intent intentVerison = new Intent(MainActivity.this, VersionActivity.class);
                startActivity(intentVerison);
                drawerLayout.closeDrawers();
                break;

        }
    }
}